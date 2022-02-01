package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class ExplicitWait extends TestBase {

    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()



    @Test
    public void test01() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        textBox.sendKeys("merhaba");
        WebElement enableTextElementi = driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));

       //wait.until(ExpectedConditions.visibilityOf(enableTextElementi));
        Assert.assertTrue(enableTextElementi.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın,
        Assert.assertTrue(textBox.isEnabled());






    }













}
