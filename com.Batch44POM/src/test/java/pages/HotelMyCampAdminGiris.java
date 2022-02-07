package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HotelMyCampAdminGiris {

    public HotelMyCampAdminGiris() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement adminGirisUserNameBox;


    @FindBy(xpath = "//input[@id='Password']")
    public WebElement adminGirisPasswordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement adminGirisLoginTusuElementi;


    public void table() {
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        List<WebElement> webTableSutunlarElementi = Driver.getDriver().findElements(By.xpath("//thead//tr//th"));
        System.out.println("Webtable bodysinde bulunan sutun sayisi : "+webTableSutunlarElementi.size());

        //○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.

        WebElement webTableTumBody = Driver.getDriver().findElement(By.xpath("//tbody"));
        System.out.println("~~~Web Table Tum Body~~~\n"+webTableTumBody.getText());
        WebElement webTableHeaders = Driver.getDriver().findElement(By.xpath("//thead//tr"));
        System.out.println(webTableHeaders.getText());



    }

public void printRows() {
    //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    List<WebElement> satirlarElementi = Driver.getDriver().findElements(By.xpath("//tbody//tr"));
    System.out.println("Webtable bodysinde bulunan satir sayisi : "+satirlarElementi.size());

    //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    System.out.println("Webtable bodysinde bulunan tum satirlar : ");
    satirlarElementi.stream().forEach(t -> System.out.println(t.getText()));

    //○ 4.satirdaki(row) elementleri konsolda yazdırın.
    System.out.println("4. satirdaki datalar : "+satirlarElementi.get(3).getText());





}

    public void printCells() {
        //● printCells( ) metodu oluşturun //td
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> toplamHucreElementi = Driver.getDriver().findElements(By.xpath("//tbody//tr//td"));
        System.out.println("Webtable bodysinde bulunan toplam hucre sayisi : "+toplamHucreElementi.size());

        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        System.out.println("Webtable bodysinde bulunan tum hucrelerdeki datalar: ");
        toplamHucreElementi.stream().forEach(t-> System.out.println(t.getText()));

    }
/*
    public void printColumns() {
        //● printColumns( ) metodu oluşturun
        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.

        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        //○ 5.column daki elementleri konsolda yazdırın.

    }*/














}
