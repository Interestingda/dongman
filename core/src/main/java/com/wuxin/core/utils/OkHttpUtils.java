package com.wuxin.core.utils;

import okhttp3.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Author:TangHong
 * data:2022/10/24
 */
@Component
public class OkHttpUtils {
    public static String url = "https://m3u8.apiyhzy.com/api.php/provide/vod/?ac=detail&pg=";

    public String request(int pg) throws IOException {
        String url1=url+pg;
        System.out.println(url1);
        OkHttpClient client = new OkHttpClient();
//        RequestBody body = new FormBody.Builder()
//
//                .build();
        Request request = new Request.Builder()
                .get()
                .url(url1)
                .build();

        Response response = client.newCall(request).execute();

        String string = response.body().string();
        if (!StringUtils.isEmpty(string)){
        return string;
    }
return null;
}}
