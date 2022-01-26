package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q1 {

    /*
...Exercise1...
BeforeClass ile driver ı olusturun ve class icinde static yapin
Maximize edin, 15 sn bekletin
http://www.google.com adresine gidin
arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
AfterClass ile kapatın

 */
    WebDriver driver;
    WebElement searchBox;
    WebElement result;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @BeforeMethod
    public void beforeTest() {
        driver.get("http://www.google.com");

    }
    @Test
    public void test01() {

        driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.click();
        searchBox.sendKeys("Green Mile", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String resultString = result.getText();
        System.out.println("resultString = " + resultString);


    }

    @Test
    public void test02() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.click();
        searchBox.sendKeys("Premonitio", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String resultString = result.getText();
        System.out.println("resultString = " + resultString);


    }

    @Test
    public void test03() {
        searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.click();
        searchBox.sendKeys("The Curious Case of Benjamin Button", Keys.ENTER);
        result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String resultString = result.getText();
        System.out.println("resultString = " + resultString);


    }

    @AfterClass
    public void tearDown() {

        driver.close();
    }
}
