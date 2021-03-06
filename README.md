# JAVA SDK 接入指南 & CHANGELOG

## API接入指南
  1. 检查Java版本 java >= 1.6
  2. 修改resources/config.properties中的appKey和secret以及callback_ur配置，将开发者中心后台申请的应用沙箱的appKey和secret填入配置文件，，填写callback_url
  3. 使用sdk提供的功能进行开发调试
  4. 上线前将config.properties中sandbox值设为false以及将appKey和secret以及callback_url设为正式配置

## API调用代码示例

### 企业应用

  - 第一步 创建OAuthClient对象

```java
    OAuthClient oAuthClient = new OAuthClient();
```

  - 第二步 获取生成授权url

```java
    String authUrl = oAuthClient.getAuthUrl(state, scope);
```

  - 第三步 在授权url中同意授权后，会跳转到CALLBACK_URL的页面，在通过链接上的参数，获取授权码code

  - 第四步 通过code获取Token对象，要注意的是，此token在有效期内可重复使用，请将其全局保存，不要每次接口调用前申请一次Token

```java
    Token token = oAuthClient.getTokenByCode(code);
```

  - 第六步 实例化一个资源服务并注入token，例如店铺服务

```java
    ShopService shopService = new ShopService(token);
```
 
  - 第七步 调用接口，获取资源数据

```java
    OShop shop = shopService.getShop(12345);
```

  - 第八步 如果token过期，通过refreshToken换取新的token

```java
    Token freshToken = oAuthClient.getTokenByRefreshToken(token.getRefreshToken(), scope);
```

### 个人应用

  - 第一步 创建OAuthClient对象

```java
    OAuthClient oAuthClient = new OAuthClient();
```

  - 第二步 获取Token对象，要注意的是，此token在有效期内可重复使用，请将其全局保存，不要每次接口调用前申请一次Token

```java
    Token token = oAuthClient.getTokenInClientCredentials();
```

  - 第三步 实例化一个资源服务并注入token，例如店铺服务

```java
    ShopService shopService = new ShopService(token);
```

  - 第四步 调用接口，获取资源数据

```java
    OShop shop = shopService.getShop(12345l);
```

## CHANGELOG:

### [v2.1.8]

    Release Date : 2017-03-31

- [Feature] 订单服务服务新增配送异常或者物流拒单后选择自行配送接口
- [Feature] 订单服务服务新增配送异常或者物流拒单后选择不再配送接口
- [Feature] 订单的篮子商品的实体中新增属性、规格、条形码、扩展码和重量


### [v2.1.7]

    Release Date : 2017-03-22

- [Feature] 订单服务服务新增获取订单配送记录接口
- [Feature] 订单服务服务新增批量获取订单最新配送记录接口
- [BugFix] 修复了在不同平台，有可能导致签名计算错误的问题

### [v2.1.6]

    Release Date : 2017-03-17

- [Feature] 商品服务新增设置商品排序接口
- [Feature] 商品分类服务新增设置分类排序接口
- [Feature] 商品服务新增批量更新库存接口
- [Feature] 商品规格中新增条形码，扩展码和重量
- [Feature] 商品中新增属性和售卖时间

### [v2.1.5]

    Release Date : 2017-02-22

- [Bugfix] 移除OrderService中已废弃的方法getShopOrderIds

### [v2.1.4]

    Release Date : 2017-02-15

- [Feature] OUser中userId与OMessage中的userId的类型统一为long

### [v2.1.3]

    Release Date : 2017-02-10

- [Feature] OUser中增加授权的店铺列表OAuthorizedShop
- [Feature] 所有接口的店铺id的类型由int更变为long

### [v2.1.2]

    Release Date : 2017-02-07

- [Feature] ShopService中的UpdateShop方法，可更新的参数由isValid更变为isOpen
- [Feature] 优化了OauthClient类的日志打印

### [v2.1.1]

    Release Date : 2017-01-24

- [Feature] 重新支持个人应用授权，在OAuthClient中添加getTokenInClientCredentials方法

### [v2.1.0]

    Release Date : 2017-01-24

- [Feature] 更新了授权模式为企业应用授权，个人应用授权的方法不在支持，对应的工具类由ClientCredentials更换为OAuthClient
- [Bugfix] OUser中的userId的类型由long改为String
- [Bugfix] 修复了UploadService无法正常使用的问题

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

- [Bugfix] 修复Exception引起的的null异常
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
