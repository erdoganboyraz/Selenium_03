package day_07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest(){

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
//        Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
//        //tag[.='metin']; Bana bu tagli metni ver
        //tag[text()='metin'];
        String expectedText="black border";
        Assert.assertTrue(anaMetin.contains(expectedText));
//        Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Applications lists elementi iframe in icinde. Iframe switch yapmam sart
        driver.switchTo().frame(0);//index 0 dan baslar. ilk iframe e switch yapiyoruz
        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText1="Applications lists";
        Assert.assertEquals(expectedText1,icMetin);
//        Alternatif olarak altdaki secenekler de kullanilabilir
//        Assert.assertTrue(expectedText1.contains(icMetin));
//        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());
//        Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
//        Ana sayfadaki Povered By yazinisi test etmek istiyorum Ama driver hala iframein icinde
//        Iframein disina cikmak icin driver.switchTo().defaultContent/parentFrame
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
        //Bir class olusturun: IframeOdev
         //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
         //sayfadaki toplam iframe sayısını bulunuz.
          //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
          //Paragrafdaki yaziyi silelim
          //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
           //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
    }
    @Test
    public void test01() throws InterruptedException {
        //Bir class olusturun: IframeOdev
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
        driver.findElement(By.tagName("h3"));
        Thread.sleep(2000);
        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//body/p"));
        textBox.clear();
        Thread.sleep(2000);
        //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        textBox.sendKeys("iframein icindeyim");
        Thread.sleep(2000);
        //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String text = driver.findElement(By.xpath("//*[@style='text-align: center;']")).getText();
        String expectedText = "Elemental Selenium";
        Assert.assertTrue(text.contains(expectedText));
    }

}
