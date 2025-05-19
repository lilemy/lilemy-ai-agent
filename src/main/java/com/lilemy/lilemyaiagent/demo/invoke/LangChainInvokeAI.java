package com.lilemy.lilemyaiagent.demo.invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class LangChainInvokeAI implements CommandLineRunner {

    @Value("${my.ai.api-key}")
    private String apiKey;

    @Override
    public void run(String... args) throws Exception {
        ChatLanguageModel qwenModel = QwenChatModel.builder()
                .apiKey(apiKey)
                .modelName("qwen-max")
                .build();
        String answer = qwenModel.chat("你好");
        System.out.println(answer);
    }
}
