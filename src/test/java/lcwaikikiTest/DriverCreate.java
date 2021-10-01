package lcwaikikiTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverCreate {
    public WebDriver driver;
    @Before
    public void beforeSenaryo()
    {
// Tarayıcı sürücüsünün başlatılması.
        System.out.println("-------------------Senaryo Başladı--------------");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();
    }


    @After
    public void driverQuit() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("-------------------Senaryo Bitti--------------");
//        driver.quit();
    }
}
