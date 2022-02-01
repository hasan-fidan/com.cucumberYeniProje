package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.List;

public class Q08 extends TestBase{
    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high
     *     T2 : Verify item prices are sorted from low to high with soft Assert
     */

    Select select;

    @Test
    public void test01() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        WebElement dropDownElementi = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        select = new Select(dropDownElementi);
        select.selectByValue("lohi");


    }

    @Test
    public void test02() {

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

        SoftAssert softAssert = new SoftAssert();




    }








}
