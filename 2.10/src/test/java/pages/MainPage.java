package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private String url = "https://mts.by";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public boolean isReplenishmentBlockDisplayed() {
        return driver.findElement(By.xpath("")).isDisplayed();
    }

    public ReplenishmentBlock getReplenishmentBlock() {
        return new ReplenishmentBlock(driver);
    }
}
