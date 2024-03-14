# Demo project for JKube deployment

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/#build-image)


For Openshift Deployment:

- Java version: 17
- Maven commands:
~~~
mvn clean package oc:build -Popenshift
mvn oc:apply -Popenshift
~~~