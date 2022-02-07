package practice;

import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DemoQa {


// Go to https://demoqa.com/ write an automated test
// Alerts ( handle all alerts)
// Interactions (Click droppable button and under the simple module drag the “drag me” box to the
// “drop me” box  and verify that dropped.)
// Widgets ( click tool Tips button, hover over the “Hover me to see” button and verify the
// “You Hovered Over the button” message then hover over the “Hover me to see” text field and verify
// “You hovered the text field” message.


    @Test
    public void alertsHandle() throws InterruptedException {
        DemoqaPage qa = new DemoqaPage();
        Driver.getDriver().get(ConfigReader.getProperty("DemoQaUrl"));
        Thread.sleep(500);
        qa.alertFramesWindowsPage.click();
        Thread.sleep(500);
        qa.alertPage.click();
        Thread.sleep(500);
        qa.alertButonu.click();
        Thread.sleep(500);
        Driver.getDriver().switchTo().alert().accept();
        Thread.sleep(500);








    }









}
