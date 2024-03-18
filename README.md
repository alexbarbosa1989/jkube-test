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
~~~
oc new-project jkube-test
~~~


3. Clone the project
~~~
git clone https://github.com/alexbarbosa1989/jkube-test
~~~

4. Move to the project directory
~~~
cd jkube-test
~~~

5. Deploy the application:

One-step process:
~~~
mvn clean package oc:deploy -Popenshift
~~~

Two-steps process:
~~~
mvn clean package oc:build -Popenshift
mvn oc:apply -Popenshift
~~~

The end of the deployment process will show a mave buld success process:
~~~
[INFO] oc: Updating Service from openshift.yml
[INFO] oc: Updated Service: target/jkube/applyJson/jkube-test/service-jkube-test-1.json
[INFO] oc: Updating DeploymentConfig from openshift.yml
[INFO] oc: Updated DeploymentConfig: target/jkube/applyJson/jkube-test/deploymentconfig-jkube-test-1.json
[INFO] oc: Updating Route from openshift.yml
[INFO] oc: Updated Route: target/jkube/applyJson/jkube-test/route-jkube-test.json
[INFO] oc: HINT: Use the command `oc get pods -w` to watch your pods start up
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:00 min
[INFO] Finished at: 2024-03-17T11:24:10-05:00
[INFO] ------------------------------------------------------------------------
~~~

You can  also validate the pod's status at the end of the process:
~~~
$ oc get pods
NAME                     READY   STATUS      RESTARTS   AGE
jkube-test-1-czddh       1/1     Running     0          9m31s
jkube-test-1-deploy      0/1     Completed   0          9m33s
jkube-test-s2i-1-build   0/1     Completed   0          10m
~~~

