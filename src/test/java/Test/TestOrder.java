package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import page.object.MainPage;
import page.object.OrderPage;
//import org.openqa.selenium.firefox.FirefoxDriver;


@RunWith(Parameterized.class)
public class TestOrder {
    public ChromeDriver driver;
    //public FirefoxDriver driver;
    public OrderPage orderPage;
    public MainPage mainPage;


    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String station;
    private final By clickOrderButton;

    public TestOrder(String name, String surname, String address, String phoneNumber, String station, By clickOrderButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.clickOrderButton = clickOrderButton;
    }


    @Parameterized.Parameters

    public static Object[][] getOrderParameters() {
        MainPage mainPage = new MainPage();
        return new Object[][]{
                {"Алина", "Зайцева", "Пионерская 17", "89148170846", "Водный стадион", mainPage.ORDER_BUTTON_HEADER},
                {"Марк", "Парубенко", "Советская улица", "+79148170846", "Лубянка", mainPage.ORDER_BUTTON_DOWN}
        };

    }

    @Before
    public void setUpOrder() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

        orderPage = new OrderPage(driver);
        mainPage = new MainPage(driver);

        mainPage.openWedsite()
                .click(mainPage.getCookie());
    }


    @Test
    public void successfulOrderCreation() {

        mainPage.clickOnTheOrderButton(clickOrderButton);
        orderPage.fillingTheData(name, surname, address, phoneNumber, station);
        mainPage.click(orderPage.getNextButton());
        orderPage.fillingTheDataThan();
        mainPage.click(orderPage.getOrderButton())
                .click(orderPage.getOrderYes());

        assertTrue("Заказ оформлен",
                mainPage.isElementPresent(orderPage.ORDER_PLACED_HEADER));

    }

    @After
    public void teardown() {
        driver.quit();

    }
}
