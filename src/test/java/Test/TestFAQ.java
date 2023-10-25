package Test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import page.object.MainPage;
//import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.matchers.JUnitMatchers.containsString;

@RunWith(Parameterized.class)
public class TestFAQ {
    public static ChromeDriver driver;
    // public static FirefoxDriver driver;
    public static MainPage mainPage;
    private final String checkedText;
    private final int index;

    public TestFAQ(int index, String checkedText) {
        this.index = index;
        this.checkedText = checkedText;
    }

    @Parameterized.Parameters
    public static Object[][] getTestFAQ() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

        };
    }

    @BeforeClass
    public static void globalSetup() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        mainPage.openWedsite();
        mainPage.click(mainPage.getCookie());
        mainPage.click(mainPage.getFAQ());
    }

    @Test
    public void fillingTheData() {
        mainPage.click(mainPage.getListQuestions().get(index));
        Assert.assertThat(mainPage.getListAnswer()
                .get(index)
                .getText(), containsString(checkedText));
    }


    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
