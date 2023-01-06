package day_07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Erdi extends TestBase {
    @Test
    public void test01() throws InterruptedException {

//        Amazona git
        driver.get("https://www.amazon.com");
        waitFor(3);
//        1.toplam cookie sayisini bul
        Set<Cookie> allCookies=driver.manage().getCookies();
        int cookieSayisi=allCookies.size();
        System.out.println("cookie sayisi="+cookieSayisi);
//        3. Bir Cookie yi ismiyle bul
        System.out.println(driver.manage().getCookieNamed("i18n-prefs"));

//        tum cokkie leri yazdiralim
//        allCookies.stream().forEach(t -> System.out.println(t.getName()));
        for (Cookie eachcookie : allCookies) {
            System.out.println("Cooki isimleri="+eachcookie.getName());

        }
//        4. Yeni bir cookie ekle
        Cookie engüzelcookie=new Cookie("antep","baklavasi");
        driver.manage().addCookie(engüzelcookie);
        System.out.println(cookieSayisi);
//        5. Bir Cookie yi ismiyle sil

//        6. Tum cookie leri sil


    }




}

