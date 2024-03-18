# Demo project for JKube deployment

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/#build-image)

* [Official JKube documentation](https://eclipse.dev/jkube/docs/openshift-maven-plugin/#spring-boot-getting-started)

## For Openshift Deployment:


Environment:
- Openshift 4.x
- Java: OpenJDK 17


1. Log In your Openshift environment:
~~~
oc login -u <user> -p <password> https://<openshift_platform-url>
~~~

2. Create an Openshift project where will be deployed the application via JKube maven plugin

3. Clone the project
~~~
git clone https://github.com/alexbarbosa1989/jkube-test
~~~

4. Move to the project directory
~~~
cd jkube-test
~~~

5. Deploy the application
Two-steps process
~~~
mvn clean package oc:build -Popenshift
mvn oc:apply -Popenshift
~~~

One-step process:
~~~
mvn clean package oc:deploy -Popenshift 
~~~

