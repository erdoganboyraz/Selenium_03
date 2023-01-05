package day_07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Erdi extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textbox=driver.findElement(By.xpath("//*[@id='tinymce']"));
        textbox.clear();
        textbox.sendKeys("Techproeducation");
        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
       Assert.assertTrue(driver.findElement(By.xpath("//*[.='Elemental Selenium']")).isDisplayed());
        // Elemental Selenium linkine tıklayın
        driver.findElement(By.xpath("//*[.='Elemental Selenium']")).click();
        List<String> windowHandles=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        /*
        Set<String> windowHandleseti= driver.getWindowHandles();
        System.out.println(windowHandleseti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }
         */
        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println("elemental selenium sayfa basliği="+driver.getTitle());

        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Sauce Labs']")).isDisplayed());

        // Source labs linkine tıklayın
        driver.findElement(By.xpath("//*[.='Sauce Labs']")).click();
        System.out.println("--------------------------------------------------");

        // Açılan sayfada sayfa başlığını yazdırınız
        List<String>windowHandles2=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(windowHandles2.get(2));
        System.out.println("acılan sayfanın baslığı="+driver.getTitle());

        // ilk sekmeye geri dönelim ve url'ini yazdıralım

        // ilk sekmeyi kapatalım


    }
}

