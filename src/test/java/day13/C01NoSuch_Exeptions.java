package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01NoSuch_Exeptions extends TestBase {
    /*Interview Questions
    Tell me 5 exception that you get.-5 adet selenium da aldigin exceptions dan bahset.
    What type of exceptions do you get in selenium? - Seleniumda ki align exceptions tiplerinden bahset
    What is your solution?-Cozum ne?
    What type of waits do you use?- Hangi resit wait kullanirsin?
    Which wait do you prefer?- Hangi wait tercih edersin?
    Why do you prefer that wait?- Neden onu tercih edersin?
    How to you resolve synronization issue?-Senkronizasyon problemini nasil cozersin?

    NoSuchElementException
TimeOutException
NullPointerException
InvalidSelectorException
StaleElementReferenceException
InvalidElementStateException
WebDriverException
ElementNotInteractableException
ElementClickInterceptedException
InvalidArgumentException
JavascriptException
RemoteDriverServerException

NoSuchElementException
Yanlis locator
Popup, yeni pencere, iframe…
Sayfa dolmada problemler ve yavaşlamalar
Sakli olan elementler
Cözüm:
Locatorin dogrulugunu tekrar kontrol et
Manual test ile iframe, yeni pencere, alert…. gibi elementlerin varliğini kontrol et
Bekleme problemi olabilir. İmplicit wait bekleme suresini cozmuyor. Bu duurmda explicit wait ya da fluent wait kullaniriz
     */
    @Test
    public void noSuchElementTest(){
        /*
         */
        driver.get("https://www.techproeducation.com");
        driver.
                findElement(By.xpath("//input[@type='searchh']")).//org.openqa.selenium.NoSuchElementException:
                sendKeys("QA"+ Keys.ENTER);
    }
}


