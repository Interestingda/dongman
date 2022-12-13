package com.wuxin.domanservice.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.net.ssl.*;
import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;

/**
 * Atothor:aa
 * data:2022/10/20
 */
@Component
public class HttpsUtils {
    public static String url = "https://m3u8.apiyhzy.com/api.php/provide/vod/?ac=list&pg=";
//    private static ObjectMapper objectMapper = new ObjectMapper();
//    //映射关系配置
//    static {
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//    }

    public String getResponse(int pg) throws IOException {
//        System.setProperty("http.maxRedirects", "50");
//        System.getProperties().setProperty("proxySet", "true");
//        System.getProperties().put("https.proxyHost", "abc.com.cn");
//        System.getProperties().put("https.proxyPort", "3128");
        System.setProperty("https.protocols", "TLSv1");
        String strUrl = url + pg;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建HttpGet请求，相当于在浏览器输入地址

        HttpGet httpGet = new HttpGet(strUrl);

        CloseableHttpResponse execute = httpclient.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        String content = EntityUtils.toString(entity, "utf-8");

        return content;

    }
}
