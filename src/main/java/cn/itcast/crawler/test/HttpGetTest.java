package cn.itcast.crawler.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpGetTest {
    //普通不带参数get获取页码数据
    public static void main(String[] args) {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求，获取response
            response = httpClient.execute(httpGet);
            //解释响应
            if(response.getStatusLine().getStatusCode() == 200){
                String content = EntityUtils.toString(response.getEntity(),"utf8");
                System.out.println(content);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭response
            try {
                response.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                httpClient.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
