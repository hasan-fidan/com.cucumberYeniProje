package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C06 {
//● Bir class olusturun: IframeTest02
//1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
//            2) sayfadaki iframe sayısını bulunuz.
//            3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
//            4) ilk iframe'den çıkıp ana sayfaya dönünüz
//            5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
//    tıklayınız

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/guru99home/");


    }

    @Test

    public void iframe() {
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        System.out.println(iframe.size());














    }



}
