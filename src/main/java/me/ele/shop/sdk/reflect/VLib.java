package me.ele.shop.sdk.reflect;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.google.common.io.Files;
import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class VLib {
    private VLib() {}

    @Data
    public static class LibInfo {
        private String title;
        private String vendor;
        private String version;
        private String filepath;
        private String filename;
    }

    private static final Set<String> nonJarPathSubStrings = Sets.newHashSet();
    private static final List<String> jarPaths = Lists.newArrayList();
    private static final Set<String> classNamesNotInJar = Sets.newHashSet();
    static {
        String jreSuffix = File.separator + "jre";
        String javaHomePath = System.getProperty("java.home");
        if (javaHomePath.endsWith(jreSuffix)) {
            javaHomePath = javaHomePath.substring(0, javaHomePath.length() - jreSuffix.length());
        }
        nonJarPathSubStrings.add(javaHomePath.toLowerCase());
        nonJarPathSubStrings.add("intellij");

        String classPathString = System.getProperty("java.class.path");
        List<String> paths = Splitter.on(File.pathSeparator).splitToList(classPathString);

        for (String path : paths) {
            File file = new File(path);
            if (file.isDirectory()) {
                for (File iFile : Files.fileTreeTraverser().preOrderTraversal(file)) {
                    String filePath = iFile.getPath();
                    if (isValidJarPath(filePath)) {
                        jarPaths.add(filePath);
                    } else if (filePath.endsWith(".class")) {
                        int startIndex = file.getPath().length() + 1;
                        int endIndex = filePath.length() - ".class".length();
                        String className = filePath.substring(startIndex, endIndex);
                        className = className.replace('/', '.');
                        classNamesNotInJar.add(className);
                    }
                }
            } else if (file.isFile() && isValidJarPath(file.getPath())) {
                jarPaths.add(file.getPath());
            }
        }
        jarPaths.sort(Ordering.from(String.CASE_INSENSITIVE_ORDER));
    }

    private static final Map<String, Set<String>> classNamesMap = Maps.newHashMap();
    private static final Map<String, LibInfo> libInfoMap = Maps.newHashMap();

    private static boolean isValidJarPath(String path) {
        return path.endsWith(".jar") && !nonJarPathSubStrings.stream().anyMatch(path.toLowerCase()::contains);
    }

    private static Set<String> getClassNamesInJar(String jarPath) {
        if (!classNamesMap.containsKey(jarPath)) {
            Set<String> classNames = Sets.newHashSet();
            try {
                ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                        // This ZipEntry represents a class. Now, what class does it represent?
                        String className = entry.getName().replace('/', '.'); // including ".class"
                        className = className.substring(0, className.length() - ".class".length());
                        classNames.add(className);
                    }
                }
            } catch (IOException ex) {
                throw new IllegalStateException(String.format("Read jar file [%s] failed", jarPath));
            }
            classNamesMap.put(jarPath, classNames);
        }
        return classNamesMap.get(jarPath);
    }

    private static LibInfo getLibInfo(String jarPath) {
        if (!libInfoMap.containsKey(jarPath)) {
            LibInfo info = new LibInfo();
            info.setFilepath(jarPath);
            info.setFilename(jarPath.substring(jarPath.lastIndexOf(File.separator) + 1));

            Class<?> firstClass = null;
            for (String className : getClassNamesInJar(jarPath)) {
                try {
                    firstClass = VType.getType(className);
                } catch (Throwable ex) {
                    // Do nothing
                    int a = 1;
                }
            }

            if (firstClass != null) {
                Package pkg = firstClass.getPackage();
                info.setTitle(pkg.getSpecificationTitle() != null ? pkg.getSpecificationTitle() : pkg.getImplementationTitle());
                info.setVendor(pkg.getSpecificationVendor() != null ? pkg.getSpecificationVendor() : pkg.getImplementationVendor());
                info.setVersion(pkg.getSpecificationVersion() != null ? pkg.getSpecificationVersion() : pkg.getImplementationVersion());
            }

            libInfoMap.put(jarPath, info);
        }
        return libInfoMap.get(jarPath);
    }

    public static Set<LibInfo> getLibInfos() {
        return jarPaths.stream()
                .map(VLib::getLibInfo)
                .collect(Collectors.toSet());
    }

    public static Set<String> getClassNamesInPackage(String packageName) {
        Set<String> classNamesInLib = Sets.newHashSet(classNamesNotInJar);
        jarPaths.forEach(jarPath -> classNamesInLib.addAll(getClassNamesInJar(jarPath)));
        return classNamesInLib.stream()
                .filter(className -> className.startsWith(packageName))
                .collect(Collectors.toSet());
    }
}
