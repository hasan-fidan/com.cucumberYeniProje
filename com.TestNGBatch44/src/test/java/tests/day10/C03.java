package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03 {
//Bir class olusturun: IframeTest
//   ● https://the-internet.herokuapp.com/iframe adresine gidin.
//   ● Bir metod olusturun: iframeTest
//        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
//        ○ Text Box’a “Merhaba Dunya!” yazin.
//        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin


    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");

    }

    @Test
    public void iframeTest() {

        WebElement text = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(text.isEnabled());
        System.out.println("text = " + text.getText());
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textYaz = driver.findElement(By.tagName("p"));
        textYaz.clear();
        textYaz.sendKeys("Merhaba Dunya!");
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Elemental Selenium")).click();



    }
}