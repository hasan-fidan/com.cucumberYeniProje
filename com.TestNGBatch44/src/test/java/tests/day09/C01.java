package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01 {
//● Bir class oluşturun: DependsOnTest

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void logoTest(){
        //● https://www.amazon.com/ adresine gidin.
        //  1. Test : Amazon ana sayfaya gittiginizi test edin
        driver.get("https://www.amazon.com/");
        WebElement logoElemnti=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElemnti.isDisplayed());
    }
    @Test (dependsOnMethods = "logoTest")
    public void aramaTesti(){
        //  2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
        //  arama yapin ve aramanizin gerceklestigini Test edin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String actualTitle=driver.getTitle();
        String arananKelime="Nutella";
        Assert.assertTrue(actualTitle.contains(arananKelime));
    }

    @Test
    public void fiyatTesti(){
        //  3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin $16.83 oldugunu test edin
    }
}