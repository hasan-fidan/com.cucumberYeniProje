package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleArama {

    WebDriver driver;

    @Test
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");


    }

    @Test

    public void test01() {

        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        WebElement searchBoxElementi = driver.findElement(By.xpath("//input[@name='q']"));
        searchBoxElementi.sendKeys("Java selenium", Keys.ENTER);
        WebElement gorsellerButton = driver.findElement(By.xpath("//a[@data-hveid='CAEQAw']"));
        gorsellerButton.click();
        Actions actions = new Actions(driver);
        WebElement resim = driver.findElement(By.partialLinkText("Can Selenium"));
        actions.contextClick(resim).perform();

    }





















}
