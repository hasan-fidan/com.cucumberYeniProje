package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class QQ7 extends TestBase {
    /*
     // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
     // 2. CLICK ME of JavaScript Alert e tıklayın
     // 3. pop up text i alın
     // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
     // 5. pop up i kabul edin

     // Yine ayni class da baska test methodu olusturun
     // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
     // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
     // 3.  pop up text i alın
     // 4. Mesajın "Press a button!" olduğunu doğrulayın
     // 5. Açılır pencereyi kapat
     // 6. pop up i iptal edin,
     // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
     // 8. alert1'e göre dependsOnMethods kullanın
 */

    @Test
    public void test01() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));

        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();


        List<WebElement> emojiOgeler = driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        int size = emojiOgeler.size();
        System.out.println("size = " + size);

        for (WebElement each: emojiOgeler) {

            each.click();

        }









    }









}
