# RestfulProtobuf
This is a Prototype for a standalone WAR. It offers a Restful service using Jersey/JAX-RS (JSR 311) and Google Protocol Buffers (protobuf).
My project is a feasibility study and is **NOT PRODUCTION READY**.
It was initially built using `Maven 3.0.4` and `Oracle JDK 1.8.0_45`.

# Quickstart
To enjoy the simplicity, you only have to execute three steps:

1. Clone Project from GitHub `git clone https://github.com/sam6-de/RestfulProtobuf.git`
2. Build Project using Maven `cd ./RestfulProtobuf/ && mvn clean install`
3. Start embedded Jetty `cd ./RestWebapp/target/ && java -jar RestWebapp-1.0-SNAPSHOT.war`

Now the service is up and running using port 8080. Simply connect via browser, for example by using http://localhost:8080/rest/hello/Simon

# Build from scratch
## Preparation
If you want to set up your Maven project as multi module project, you should first create a root `pom.xml`-file.

    mvn archetype:generate \
        -DarchetypeGroupId=org.codehaus.mojo.archetypes \
        -DarchetypeArtifactId=pom-root \
        -DarchetypeVersion=RELEASE \
        -DgroupId=de.sam6.demo \
        -DartifactId=RestfulProtobuf \
        -DinteractiveMode=false
In order to create a new/first submodule in the project, change the directory and use the Maven webapp archetype, that will create (most of) necessary folders and files:

    cd RestfulProtobuf/
    mvn archetype:generate \
        -DarchetypeArtifactId=maven-archetype-webapp \
        -DgroupId=de.sam6.demo \
        -DartifactId=RestWebapp \
        -DinteractiveMode=false
Because the `java` source folder is not created automatically, we have to do this manually:

    mkdir RestWebapp/src/main/java

Now you can import the whole multi-module-project into your favourite IDE.

## Dependencies
    <dependency>
        <groupId>com.sun.jersey</groupId>
        <artifactId>jersey-server</artifactId>
        <version>1.19</version>
    </dependency>