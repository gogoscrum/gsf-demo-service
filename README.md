# General Service Framework (GSF)

[English](README.md) | [简体中文](README.zh-CN.md)

GSF is a lightweight, general-purpose low-code service framework developed using Java and Spring Boot. It aims to help developers easily build maintainable and scalable server-side applications.

This demo project showcases how to quickly create a simple RESTful API service using the GSF framework.

## 🛡️ License

This project is licensed under the **Apache License 2.0**.

You are free to:

- Use, modify, and distribute the software for **non-commercial** and **commercial** purposes (need to keep the logo and copyright info);
- Study the source code and contribute to the project.

## Quick start

- Clone the `gsf-core-service` project and install `shimi-gsf-core.jar` to your local Maven repository (refer to the README in the `gsf-core-service` project for specific steps)
- Clone the `gsf-demo-service` project to your local machine
- Copy `dist.application-dev.properties` to `application-dev.properties`
- Modify the database connection configuration in `application-dev.properties`
- Run `GsfDemoServiceApplication.java` to start the service
- Access [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) to view the API documentation
- Test the API directly in the Swagger UI or using Postman
- Check the server logs to confirm that data read and write operations are functioning correctly

## Report bugs

Join “GSF” project to submit bugs: [https://www.gogoscrum.com/invitations/9tXDjj4CyM4M]

## Developers community

Join GSF developer group on Discord: [https://discord.gg/FBdf43BZ]