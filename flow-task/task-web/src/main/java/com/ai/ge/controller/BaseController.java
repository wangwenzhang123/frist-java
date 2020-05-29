package com.ai.ge.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class BaseController {

    @RequestMapping("/errorPage")
    public void printException(HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> result = (Map<String,String>) request.getAttribute("result");
        String json = JSON.toJSONStringWithDateFormat(result,"yyyy-MM-dd HH:mm:ss");
        printJson(json,response);
    }

    protected void printJson(String json, HttpServletResponse response) {
        if (response == null) {
            return;
        }

        try {
            response.setContentType("application/json;charset=UTF-8");

            if (json == null) {
                response.getWriter().write("{}");
            } else {
                response.getWriter().write(json);
            }
        } catch (IOException e) {

        }
    }
}
