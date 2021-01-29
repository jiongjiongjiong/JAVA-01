package com.zc.week02;


import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

/**
 * @author: zhangc
 * @date: 2021/1/22
 * @desc:
 */
@Slf4j
public class OkHttpTest {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request build = new Request.Builder().url("http://localhost:8802").build();
        try(Response response = client.newCall(build).execute()){
            log.info("request localhost:8801 response: {} ",Objects.requireNonNull(response.body()).string());
        }
    }
}
