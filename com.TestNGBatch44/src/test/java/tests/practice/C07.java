package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C07 {
/*
...Exercise4...
https://www.teknosa.com/ adresine gidiniz
arama cubuguna oppo yazip enter deyiniz
sonuc sayisini yazdiriniz
cikan ilk urune tiklayiniz
sepete ekleyiniz
sepetime git e tiklayiniz
consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
Alisverisi tamamlayiniz
son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
driver i kapatiniz

*/

    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.teknosa.com/ ");

    }



























}
