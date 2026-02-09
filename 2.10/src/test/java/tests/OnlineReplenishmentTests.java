package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import pages.ReplenishmentBlock;
import pages.ReplenishmentPage;
import utils.WebDriverFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OnlineReplenishmentTests {

    private WebDriver driver;
    private MainPage mainPage;
    private ReplenishmentBlock replenishmentBlock;
    private ReplenishmentPage replenishmentPage;

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

    @Test
    public void testFieldsPlaceholdersInAllOptions() {
        String[] options = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        for (String option : options) {
            String placeholder = new ReplenishmentPage(driver).getPlaceholderTextForOption(option);
            System.out.println("Placeholder для " + option + ": " + placeholder);
            assertNotNull(placeholder, "Нет placeholder для " + option);
            assertFalse(placeholder.isEmpty(), "Пустой placeholder для " + option);
        }
    }

    @Test
    public void testFillFormAndValidateSummary() {
        // Заполняем форму для "Услуги связи"
        String phoneNumber = "297777777";
        String cardNumber = "4111111111111111";
        String cardRequisites = "1234";

        replenishmentPage = new ReplenishmentPage(driver);
        replenishmentPage.fillServiceDetails("Услуги связи", phoneNumber, cardNumber, cardRequisites);

        assertTrue(replenishmentPage.isContinueButtonEnabled(), "Кнопка 'Продолжить' отключена");
        replenishmentPage.clickContinue();

        // Проверяем отображение суммы и номера телефона
        String sumText = replenishmentPage.getDisplayedSum();
        String phoneText = replenishmentPage.getDisplayedPhoneNumber();

        assertTrue(sumText.contains("₽"), "Некорректное отображение суммы");
        assertEquals(phoneNumber, phoneText, "Номер телефона не совпадает");

        // Проверка наличия иконок платёжных систем
        assertTrue(replenishmentPage.arePaymentIconsDisplayed(), "Иконки платёжных систем не отображаются");

        // Проверка надписей в реквизитах карты
        String cardLabel = replenishmentPage.getRequisiteLabel("cardNumber");
        String requisitesLabel = replenishmentPage.getRequisiteLabel("cardRequisites");
        assertEquals("Номер карты", cardLabel);
        assertEquals("Реквизиты карты", requisitesLabel);
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
