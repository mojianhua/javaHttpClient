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
import java.util.Map;

public class HttpGetParamU8Token {
    //U8token
    public static void main(String[] args) throws Exception{
//        //获取token
//        String tokenUrl = "https://api.yonyouup.com/system/token";
//        URIBuilder uriBuilder = new URIBuilder(tokenUrl);
//        uriBuilder.setParameter("from_account","lthink").
//                setParameter("app_key","xxxx").
//                setParameter("app_secret","xxxx");
//
//        String response = null;
//        response = doGet(uriBuilder.build().toString());
//        System.out.println(response);
        //System.out.close();
//
//        //json转对象
//        JSONTokener tokener = new JSONTokener(response);
//        JSONObject object = (JSONObject) tokener.nextValue();
////        //System.out.println(object.getString("errcode"));
//        String token = "";
//        token = object.getJSONObject("token").getString("id");
//        System.out.println(token);
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
        //获取总订单数
//        int page_count = 0;
//        page_count = object2.getInt("page_count");
        for (int i = 1;i <= 1 ;i++){
            //获取订单呢列表
            String orderUrl = "https://api.yonyouup.com/api/saleorderlist/batch_get";
            URIBuilder uriBuilder2 = new URIBuilder(orderUrl);
            uriBuilder2.setParameter("from_account","lthink").
                    setParameter("to_account","lthink").
                    setParameter("app_key","xxxxxx").
                    setParameter("token","xxxx").
                    setParameter("page_index",  Integer.toString(i)).
                    setParameter("rows_per_page","20");
            String orderList = "";
            orderList = doGet(uriBuilder2.build().toString());

            JSONTokener orderListtokener = new JSONTokener(orderList);
            JSONObject orderListObject = (JSONObject) orderListtokener.nextValue();
            for(int j= 0; j < orderListObject.getJSONArray("saleorderlist").length();j++){
                String OrderListInfo = orderListObject.getJSONArray("saleorderlist").get(j).toString();
                JSONTokener listInfoTokener = new JSONTokener(OrderListInfo);
                JSONObject listInfoObject = (JSONObject) listInfoTokener.nextValue();
                System.out.println(listInfoObject);

                if(listInfoObject.has("businesstype")){
                    System.out.println(listInfoObject.getString("businesstype"));
                }

                if(listInfoObject.has("typecode")){
                    System.out.println(listInfoObject.getString("typecode"));
                }

                if(listInfoObject.has("typename")){
                    System.out.println(listInfoObject.getString("typename"));
                }

                if(listInfoObject.has("state")){
                    System.out.println(listInfoObject.getString("state"));
                }

                if(listInfoObject.has("custcode")){
                    System.out.println(listInfoObject.getString("custcode"));
                }

                if(listInfoObject.has("cusname")){
                    System.out.println(listInfoObject.getString("cusname"));
                }

                if(listInfoObject.has("cusabbname")){
                    System.out.println(listInfoObject.getString("cusabbname"));
                }

                if(listInfoObject.has("deptcode")){
                    System.out.println(listInfoObject.getString("deptcode"));
                }

                if(listInfoObject.has("deptname")){
                    System.out.println(listInfoObject.getString("deptname"));
                }

                if(listInfoObject.has("personcode")){
                    System.out.println(listInfoObject.getString("personcode"));
                }

                if(listInfoObject.has("personname")){
                    System.out.println(listInfoObject.getString("personname"));
                }

                if(listInfoObject.has("dpremodatebt")){
                    System.out.println(listInfoObject.getString("dpremodatebt"));
                }

                if(listInfoObject.has("dpredatebt")){
                    System.out.println(listInfoObject.getString("dpredatebt"));
                }

                if(listInfoObject.has("sendaddress")){
                    System.out.println(listInfoObject.getString("sendaddress"));
                }

                if(listInfoObject.has("ccusperson")){
                    System.out.println(listInfoObject.getString("ccusperson"));
                }

                if(listInfoObject.has("ccuspersoncode")){
                    System.out.println(listInfoObject.getString("ccuspersoncode"));
                }

                if(listInfoObject.has("caddcode")){
                    System.out.println(listInfoObject.getString("caddcode"));
                }

                if(listInfoObject.has("memo")){
                    System.out.println(listInfoObject.getString("memo"));
                }

                if(listInfoObject.has("money")){
                    System.out.println(listInfoObject.getString("money"));
                }

                if(listInfoObject.has("sum")){
                    System.out.println(listInfoObject.getString("sum"));
                }

                if(listInfoObject.has("maker")){
                    System.out.println(listInfoObject.getString("maker"));
                }

                if(listInfoObject.has("verifier")){
                    System.out.println(listInfoObject.getString("verifier"));
                }

                if(listInfoObject.has("closer")){
                    System.out.println(listInfoObject.getString("closer"));
                }

                System.out.println("------------------------------------------");
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
