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
import java.util.List;

public class C04 {
//Bir class oluşturun: C3_DropDownAmazon
//● https://www.amazon.com/ adresine gidin.
//- Test 1
//Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
//oldugunu test edin
//-Test 2
//1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin

    WebDriver driver;
    WebElement aramaKutusuElementi;
    Select select;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");


    }

    @Test (priority = 1)
    public void test01() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin.

        aramaKutusuElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        select = new Select(aramaKutusuElementi);
        List<WebElement> options = select.getOptions();

        int expectedSize = 45;
        int actualSize = options.size();

        Assert.assertEquals(actualSize, expectedSize, "options sayisi beklenenden farkli");

    }

    @Test (priority = 2)
    public void test02() {

        //1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        WebElement searchBox =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.click();
        searchBox.sendKeys("Java", Keys.ENTER);

//3. Bulunan sonuc sayisini yazdirin

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        String sonucYazisi = sonucYazisiElementi.getText();
        System.out.println("sonucYazisi = " + sonucYazisi);

//4. Sonucun Java kelimesini icerdigini test edin
        String expectedSonucYazisi = "Java";
        Assert.assertTrue(sonucYazisi.contains(expectedSonucYazisi));


    }

    @AfterClass
    public void tearDown() {

        driver.close();
    }



}
