# grpcForJava
Python提供大模型作为服务端，Java通过grpc调用接口

服务端直接将Python服务注册到gRPC, Java客户端根据端口号通过gRPC注册中心调用服务端服务。具体过程如下：

Python服务端将服务直接注册到gRPC注册中心，Java客户端通过端口号映射请求相关的服务，gRPC协议层接受服务之后，由应用层对服务进行处理，可以直接调用注册的服务实例，服务计算完成之后返回结果给gRPC，响应回调通知线程，Java客户端接收返回的结果。

### 安装依赖
Python: ```pipinstall grpcio / pipinstall grpcio-tls```
Java在maven中添加对应依赖
```xml
<!-- gRPC 依赖 -->
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-netty-shaded</artifactId>
            <version>1.72.0</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-protobuf</artifactId>
            <version>1.72.0</version>
        </dependency>
        <dependency>
            <groupId>io.grpc</groupId>
            <artifactId>grpc-stub</artifactId>
            <version>1.72.0</version>
        </dependency>
        <dependency> <!-- necessary for Java 9+ -->
            <groupId>org.apache.tomcat</groupId>
            <artifactId>annotations-api</artifactId>
            <version>6.0.53</version>
            <scope>provided</scope>
        </dependency>
<!-- Protobuf 编译插件 -->
            <plugin>
                <groupId>org.xolstice.maven.plugins</groupId>
                <artifactId>protobuf-maven-plugin</artifactId>
                <version>0.6.1</version>
                <configuration>
                    <!-- 指定输出到源码目录 -->
                    <outputDirectory>${project.basedir}/src/main/java</outputDirectory>
                    <clearOutputDirectory>false</clearOutputDirectory>
                    <!-- 保持其他配置不变 -->
                    <protocArtifact>com.google.protobuf:protoc:3.25.5:exe:${os.detected.classifier}</protocArtifact>
                    <pluginId>grpc-java</pluginId>
                    <pluginArtifact>io.grpc:protoc-gen-grpc-java:1.72.0:exe:${os.detected.classifier}</pluginArtifact>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>compile</goal>
                            <goal>compile-custom</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
```
### 分别编写proto文件
Python: 
```proto
syntax = "proto3";

package server;

service LLMService {
    rpc GetLLM(GetLLMRequest) returns (GetLLMResp) {};
}

message GetLLMRequest {
    string input = 1;
}

message GetLLMResp {
    string output = 1;
}
```
Java:
```
syntax = "proto3";

package server;
option java_package = "com.uta.javaclient.rpc";
option java_outer_classname = "GetLLMServiceProto";
option java_multiple_files = true;

service LLMService {
  rpc GetLLM(GetLLMRequest) returns (GetLLMResp) {};
}

message GetLLMRequest {
  string input = 1;
}

message GetLLMResp {
  string output = 1;
}
```
注意： 除了option部分全部保持一致

### 利用protobuf自动生成代码

Python:  ```python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. ./llm.proto```

Java:  ```mvn clean install```

### 编写对应server client端代码
.......
具体参考官方文档
> [gRPC 官方文档中文版](https://doc.oschina.net/grpc?t=58009)

### 最后先运行服务端，后运行客户端

### 混合架构建议
![0ec95a35b89ae](https://github.com/user-attachments/assets/31bf1ed1-fe08-4290-9fe2-e05f539e080c)

### 总结

​​gRPC​​：适合 ​​***高性能、强类型、流式***​​ 的内部服务通信

​​HTTP​​：适合 ​​***快速开发、对外兼容、简单交互***​​ 的场景

​​***终极建议​​***：内部服务用 gRPC，对外接口用 HTTP，通过网关桥接两者优势。
