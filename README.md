# JAVA SDK 接入指南 & CHANGELOG

## API接入指南
  1. 检查Java版本 java >= 1.8
  2. 添加Java的编译选项 -parameters
  3. 修改resources/config.properties中的appKey和secret配置，将开发者中心后台申请的应用沙箱的appKey和secret填入配置文件
  4. 使用sdk提供的功能进行开发调试
  5. 上线前将config.properties中sandbox值设为false以及将appKey和secret设为正式配置
 
## 消息回调接入指南
  sdk内置了一个简单的callback http server（demo/callback.java）,可供消息回调的调试。
  
   1. 执行 **gradle clean build -x test** 命令，生成build/libs/java-sdk.jar文件
   2. 执行 **java -jar build/libs/java-sdk.jar** ，此时会在本地启动一个http server，默认端口8888
   3. 执行 **curl http://localhost:8888/callback** ，返回 {"message":"ok"} 表示服务启动成功
   4. 将java-sdk.jar部署到你的服务器上，在开发者后台填入回调请求的地址，开放平台会向此地址POST消息
 
## API调用代码示例
 
 - 第一步 初始化一些对象

```java
     private static Injector injector;
     private static ClientCredentials clientCredentials;
     static {
         injector = Guice.createInjector(new InjectionModule());
         clientCredentials = injector.getInstance(ClientCredentials.class);
     }
```
 
 - 第二步 使用oauth2.0客户端授权模式获取Token信息，需要注意的是，此token在有效期内可重复使用，请将其全局保存，不要每次接口调用前申请一次Token

```java
    Token token = clientCredentials.getAccessToken();
```

 - 第三步 将上一步获取到的Token对象存储到API调用的全局上下文

```java
    ClientContext.setToken(token);
```
 
 - 第四步 实例化一个资源服务，例如店铺服务

```java
    ShopService shopService = injector.getInstance(ShopService.class);         
```
 
 - 第五步 调用接口，获取资源数据

```java
     OShop shop = shopService.getShop(12345);
```
 

## CHANGELOG:

### [v1.0.8]

    Release Date : 2017-01-05

  - [Bugfix] 为了解决序列号冲突，OShop结构体中oOrderMode重命名为orderMode,mUrl重命名为mobileUrl

### [v1.0.7]

    Release Date : 2017-01-04

  - [Improvement] 对token的时效进行了本地校验

### [v1.0.6]

    Release Date : 2016-12-28

  - [Bugfix] OOrder结构体boolean类型的参数命名去除了is前缀

### [v1.0.5]

    Release Date : 2016-12-28

  - [Improvement] 篮子商品中新增字段skuId

### [v1.0.4]

    Release Date : 2016-12-26

  - [Bugfix] 修复订单解析失败的问题
  - [Feature] 新增获取推送未到达的消息实体的接口

### [v1.0.3]

    Release Date : 2016-12-21

  - [Bugfix] 修复Excpetion引起的的null异常
  - [Bugfix] 修复沙箱环境获取token的地址
  - [Bugfix] 修复了参数为空时的错误提示

### [v1.0.2]

    Release Date : 2016-12-6

  - [Feature] sdk新增批量清空货，补满货，上架，下架的接口
  - [Bugfix] 修改店铺结构体

### [v1.0.1]

    Release Date : 2016-11-29

  - [Bugfix] 回调消息返回值改为{"message":"ok"}
  
### [v1.0.0]

    Release Date : 2016-11-19

  - [Feature] sdk 实现接口定义以及功能实现
  - [Feature] demo 实现接口调用示例
