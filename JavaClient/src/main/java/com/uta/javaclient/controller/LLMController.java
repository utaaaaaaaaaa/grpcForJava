package com.uta.javaclient.controller;

import com.uta.javaclient.common.BaseResponse;
import com.uta.javaclient.rpc.GetLLMResp;
import com.uta.javaclient.service.LLMClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class LLMController {

    private static final Logger log = LoggerFactory.getLogger(LLMController.class);

    @Autowired
    private LLMClientService llmClientService;

    @PostMapping("/chat")
    public BaseResponse<String> chat(@RequestBody String prompt) {
        try {
            CompletableFuture<GetLLMResp> future = llmClientService.predict(prompt);
            GetLLMResp getLLMResp = future.get(2, TimeUnit.MINUTES);
            String output = getLLMResp.getOutput();
            log.info(output);
            return new BaseResponse<>(200,output,"success");
        }catch (Exception e){
            throw new RuntimeException("llm run error"+ e);
        }
    }

}
