import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述：Java爬取图片 <br>
 * 作者：allron <br>
 * 修改日期：2021/8/22 10:51 <br>
 * E-mail: hyshizhe@163.com <br>
 */
public class PictureSpider {

    public static void main(String[] args) throws IOException {
        String url = "https://699pic.com/tupian/meinv.html";
        Document document = Jsoup.connect(url).get();
        Elements elements = document.select("img.lazy");
        for (org.jsoup.nodes.Element element : elements) {
            String imgUrl = element.attr("data-original");
            String pictureName = element.attr("alt");
            URL urlConn = new URL("http:" + imgUrl);
            URLConnection urlConnection = urlConn.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            String filePath = "C:\\Users\\Administrator\\Desktop\\temp\\";
            String fileName = pictureName + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS")) + ".jpg";
            OutputStream outputStream = new FileOutputStream(new File(filePath + fileName));
            byte[] b = new byte[1024];
            int count = 0;
            while ((count = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, count);
            }
            outputStream.close();
            inputStream.close();
            System.out.println(fileName + " 下载完成。");
        }
        System.out.println(elements.size() + "张图下载完成。");
    }
}
