package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q07 {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com/");

    }


    @Test
    public void test01() {

        WebElement cookiesAcceptElementi = driver.findElement(By.xpath("//button[@data-testid='cookie-policy-dialog-accept-button']"));
        cookiesAcceptElementi.click();

// 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        WebElement yeniHesapOlusturElementi = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        yeniHesapOlusturElementi.click();


// 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement dogumGunuElementi = driver.findElement(By.xpath("//select[@id='day']"));
        Select select = new Select(dogumGunuElementi);
        List<WebElement> gunler = select.getOptions();
        System.out.println("Gunler:");
        gunler.stream().forEach(t -> System.out.print(t.getText()+"-"));


// 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
        WebElement dogumAylarElementi = driver.findElement(By.xpath("//select[@id='month']"));
        select = new Select(dogumAylarElementi);
        List<WebElement> aylar = select.getOptions();
        System.out.println("\nAylar:");
        aylar.stream().forEach(t-> System.out.print(t.getText()+"-"));


// 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        WebElement dogumYilElementi = driver.findElement(By.xpath("//select[@id='year']"));
        select = new Select(dogumYilElementi);
        List<WebElement> yillar = select.getOptions();
        System.out.println("\nYillar:");
        yillar.stream().forEach(t -> System.out.print(t.getText() + "-"));


        driver.close();




    }






}
