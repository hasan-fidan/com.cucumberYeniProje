package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C08 {
//...Exercise6...

    WebDriver driver;
    WebElement dropdownElementi;
    Select select;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
// 1. Amazon.com'a gidelim.
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test01() {

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
// 2. DropDown üzerinde Books secelim.(All yazan yerde)
        select.selectByVisibleText("Books");
        List<WebElement> options = select.getOptions();
// 3. kategorilerin hepsini konsola yazdiralim
        options.stream().forEach(t-> System.out.println(t.getText()));
// 4. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Les Miserables", Keys.ENTER);
// 5. Sonuc sayisini ekrana yazdiralim.
        WebElement resultText = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println("Sonuc yazisi " + resultText.getText());
// 6. Sonucların Les Miserables i icerdigini assert edelim
        WebElement actualResult = driver.findElement(By.xpath("(//span[@dir='auto'])[3]"));
        String actualText = actualResult.getText();
        String expectedText = "Les Miserables";
        Assert.assertTrue(actualText.contains(expectedText));





    }

}
