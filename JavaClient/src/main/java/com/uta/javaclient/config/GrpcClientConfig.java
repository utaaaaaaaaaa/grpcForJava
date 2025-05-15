package com.uta.javaclient.config;

import com.uta.javaclient.rpc.LLMServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class GrpcClientConfig {

    @Value("${grpc.server.host}")
    private String host;

    @Value("${grpc.server.port}")
    private int port;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Bean
    public ManagedChannel channel() {
        return ManagedChannelBuilder.forAddress(host, port)
                .executor(threadPoolExecutor)
                .usePlaintext()
                .build();
    }

    @Bean
    public LLMServiceGrpc.LLMServiceBlockingStub llmServiceStub(ManagedChannel channel) {
        return LLMServiceGrpc.newBlockingStub(channel)
                .withExecutor(threadPoolExecutor);
    }

}
