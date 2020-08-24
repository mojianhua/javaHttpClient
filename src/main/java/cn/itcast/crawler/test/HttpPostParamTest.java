package cn.itcast.crawler.test;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpPostParamTest {
    //带参数post获取页码数据
    public static void main(String[] args) throws Exception{
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpPost对象，设置url访问地址
        HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");
        //声明List集合，封装表单中的集合参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //设置请求地址http://yun.itheima.com/search搜索java
        params.add(new BasicNameValuePair("so","php"));
        params.add(new BasicNameValuePair("type","course"));
        params.add(new BasicNameValuePair("realhash","18fc53a52a033fe75f7d0542124ca8c0_2431097954372e846c29c49743f47853"));
        // 创建表单的Entity对象，第一个参数就是封装好的表单数据，第二个参数是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"utf8");
        // 设置表单的Entity对象到post请求中
        httpPost.setEntity(formEntity);
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求，获取response
            response = httpClient.execute(httpPost);
            //解释响应
            if(response.getStatusLine().getStatusCode() == 200){
                String content = EntityUtils.toString(response.getEntity(),"utf8");
                System.out.println(content.length());
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
