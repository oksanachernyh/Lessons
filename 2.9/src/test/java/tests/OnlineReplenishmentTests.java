package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverFactory;
import pages.MainPage;
import pages.ReplenishmentBlock;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OnlineReplenishmentTests {

    private WebDriver driver;
    private MainPage mainPage;
    private ReplenishmentBlock replenishmentBlock;

    @BeforeAll
    public void setUp() {
        driver = WebDriverFactory.createDriver();
    }

    @BeforeEach
    public void openPage() {
        mainPage = new MainPage(driver);
        mainPage.open();
        Assertions.assertTrue(mainPage.isReplenishmentBlockDisplayed(), "Блок пополнения не отображается");
        replenishmentBlock = mainPage.getReplenishmentBlock();
    }

    @Test
    public void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение без комиссии";
        String actualTitle = replenishmentBlock.getTitle();
        assertEquals(expectedTitle, actualTitle, "Название блока не совпадает");
    }

    @Test
    public void testPaymentLogosPresence() {
        var logos = replenishmentBlock.getPaymentSystemLogos();
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем не найдены");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Логотип не отображается");
        }
    }

    @Test
    public void testAboutServiceLink() {
        assertTrue(replenishmentBlock.isAboutServiceLinkDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");
        replenishmentBlock.clickAboutServiceLink();
    }

    @Test
    public void testFillFormAndContinue() {
        replenishmentBlock.fillServiceForm("Услуги связи", "297777777");
        assertTrue(replenishmentBlock.isContinueButtonEnabled(), "Кнопка 'Продолжить' отключена");
        replenishmentBlock.clickContinue();
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
