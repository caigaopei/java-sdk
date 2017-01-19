# JAVA SDK 接入指南 & CHANGELOG

## API接入指南
  1. 检查Java版本 java >= 1.6
  2. 修改resources/config.properties中的appKey和secret配置，将开发者中心后台申请的应用沙箱的appKey和secret填入配置文件
  3. 使用sdk提供的功能进行开发调试
  4. 上线前将config.properties中sandbox值设为false以及将appKey和secret设为正式配置

## API调用代码示例
 
 - 第一步 创建ClientCredentials对象

```java
     ClientCredentials clientCredentials = new ClientCredentials();
```
 
 - 第二步 使用oauth2.0客户端授权模式获取Token信息，需要注意的是，此token在有效期内可重复使用，请将其全局保存，不要每次接口调用前申请一次Token

```java
    Token token = clientCredentials.getAccessToken();
```

 - 第三步 实例化一个资源服务并注入token，例如店铺服务

```java
    ShopService shopService = injector.getInstance(token);
```
 
 - 第四步 调用接口，获取资源数据

```java
     OShop shop = shopService.getShop(12345);
```
 

## CHANGELOG:


### [v2.0.1]

    Release Date : 2017-01-19

  - [Feature] 新增了UserService

### [v2.0.0]

    Release Date : 2017-01-17

  - [Feature] java版本降低至1.6，去除了原有的反射和动态代理
  - [Feature] 改变了SDK的使用方法
  - [Feature] 以maven替换原有的gradle
  - [Improvement] 项目不再依赖lombok和gradle

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
