package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ReplenishmentPage {
    private WebDriver driver;

    public ReplenishmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPlaceholderTextForOption(String optionName) {
        WebElement optionSection = driver.findElement(By.xpath("//div[contains(@class, 'option') and contains(text(), '" + optionName + "')]"));
        List<WebElement> inputFields = optionSection.findElements(By.tagName("input"));
        return inputFields.stream()
                .map(field -> field.getAttribute("placeholder"))
                .findFirst()
                .orElse("");
    }

    // Заполнить форму для "Услуги связи"
    public void fillServiceDetails(String serviceType, String phoneNumber, String cardNumber, String cardRequisites) {
        // Выбираем "Услуги связи"
        driver.findElement(By.xpath("//input[@value='Услуги связи']")).click();

        // Вводим номер телефона
        WebElement phoneInput = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);

        // Заполняем реквизиты карты
        WebElement cardNumberInput = driver.findElement(By.xpath("//input[@name='cardNumber']"));
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNumber);

        WebElement cardRequisitesInput = driver.findElement(By.xpath("//input[@name='cardRequisites']"));
        cardRequisitesInput.clear();
        cardRequisitesInput.sendKeys(cardRequisites);
    }

    public boolean isContinueButtonEnabled() {
        WebElement btn = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        return btn.isEnabled();
    }

    public void clickContinue() {
        driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]")).click();
    }

    // Проверка отображения суммы и номера телефона в окне
    public String getDisplayedSum() {
        return driver.findElement(By.xpath("//div[contains(@class, 'summary-sum')]")).getText();
    }

    public String getDisplayedPhoneNumber() {
        return driver.findElement(By.xpath("//div[contains(@class, 'summary-phone')]")).getText();
    }

    public String getRequisiteLabel(String inputName) {
        WebElement label = driver.findElement(By.xpath("//label[@for='" + inputName + "']"));
        return label.getText();
    }

    public boolean arePaymentIconsDisplayed() {
        List<WebElement> icons = driver.findElements(By.xpath("//div[contains(@class, 'payment-icons')]//img"));
        return !icons.isEmpty() && icons.stream().allMatch(WebElement::isDisplayed);
    }
}
