package cn.itcast.crawler.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
public class JsoupFirstSelectorTest {

    public static void main(String[] args) throws Exception{
        Document doc = Jsoup.parse(new File("src/html/test.html"),"utf8");

//        //tagname：通过标签找元素，比如：li
//        Elements elements = doc.select("li");
//        for (Element element : elements){
//            System.out.println(element.text());
//        }

        //#id，通过ID查找元素，比如：#city_bj
        Element element = doc.select("#abc").first();

        //#.class：通过class名称查询元素，比如：.testa
        element = doc.select(".testa").first();

        //[attribute]:利用属性查找元素，比如：[abc1]
        element = doc.select("[abc1]").first();

        //[attr=value]:利用属性值查找元素，比如：[class=city_con]
        Elements elements = doc.select("[class=city_con]");
        for (Element element2 : elements){
            System.out.println(element2.text());
        }
        System.out.println("获取的结果是：" + element.text());
    }
}
