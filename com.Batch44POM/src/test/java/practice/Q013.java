package practice;

import org.testng.annotations.Test;
import pages.HotelMyCampAdminGiris;
import utilities.ConfigReader;
import utilities.Driver;

public class Q013 {

    //● Bir class oluşturun : D18_WebTables
    //● login( ) metodun oluşturun ve oturum açın.
    //● https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
    //○ Username : manager ○ Password : Manager2!


    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCAdminUrl"));

        HotelMyCampAdminGiris adminGiris = new HotelMyCampAdminGiris();

        adminGiris.adminGirisUserNameBox.sendKeys(ConfigReader.getProperty("ValidUserName"));
        adminGiris.adminGirisPasswordBox.sendKeys(ConfigReader.getProperty("ValidPassword"));
        adminGiris.adminGirisLoginTusuElementi.click();

        adminGiris.table();
        adminGiris.printCells();
        adminGiris.printRows();


Driver.closeDriver();

    }





}
