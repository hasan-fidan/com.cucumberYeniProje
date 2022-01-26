package tests.day10;

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

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }


    @Test
    public void acceptAlert() {

        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement resultTextActual = driver.findElement(By.xpath("//p[@id='result']"));
        String actualText = resultTextActual.getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(actualText, expectedText);

    }


    @Test
    public void dismissAlert() {

        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        WebElement resultTextActual = driver.findElement(By.xpath("//p[@id='result']"));
        String actualText = resultTextActual.getText();
        String expectedtext = "successfuly";
        Assert.assertFalse(actualText.contains(expectedtext));


    }

    @Test
    public void sendKeysAlert() {

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        String gonderilenIsim = "hasan";
        driver.switchTo().alert().sendKeys(gonderilenIsim);
        driver.switchTo().alert().accept();
        WebElement actualText = driver.findElement(By.xpath("//p[@id='result']"));
        String actualTextName = actualText.getText();
        String expectedName = "hasan";
        Assert.assertTrue(actualTextName.contains(expectedName));


    }


    @AfterClass
    public void tearDown() {
        driver.close();

    }
}
