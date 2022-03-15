package org.example;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {

    public static void main(String[] args) throws MalformedURLException {

        //1) Desired Capabilities OLUSTUR.
        DesiredCapabilities cap = new DesiredCapabilities();

        //Desired Capabilities içerisine 3 şey tanımlayabiliriz

        //a) browser
        cap.setBrowserName("chrome");

        //b) işletim sistemi

        cap.setPlatform(Platform.WIN10);

        //c) browser version
        //cap.setVersion("96.0.4664.45");

        //2) Chrome Options olustur
        ChromeOptions options = new ChromeOptions();

        options.merge(cap);

        String hubUrl = "http://192.168.1.6:4444/wd/hub";

        WebDriver driver = new RemoteWebDriver(new URL(hubUrl),options);

        driver.get("https://www.google.com/");

        System.out.println(driver.getTitle());
    }
}