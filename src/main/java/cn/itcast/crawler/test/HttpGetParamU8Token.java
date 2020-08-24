package cn.itcast.crawler.test;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;

public class HttpGetParamU8Token {
    //U8token
    public static void main(String[] args) throws Exception{
//        //获取token
//        String tokenUrl = "https://api.yonyouup.com/system/token";
//        URIBuilder uriBuilder = new URIBuilder(tokenUrl);
//        uriBuilder.setParameter("from_account","xxxx").
//                setParameter("app_key","xxxxxx").
//                setParameter("app_secret","xxxxx");
//
//        String response = null;
//        response = doGet(uriBuilder.build().toString());
//
//        //json转对象
//        JSONTokener tokener = new JSONTokener(response);
//        JSONObject object = (JSONObject) tokener.nextValue();
//        //System.out.println(object.getString("errcode"));
//        String token = "";
//        token = object.getJSONObject("token").getString("id");
//
//        System.out.println(token);
//        //获取订单呢列表
//        String orderUrl = "https://api.yonyouup.com/api/saleorderlist/batch_get";
//        URIBuilder uriBuilder2 = new URIBuilder(orderUrl);
//        uriBuilder2.setParameter("from_account","xxxxxx").
//                    setParameter("to_account","xxxxxxx").
//                    setParameter("app_key","xxxxxxxxxxxx").
//                    setParameter("token","xxxxxx");
//        String orderList = "";
//        orderList = doGet(uriBuilder2.build().toString());
//
//
//        JSONTokener tokener2 = new JSONTokener(orderList);
//        JSONObject object2 = (JSONObject) tokener2.nextValue();
//        //获取总订单数
//        int page_count = 0;
//        page_count = object2.getInt("page_count");
        for (int i = 1;i <= 1 ;i++){
            //获取订单呢列表
            String orderUrl = "https://api.yonyouup.com/api/saleorderlist/batch_get";
            URIBuilder uriBuilder2 = new URIBuilder(orderUrl);
            uriBuilder2.setParameter("from_account","xxxxx").
                    setParameter("to_account","xxxx").
                    setParameter("app_key","xxxxxx").
                    setParameter("token","xxxxxx").
                    setParameter("page_index",  Integer.toString(i)).
                    setParameter("rows_per_page","20");
            String orderList = "";
            orderList = doGet(uriBuilder2.build().toString());

            JSONTokener tokener2 = new JSONTokener(orderList);
            JSONObject object2 = (JSONObject) tokener2.nextValue();
            //获取总订单数
            int page_count = 0;
            page_count = object2.getInt("page_count");
            for(int j= 0; j<object2.getJSONArray("saleorderlist").length();j++){
                  System.out.println(object2.getJSONArray("saleorderlist").get(j));
            }
        }
    }


    public static String doGet(String url){
        System.out.println(url);
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet(url);
        // 响应模型
        CloseableHttpResponse response = null;
        String content = null;
        try {
            //使用HttpClient发起请求，获取response
            response = httpClient.execute(httpGet);
            //解释响应
            if(response.getStatusLine().getStatusCode() == 200){
                content = EntityUtils.toString(response.getEntity(),"utf8");
                return content;
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
        return content;
    }
}
