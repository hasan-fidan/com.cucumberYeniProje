package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;



public class C05_YoutubeTesti {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	 ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");


        // driver.findElement(By.xpath("//ytd-button-renderer[2]//a[1]//tp-yt-paper-button[1]//yt-formatted-string[1]")).click();

    }
    @Test
    public void titleTest() {

        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }
    @Test
    public void imageTest() {
        WebElement youtubeLogo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());

    }

    @Test
    public void searchBoxTest() {

    }
    @Test
    public void wrongTitleTest() {

    }

    @AfterClass
    public static void teardown() {


    }
}
