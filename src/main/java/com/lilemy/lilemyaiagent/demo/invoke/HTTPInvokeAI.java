package com.lilemy.lilemyaiagent.demo.invoke;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class HTTPInvokeAI implements CommandLineRunner {

    @Value("${my.ai.api-key}")
    private String apiKey;

    @Override
    public void run(String... args) throws Exception {
        // 替换为你的实际 API Key
        String apiKeyStr = apiKey;

        // 构建 JSON 请求体
        JSONObject json = new JSONObject();
        json.set("model", "qwen-plus");

        // 构建 messages 数组
        JSONArray messages = new JSONArray();
        messages.add(new JSONObject()
                .set("role", "system")
                .set("content", "You are a helpful assistant."));
        messages.add(new JSONObject()
                .set("role", "user")
                .set("content", "你是谁？"));

        JSONObject input = new JSONObject();
        input.set("messages", messages);

        JSONObject parameters = new JSONObject();
        parameters.set("result_format", "message");

        json.set("input", input);
        json.set("parameters", parameters);

        // 发送 POST 请求
        HttpResponse response = HttpRequest.post("https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation")
                .header("Authorization", "Bearer " + apiKeyStr)
                .header("Content-Type", ContentType.JSON.getValue())
                .body(json.toString())
                .execute();

        // 打印响应结果
        System.out.println("Response status: " + response.getStatus());
        System.out.println("Response body: " + response.body());
    }
}
