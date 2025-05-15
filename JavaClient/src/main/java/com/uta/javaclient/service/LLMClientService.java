package com.uta.javaclient.service;

import com.uta.javaclient.config.ThreadPoolConfig;
import com.uta.javaclient.rpc.GetLLMRequest;
import com.uta.javaclient.rpc.GetLLMResp;
import com.uta.javaclient.rpc.LLMServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class LLMClientService {

    @Autowired
    private LLMServiceGrpc.LLMServiceBlockingStub llmServiceStub;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    //通过调用服务端实现方法
    public CompletableFuture<GetLLMResp> predict(String input){
        GetLLMRequest request = GetLLMRequest.newBuilder().setInput(input).build();

        try {
            //异步调用并返回结果
            CompletableFuture<GetLLMResp> future = CompletableFuture.supplyAsync(()-> llmServiceStub.getLLM(request)
                    ,threadPoolExecutor);

            return future;
        }catch (Exception e){
            throw new RuntimeException("Failed to call LLM service", e);
        }
    }

}
