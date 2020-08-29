package cn.itcast.crawler.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

public class JsoupFirstSelector2Test {

    public static void main(String[] args) throws Exception{
        Document doc = Jsoup.parse(new File("src/html/test.html"),"utf8");

        //el#id：元素+ID，比如li#abc
        Element element = doc.select("li#abc").first();

        //el.class：元素+class,比如：li.testa
        element = doc.select("li.testa").first();

        //el[attr]：元素+属性名，比如：li[abc1]
        element = doc.select("li[abc1]").first();

        //任意组合：比如：li[abc1].s_name"
        element = doc.select("li[abc1].s_name").first();

        //ancestor child : 查找某个元素下元素，比如.city_con li，查找".city_con"下的li
        Elements elements = doc.select(".city_con li");
        for (Element element1 : elements){
            //System.out.println(element1.text());
        }

        //parent > child : 查找某个元素下的直接元素
        //比如：.city_con > ul > li 查找city_con第一级（直接子元素的ul）,再找所有ul下的第一级的li
        elements = doc.select(".city_con > ul > li");
        for (Element element1 : elements){
            System.out.println(element1.text());
        }
        System.out.println(element.text());
    }
}
