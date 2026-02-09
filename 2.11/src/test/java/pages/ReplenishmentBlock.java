package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReplenishmentBlock {
    private WebDriver driver;

    public ReplenishmentBlock(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(By.xpath("")).getText();
    }

    public List<WebElement> getPaymentSystemLogos() {
        return driver.findElements(By.xpath(""));
    }

    public boolean isAboutServiceLinkDisplayed() {
        WebElement link = driver.findElement(By.xpath(""));
        return link.isDisplayed();
    }

    public void clickAboutServiceLink() {
        driver.findElement(By.xpath("")).click();
    }

    public void fillServiceForm(String serviceType, String phoneNumber) {
        driver.findElement(By.xpath("")).click();
        WebElement phoneInput = driver.findElement(By.xpath(""));
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
    }

    public boolean isContinueButtonEnabled() {
        WebElement btn = driver.findElement(By.xpath(""));
        return btn.isEnabled();
    }

    public void clickContinue() {
        driver.findElement(By.xpath("")).click();
    }
}
