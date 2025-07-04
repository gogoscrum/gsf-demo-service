# GSF演示项目

[English](README.md) | [简体中文](README.zh-CN.md)

GSF是一个轻量级通用低代码服务框架，使用Java语言和Spring Boot开发，旨在帮助开发者快速构建易维护、可扩展的服务端应用。

GSF演示项目展示了如何使用GSF框架快速创建一个简单的RESTful API服务。

## 🛡️ 授权协议

本项目基于 **Apache License 2.0** 进行授权。

您可以自由地：

- 出于**商业目的**和**非商业目的**使用、修改和分发本软件（需保留版权声明）；
- 学习源代码并为项目做出贡献。

若希望获得官方支持或定制开发服务，请联系我们。

## 快速开始

- 克隆 `gsf-core-service` 项目并安装 `shimi-gsf-core.jar` 至本地Maven仓库（具体步骤参考 `gsf-core-service` 项目内README文档）
- 克隆 `gsf-demo-service` 项目至本地
- 复制 `dist.application-dev.properties` 文件为 `application-dev.properties`
- 修改 `application-dev.properties` 中的数据库连接配置
- 运行 `GsfDemoServiceApplication.java` 启动服务
- 访问 [http://localhost:8080/swagger-ui/index.html) 查看API文档
- 直接在API页面中或者使用Postman测试接口
- 查看服务端日志，确认数据读写是否正常

## Bug提交

加入“GSF”项目，提交bug：[https://www.gogoscrum.com/invitations/9tXDjj4CyM4M]

## 交流社区

微信扫码加入GSF开发者交流群：\
<img src="https://gogoscrum.oss-cn-hangzhou.aliyuncs.com/materials/wechat-qr-gsf-dev-group.png" width="100">