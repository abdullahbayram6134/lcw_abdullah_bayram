package lcwaikikiTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Tests extends Methods {

    public String detailPrice;
    public String cartPrice;

    @Test
    public void lcwLogin() throws InterruptedException
    {
        clickElement(By.id("header-user-section"));
        sendKeys(By.cssSelector("input.ym-disable-keys[placeholder='E-Posta Adresiniz']"), "abdullahbayram6134@gmail.com");
        sendKeys(By.cssSelector("input.ym-disable-keys[placeholder='Şifreniz']"), "deneme1239");
        clickElement(By.id("loginLink"));

        lcwSearch();
    }

    public void lcwSearch() throws InterruptedException
    {
        sendKeys(By.cssSelector("input.search[id='search']"), "pantolon");

        sendEnter();
    }

    public  void sendEnter() throws InterruptedException
    {
        sendEnter(By.cssSelector("input.search[id='search']"), Keys.RETURN);
        clickElement(By.cssSelector("p[class='lazy-load-text']"));

        randomProductChoose();
    }


    public void randomProductChoose() throws InterruptedException
    {
        List<WebElement> pantolonlar = driver.findElements(By.className("emi-icons-wrapper")); // Daha fazla ürün göster ile birlikte kaç tane ürün olduğunun tespiti.
        System.out.println("list_length : "+pantolonlar.size());
        Random random = new Random();
        int rnd = random.nextInt(pantolonlar.size());
        clickElement(By.xpath("/html/body/div[5]/div[3]/div[2]/div[7]/div/div[1]/div["+rnd+"]"));

        getPrice();
    }

    public void getPrice() throws InterruptedException
    {
        detailPrice = elementGetText(By.xpath("//div[@class='col-xs-12 price-area']//div//span[@class='price']"));
        clickElement(By.cssSelector("a[data-tracking-label='BedenSecenekleri'][key='1']"));
        clickElement(By.id("pd_add_to_cart"));
        clickElement(By.cssSelector(".header-cart[data-tracking-category='Giris']"));

        cart();
    }

/*
Ürün sayfasındaki fiyat ile sepetteki fiyatı karşılaştırmak için
bir if karşılaştırması yazdım. Ürün fiyatını çekmede sorun yaşadım.
Fiyat bilgileri ile ilgili kısmı yorum satırı olarak bıraktığımda,
kalan adımlar başarılı bir şekilde tamamlanıyor.
*/

    public void cart() throws InterruptedException
    {
        cartPrice = elementGetText(By.className("rd-cart-item-price mb-15"));

        if (cartPrice.equals(detailPrice)) {
            System.out.println("Iki fiyat birbirine esittir.");
        }else{
            Assert.fail("Iki fiyat birbirine esit degildir.");
        }

        clickElement(By.cssSelector(".oq-up[id*='Cart_AddQuantity']"));
        Thread.sleep(2000);
        clickElement(By.cssSelector(".cart-square-link[id*='Cart_ProductDelete']"));
        Thread.sleep(2000);
        clickElement(By.cssSelector("div[class='col-xs-12']>a[id*='Cart_ProductDelete']"));

    }

}
