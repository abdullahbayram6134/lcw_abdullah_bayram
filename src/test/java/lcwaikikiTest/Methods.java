package lcwaikikiTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods extends DriverCreate {
    private WebElement searchElement(By e)
    {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement webElement = webDriverWait.
                until(ExpectedConditions.presenceOfElementLocated(e));  // Until ile dinamik bekletme
        ((JavascriptExecutor) driver).executeScript(  // Sayfa sonuna scroll yapmak icin js komutu.
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
        return webElement;
    }

    public void clickElement(By e)
    {
        searchElement(e).click();
    }

    public void sendKeys(By e,String s)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(e)).sendKeys(s);
    }

    public void sendEnter(By e, Keys s)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(e)).sendKeys(Keys.RETURN);
    }

    public String elementGetText(By e)
    {
        String getText = searchElement(e).getText();
        return getText;
    }

}
