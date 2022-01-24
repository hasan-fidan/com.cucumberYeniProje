package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q7 {
    //1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //5) Test whether the Home page has Three Arrivals only
    //6) The Home page must contains only three Arrivals
    //7) Now click the image in the Arrivals
    //8) Test whether it is navigating to next page where the user can add that book into his basket.
    //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
    //10) Click on the Add To Basket button which adds that book to your basket
    //11) User can view that Book in the Menu item with price.
    //12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
    //13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
    //14) Click the add to basket button
    //15) Now it throws an error prompt like you must enter a value between 1 and 20


    static WebDriver driver;

@BeforeClass
public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://practice.automationtesting.in/");


    }


    @Test

    public void test01() {
        //3) Click on Shop Menu

        driver.findElement(By.linkText("Shop")).click();

        //4) Now click on Home menu button

        driver.findElement(By.linkText("Home")).click();

        //5) Test whether the Home page has Three Arrivals only







    }































}
