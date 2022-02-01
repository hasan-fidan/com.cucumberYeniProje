package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class GenelTekrar01 extends TestBase {


    static WebElement seaarchBox;
    static WebElement dropDownElementi;
    static Select select;
    static String urun1Title;
    static String urun1Fiyat;
    static String urun2Title;
    static String urun2Fiyat;

    @BeforeMethod

    public void elementAtama() {

        driver.get("https://www.amazon.com/");
        seaarchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        dropDownElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDownElementi);
    }

    @Test
    public void test01() {

        List<WebElement> dropDownList = select.getOptions();

        dropDownList.stream().forEach(t -> System.out.println(t.getText()));

        int dropDownSayisi = dropDownList.size();
        int expectedDropDownSayisi = 40;
        Assert.assertEquals(dropDownSayisi, expectedDropDownSayisi, "Beklenen sayidan farkli eleman var.");


    }

    @Test
    public void test02() {
        select.selectByValue("search-alias=electronics-intl-ship");
        seaarchBox.sendKeys("iphone", Keys.ENTER);
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuc Yazisi = " + sonucYazisiElementi.getText());
        String expectedSonucYazisi = "iphone";
        Assert.assertTrue(sonucYazisiElementi.getText().contains(expectedSonucYazisi));


        WebElement ilkUrunElementi = driver.findElement(By.xpath("//img[@class='s-image']"));
        WebElement ikinciUrunElementi = driver.findElement(with(By.tagName("img")).below(ilkUrunElementi));
        ikinciUrunElementi.click();

        urun1Title = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        urun1Fiyat = driver.findElement(By.xpath("//td[@class='a-span12']")).getText();

        WebElement urunuSepeteEkleElementi = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        urunuSepeteEkleElementi.click();


    }

    @Test
    public void test03() throws InterruptedException {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");
         dropDownElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
         select = new Select(dropDownElementi);
         seaarchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        select.selectByVisibleText("Baby");

        seaarchBox.sendKeys("bebek puset", Keys.ENTER);

        WebElement sonucYazisiElementiBebek = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("sonuc Yazisi = " + sonucYazisiElementiBebek.getText());
        String expectedSonucYazisi = "puset";
        Assert.assertTrue(sonucYazisiElementiBebek.getText().contains(expectedSonucYazisi));


        WebElement ikinciSonucElementi = driver.findElement(By.xpath("//img[@data-image-index='2']"));
        WebElement ucuncuSonucElementi = driver.findElement(with(By.tagName("img")).below(ikinciSonucElementi));
        ucuncuSonucElementi.click();

        WebElement urunTitleElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        urun2Title = urunTitleElementi.getText();
        urun2Fiyat = driver.findElement(By.xpath("//span[@id='price_inside_buybox']")).getText();
        WebElement urunuSepeteEkleElementi = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        urunuSepeteEkleElementi.click();
        Thread.sleep(2000);

    }


    @Test
    public void test04() {

        WebElement sepeteGitButonuElementi = driver.findElement(By.xpath("//a[@id='nav-cart']"));
        sepeteGitButonuElementi.click();

        String iphoneFiyat = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[2]")).getText();
        String iphoneTitle = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[2]")).getText();

        String bebekUrunFiyat = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[1]")).getText();
        String bebekUrunTitle = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[1]")).getText();

        Assert.assertEquals(urun1Fiyat, iphoneFiyat);
        Assert.assertEquals(urun2Fiyat, bebekUrunFiyat);
        Assert.assertEquals(urun1Title, iphoneTitle);
        Assert.assertEquals(urun2Title, bebekUrunTitle);

    }


}
