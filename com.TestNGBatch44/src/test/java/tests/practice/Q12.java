package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q12 extends TestBase {

// Siteyi açınız. http://opencart.abstracta.us/index.php?route=account/login ,
// login yapiniz Email: batch44@gmail.com   password : 123456789
// Search fonksiyonunu kullanarak
// Mac,ipod ve samsung icin Dataprovider ile yapınız.


    @Test
    public void test01(String kelimeler) {
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("batch44@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(kelimeler + Keys.ENTER);
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();


    }


@DataProvider
    public Object[][] aranacaklar() {


        String data [][] = new String[0][];

        return data;
}















}
