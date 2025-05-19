package com.lilemy.lilemyaiagent.controller;

import com.lilemy.lilemyaiagent.common.BaseResponse;
import com.lilemy.lilemyaiagent.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public BaseResponse<String> healthCheck() {
        return ResultUtils.success("ok");
    }
}