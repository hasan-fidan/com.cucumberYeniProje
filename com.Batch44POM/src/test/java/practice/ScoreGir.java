package practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Driver;

public class ScoreGir {


    @Test(invocationCount = 50)
    public void test01() {

        Driver.getDriver().get("https://boardingleague.lis.sc.ke/update-scores.php");


        WebElement drop = Driver.getDriver().findElement(By.xpath("//select[@name='homeSelect']"));
        Faker faker = new Faker();
        Select select = new Select(drop);
        select.selectByIndex(faker.random().nextInt(1,2));

        WebElement home = Driver.getDriver().findElement(By.xpath("//input[@name='homeTeamScore']"));
        int sayi = faker.random().nextInt(0,1000);
        home.sendKeys(String.valueOf(sayi));


        WebElement drop2 = Driver.getDriver().findElement(By.xpath("//select[@name='awaySelect']"));

        select = new Select(drop2);

        select.selectByIndex(faker.random().nextInt(3,4));

        WebElement team = Driver.getDriver().findElement(By.xpath("//input[@name='awayTeamScore']"));
        int gol = faker.random().nextInt(0,1000);
        team.sendKeys(String.valueOf(gol));

        Driver.getDriver().findElement(By.xpath("//button[@name='scores']")).click();


       WebElement name = Driver.getDriver().findElement(By.xpath("//input[@id='scorerName']"));
       name.sendKeys(faker.name().fullName());

       int num = faker.random().nextInt(10,300);

       Driver.getDriver().findElement(By.xpath("//input[@name='numberOfGoals']")).sendKeys(String.valueOf(num));


       Driver.getDriver().findElement(By.xpath("//button[@name='scorers']")).click();


    }


















}
