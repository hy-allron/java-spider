import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述：<br>
 * 作者：allron <br>
 * 修改日期：2021/8/22 11:51 <br>
 * E-mail: hyshizhe@163.com <br>
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (i++ < 1000) {
            Thread.sleep(1);
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS")));
        }
    }
}
