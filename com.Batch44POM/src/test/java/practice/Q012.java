package practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Q012 {



    @Test (invocationCount = 30) // testin kac defa tekrarlanacagi ayarlanabilir.
    public void test01() throws InterruptedException {

// 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin

                Driver.getDriver().get("https://react-shopping-cart-67954.firebaseapp.com/");

// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )

                List<WebElement> urunlerElementi = Driver.getDriver().findElements(By.xpath("//p[@class='shelf-item__title']"));
                System.out.println("sitede "+urunlerElementi.size()+" urun var,");
                for (int i=0; i<urunlerElementi.size(); i++){
                    System.out.println(i+1+".urun :"+urunlerElementi.get(i).getText());
                }

// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin

                List<String> urunAdlari = new ArrayList<>();

                for (WebElement each: urunlerElementi) {
                    urunAdlari.add(each.getText());
                }

// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin
// (Her ürün 1 defadan fazla eklenemez!)

                Faker faker = new Faker();

                int index;
                String sepeteEkleButonuXpath;
                WebElement sepetiKapatElementi;
                ArrayList<Integer> randomSayi = new ArrayList<>();

        do {
            index = faker.random().nextInt(1, 16);
            if (!randomSayi.contains(index)){

                randomSayi.add(index);
                sepeteEkleButonuXpath = "(//div[@class='shelf-item__buy-btn'])["+index+"]";
                WebElement randomSepetButonuElementi = Driver.getDriver().findElement(By.xpath(sepeteEkleButonuXpath));
                randomSepetButonuElementi.click();
                sepetiKapatElementi = Driver.getDriver().findElement(By.xpath("//div[@class='float-cart__close-btn']"));
                Thread.sleep(250);
                sepetiKapatElementi.click();
                Thread.sleep(250);
            }

        }while (randomSayi.size()!=5); // buradaki sayi degistirilerek sepete eklenecek urun sayisi degistirilebilir.

// ve sectiginiz öğelerin adlarını yazdırın

                Thread.sleep(250);
                WebElement sepetiAc = Driver.getDriver().findElement(By.xpath("//span[@class='bag bag--float-cart-closed']"));
                sepetiAc.click();
                Thread.sleep(250);
                List<WebElement> sepettekiUrunlerElementi = Driver.getDriver().findElements(By.xpath("//p[@class='title']"));
                System.out.println("~~~~~Sepetteki Urunler~~~~~");
                sepettekiUrunlerElementi.stream().forEach(t -> System.out.println(t.getText()));


// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın


                List<WebElement> sepettekiUrunlerFiyatElementi = Driver.getDriver().findElements(By.xpath("//div[@class='float-cart__shelf-container']//div[@class='shelf-item__price']//p"));

                double expectedPrice =  0.0;

                for (WebElement each: sepettekiUrunlerFiyatElementi) {
                    expectedPrice += Double.parseDouble(each.getText().replace("$ ",""));
                }

                WebElement sepetToplamFiyatElementi = Driver.getDriver().findElement(By.xpath("//p[@class='sub-price__val']"));
                double actualPrice = Double.parseDouble(sepetToplamFiyatElementi.getText().replace("$ ", ""));

                expectedPrice = (Math.round(expectedPrice*100.0)/100.0); // virgulden sonra 2 basamak olmasi icin.
                Assert.assertEquals(actualPrice, expectedPrice);



// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin

                if(actualPrice==expectedPrice) System.out.println("test pass");



// 7.Checkout'a tıklayın

                WebElement checkOutButtonElementi = Driver.getDriver().findElement(By.xpath("//div[@class='buy-btn']"));
                checkOutButtonElementi.click();




      Thread.sleep(500);
      Driver.closeDriver();

    }

 }
