### Week02 作业题目（周三）
4.（必做）根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 和堆内存的总结，提交到 GitHub。


总结：

1.  堆太小，容易出现内存溢出
2. 堆太大，每次做GC占用时间太长，导致可服务时间变短，降低吞吐量
3. 日常设置过程中在不影响系统性能的前提下，堆内存尽量设置小，小不仅节约了资源，每次GC的效率最大化

### Week02 作业题目（周日）：
1.（必做）写一段代码，使用 `HttpClient` 或 `OkHttp` 访问 `http://localhost:8801` ，代码提交到 `GitHub`

```



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
        Request build = new Request.Builder().url("http://localhost:8801").build();
        try(Response response = client.newCall(build).execute()){
            log.info("request localhost:8801 response: {} ",Objects.requireNonNull(response.body()).string());
        }
    }
}

```