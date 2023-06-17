package com.mojo.bi.api;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

/**
 * @author: zyl
 * @description: openAi接口调用  利用opai key 进行调用，按次数收费
 */
//@Service
public class OpenAiApi {

    public static void main(String[] args) {
        String url = "https://api.openai.com/v1/chat/completions";
        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "open ai key")
                .execute();
    }
}
