package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05 {



    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");


    }


    @Test
    public void test01() throws InterruptedException {
        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        Thread.sleep(2000);

//3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        Thread.sleep(2000);



//4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        Thread.sleep(2000);

//5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);

//6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();
        Thread.sleep(2000);

//7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        Thread.sleep(2000);


//8. “Currency” drop down menusunden Eurozone’u secin

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(dropDown);
        select.selectByValue("EUR");
        Thread.sleep(2000);


//9. “amount” kutusuna bir sayi girin

       driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("123");
        Thread.sleep(2000);


//10. “US Dollars” in secilmedigini test edin
        WebElement dollarButton = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(dollarButton.isSelected());
        Thread.sleep(2000);


//11. “Selected currency” butonunu secin

        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();
        Thread.sleep(2000);


//12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
        Thread.sleep(2000);


//13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.

        WebElement alertYazisiElementi = driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']"));
        String actualYazi = alertYazisiElementi.getText();
        String expectedYazi = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(actualYazi, expectedYazi);
        Thread.sleep(2000);


    }


    @AfterClass

    public void tearDown() {
        driver.close();

    }
}
