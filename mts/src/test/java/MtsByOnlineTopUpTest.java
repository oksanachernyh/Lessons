import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MtsByOnlineTopUpTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oksan\\Desktop\\QA\\ASTON\\Блок 2\\ДЗ 2.9\\chrome-win64");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(description = "Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        String expectedTitle = "Онлайн пополнение без комиссии";
        Assert.assertTrue(blockTitle.getText().contains(expectedTitle), "Заголовок блока не найден или не совпадает");
    }

    @Test(description = "Проверка наличия логотипов платёжных систем")
    public void testPaymentSystemLogosPresence() {
        List<WebElement> logos = driver.findElements(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul"));
        Assert.assertFalse(logos.isEmpty(), "Логотипы платежных систем не найдены");
        boolean foundVisa = false;
        boolean foundVerifiedByVisa = false;
        boolean foundMasterCard = false;
        boolean foundMasterCardSecureCode = false;
        boolean foundБелкарт = false;
        for (WebElement logo : logos) {
            String altText = logo.getAttribute("alt");
            if (altText != null) {
                if (altText.contains("Visa")) foundVisa = true;
                if (altText.contains("Verified By Visa")) foundVerifiedByVisa = true;
                if (altText.contains("MasterСard")) foundMasterCard = true;
                if (altText.contains("MasterCard Secure Code")) foundMasterCardSecureCode = true;
                if (altText.contains("Белкарт")) foundБелкарт = true;
            }
        }
        Assert.assertTrue(foundVisa, "Логотип Visa не найден");
        Assert.assertTrue(foundVerifiedByVisa, "Логотип Verified By Visa не найден");
        Assert.assertTrue(foundMasterCard, "Логотип MasterCard не найден");
        Assert.assertTrue(foundMasterCardSecureCode, "Логотип MasterCard Secure Code не найден");
        Assert.assertTrue(foundБелкарт, "Логотип Белкарт не найден");
    }

    @Test(description = "Проверка работы ссылки 'Подробнее о сервисе'")
    public void testMoreDetailsLink() {
        WebElement link = driver.findElement(By.linkText("<a href=\"/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/\">Подробнее о сервисе</a>"));
        Assert.assertNotNull(link, "Ссылка 'Подробнее о сервисе' не найдена");
        String hrefBefore = link.getAttribute("href");
        link.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("service-details"), "Ссылка не ведет на страницу описания");
        driver.navigate().back();
    }

    @Test(description = "Заполнение формы и проверка кнопки 'Продолжить'")
    public void testFillFormAndClickContinue() {
        // Замените селекторы на актуальные
        WebElement serviceTypeDropdown = driver.findElement(By.id("<div class=\"select__wrapper\">\n" +
                "\t\t\t\t\t\t<button class=\"select__header\"> <span class=\"select__now\">Услуги связи</span><span class=\"select__arrow\">\n" +
                "\t\t\t\t\t\t\t\t<svg class=\"icon\" width=\"20\" height=\"20\" viewBox=\"0 0 20 20\">\n" +
                "\t\t\t\t\t\t\t\t\t<use xlink:href=\"/local/templates/new_design/assets/html/images/sprites/main.stack.svg#image-drop-arrow\">\n" +
                "\t\t\t\t\t\t\t\t\t</use>\n" +
                "\t\t\t\t\t\t\t\t</svg></span></button>\n" +
                "\t\t\t\t\t\t<ul class=\"select__list\" style=\"opacity: 0; visibility: hidden; height: 0px;\"> <li class=\"select__item active\"><p class=\"select__option\">Услуги связи</p></li><li class=\"select__item\"><p class=\"select__option\">Домашний интернет</p></li><li class=\"select__item\"><p class=\"select__option\">Рассрочка</p></li><li class=\"select__item\"><p class=\"select__option\">Задолженность</p></li></ul>\n" +
                "\t\t\t\t\t</div>")); // пример
        serviceTypeDropdown.click();
        WebElement serviceOption = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"));
        serviceOption.click();

        WebElement phoneInput = driver.findElement(By.id("<div class=\"input-wrapper input-wrapper_label-left\">\n" +
                "\t\t\t\t\t\t\t<!-- Класс invalid только для показа ошибки и в теге p указана ошибка -->\n" +
                "\t\t\t\t\t\t\t<input class=\"phone\" id=\"connection-phone\" type=\"text\" placeholder=\"Номер телефона\" required=\"\" maxlength=\"13\" autocomplete=\"off\">\n" +
                "\t\t\t\t\t\t\t<label for=\"connection-phone\">+375</label>\n" +
                "\t\t\t\t\t\t</div>")); // пример
        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.xpath("<button class=\"button button__default \" type=\"submit\">Продолжить</button>"));
        Assert.assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' недоступна или неактивна");

        continueButton.click();

        // Проверка результата
        WebElement confirmation = driver.findElement(By.xpath("//*[contains(text(),'Подтвердите')]")); // пример
        Assert.assertNotNull(confirmation, "Страница не перешла или подтверждение не появилось");
    }
}
