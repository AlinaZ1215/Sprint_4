package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OrderPage {
    private WebDriver driver;
    public OrderPage orderPage;
    private final By NAME = By.xpath("//input[@placeholder ='* Имя']");
    private final By SURNAME = By.xpath("//input[@placeholder ='* Фамилия']");
    private final By ADDRESS = By.xpath("//input[@placeholder ='* Адрес: куда привезти заказ']");
    private final By METRO_STATION = By.xpath("//input[@placeholder ='* Станция метро']");
    private final By PHONE = By.xpath("//input[@placeholder ='* Телефон: на него позвонит курьер']");
    private final By DATE_CALENDAR = By.xpath("//input[@placeholder ='* Когда привезти самокат']");
    private final By DATE = By.xpath("//div[contains(@class, 'day--today')]");
    private final By RENTAL_PERIOD = By.className("Dropdown-arrow");
    private final By RENTAL_DAY = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    private final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By ORDER_BUTTON = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[contains(text(), 'Заказать')]");
    private final By YES_BUTTON = By.xpath("//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() ='Да']");
    public final By ORDER_PLACED_HEADER = By.xpath("//div[(text()= 'Заказ оформлен')]");
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getName() {
        return driver.findElement(NAME);
    }

    public WebElement getSurname() {
        return driver.findElement(SURNAME);
    }

    public WebElement getAddress() {
        return driver.findElement(ADDRESS);
    }

    public WebElement getPhoneNumber() {
        return driver.findElement(PHONE);
    }

    public WebElement getStation() {
        return driver.findElement(METRO_STATION);
    }

    public WebElement getCalendar() {
        return driver.findElement(DATE_CALENDAR);
    }

    public WebElement getDate() {
        return driver.findElement(DATE);
    }

    public WebElement getRentalPeriod() {
        return driver.findElement(RENTAL_PERIOD);
    }

    public WebElement getRentalTime() {
        return driver.findElement(RENTAL_DAY);
    }
    public WebElement getNextButton() {
        return driver.findElement(NEXT_BUTTON);
    }

    public WebElement getOrderButton() {
        return driver.findElement(ORDER_BUTTON);
    }

    public WebElement getOrderYes() {
        return driver.findElement(YES_BUTTON);
    }
    public OrderPage fillingTheData(String name, String surname, String address, String phoneNumber, String station) {
        orderPage = new OrderPage(driver);

        orderPage.getName().sendKeys(name);
        orderPage.getSurname().sendKeys(surname);
        orderPage.getAddress().sendKeys(address);
        orderPage.getPhoneNumber().sendKeys(phoneNumber);
        new Actions(driver).moveToElement(orderPage.getStation()).click().sendKeys(station)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        return this;
    }


    public OrderPage fillingTheDataThan() {
        orderPage = new OrderPage(driver);

        orderPage.getCalendar().click();
        orderPage.getDate().click();
        orderPage.getRentalPeriod().click();
        orderPage.getRentalTime().click();

        return this;
    }
}
