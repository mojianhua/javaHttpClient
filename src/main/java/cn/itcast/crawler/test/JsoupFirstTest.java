package cn.itcast.crawler.test;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.net.URL;
import java.util.Set;

public class JsoupFirstTest {

    public static void main(String[] args) throws Exception{
        //解释url地址，第一个参数是url,第二个参数是访问时间的超时时间
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn"),10000);
        //使用标签选择器
        String title = doc.getElementsByTag("title").first().text();

        //使用工具类读取文件，获取字符串,第一个参数是文件路径，第二个参数编码
        String content = FileUtils.readFileToString(new File("src/html/test.html"),"utf8");
        //System.out.println(content);

        //根据id查询元素
        doc = Jsoup.parse(new File("src/html/test.html"),"utf8");
        Element element = doc.getElementById("abc");
        //根据标签获取元素
        element = doc.getElementsByTag("li").first();

        //根据class获取元素
        element = doc.getElementsByClass("testa").first();

        //根据属性获取元素
        element = doc.getElementsByAttribute("att").first();
        //System.out.println("获取到的元素内容是：" + element.text());

        //根据id获取元素
        String str = "";
        element = doc.getElementById("test1");
        str = element.id();
        //System.out.println("获取到的数据是：" + str);
        //从元素中获取className
        Set<String> classSet = element.classNames();
        for (String s: classSet) {
            System.out.println(s);
        }

        //从元素中获取属性的attr
        str = element.attr("class");
        System.out.println("获取到的数据是：" + str);
        //System.out.println(content);
    }
}
