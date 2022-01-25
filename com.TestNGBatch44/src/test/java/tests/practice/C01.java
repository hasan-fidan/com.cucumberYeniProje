package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01 {
////● https://the-internet.herokuapp.com/windows adresine gidin.
//  //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//  //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

//  //● Click Here butonuna basın.
//  //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

// //● Sayfadaki textin “New Window” olduğunu doğrulayın.

// //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/windows");


    }


    @Test (priority = 0)
    public void textTest01() {

        WebElement actualTextElement = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String actualText = actualTextElement.getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText, expectedText);

    }

    @Test (priority = 1)
    public void titleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle, expectedTitle);


    }

    @Test (priority = 2)
    public void clickHereTest() throws InterruptedException {

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();
        String expectedTitle = "New Window";
        Assert.assertEquals(actualTitle, expectedTitle);


        String actualText = driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
        String expectedText = "New Window";
        Assert.assertEquals(actualText, expectedText);

        //driver.close();
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "The Internet";
        Assert.assertEquals(actualTitle2, expectedTitle2);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
