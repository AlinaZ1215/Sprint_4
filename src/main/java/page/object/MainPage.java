package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class MainPage {
    private WebDriver driver;
    public MainPage mainPage;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public MainPage() {
    }

    private final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final By ACCEPT_COOKIE_BUTTON = By.id("rcc-confirm-button");
    private final By HEADING_QUEST = By.xpath("//div[text() = 'Вопросы о важном']");
    public final By ORDER_BUTTON_HEADER = By.className("Button_Button__ra12g");
    public final By ORDER_BUTTON_DOWN = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By LIST_QUESTIONS = By.xpath("//*[@class='accordion__button']");
    private final By LIST_ANSWER = By.xpath("//div[@data-accordion-component='AccordionItemPanel']");



    public WebElement getCookie() {
        return driver.findElement(ACCEPT_COOKIE_BUTTON);
    }

    public WebElement getFAQ() {
        return driver.findElement(HEADING_QUEST);
    }

    public List<WebElement> getListQuestions() {
        return driver.findElements(LIST_QUESTIONS);
    }

    public List<WebElement> getListAnswer() {
        return driver.findElements(LIST_ANSWER);
    }
    public MainPage openWedsite() {
        driver.get(URL);
        return this;
    }
    public MainPage scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public MainPage click(WebElement element) {
        scroll(element);
        element.click();
        return this;
    }


    public MainPage clickOnTheOrderButton(By elementLokator) {
        WebElement element = driver.findElement(elementLokator);
        scroll(element);
        element.click();
        return this;
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}