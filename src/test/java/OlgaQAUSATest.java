import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OlgaQAUSATest {

    //    TC_1_1  - Тест кейс:
    //    //1. Открыть страницу https://openweathermap.org/
    //    //2. Набрать в строке поиска город Paris
    //    //3. Нажать пункт меню Search
    //    //4. Из выпадающего списка выбрать Paris, FR
    //    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(1000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );
        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

//    @Test
//    public void test_name() {
//        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//
//        driver.quit();
//    }

//TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title этой страницы
// OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void test_OpenGuideWhenClickOnGuide() throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(3000);

        WebElement ButtonGuide = driver.findElement(
                By.xpath("//a[@href='/guide']")
        );

        ButtonGuide.click();

        String actualResult1 = driver.getCurrentUrl() ;
        String actualResult2 = driver.getTitle();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();

    }

    //TC_11_02
    //1.  Открыть базовую ссылку
    //2.  Нажать на единицы измерения Imperial: °F, mph
    //
    //3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test
    public void test_ChangeTemperatureToImperialInControls() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        boolean expectedResult1 = true;
        String SYMBOL_TEMP_F = "°F";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement findImperialSwitcher = driver.findElement(
                By.xpath("//div[@class='switch-container']/div[text()=\"Imperial: °F, mph\"]")
                //  By.xpath("//div[@class='switch-container']/div[3]")


        );

        findImperialSwitcher.click();


        WebElement findTempIndicator = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//span[@class = 'heading']")

        );



       String tempIndicator = findTempIndicator.getText();
        String actualResult =  tempIndicator.substring(tempIndicator.length()-2);
       // boolean actualResult1 = findTempIndicator.getText().contains("F");


        Assert.assertEquals(actualResult, SYMBOL_TEMP_F);
        Assert.assertTrue(findTempIndicator.getText().contains(SYMBOL_TEMP_F), SYMBOL_TEMP_F);

        driver.quit();

    }
    //TC_11_03
    //1.  Открыть базовую ссылку
    //2. Подтвердить, что внизу страницы есть панель с текстом
    // “We use cookies which are essential for the site to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies or manage them individually.”
    //3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”


    @Test
    public void test_TextAnd2ButtonInTheBottom() throws InterruptedException{

        System.setProperty("webdriver.chrome.driver", "/Applications/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedDescription = "We use cookies which are essential for the site to work. We also use non-essential "
                + "cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies"
                + " or manage them individually.";
        String button1Text = "Allow all";
        String button2Text = " Manage cookies " ;


        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        //Assert.assertTrue(driver.findElement(By.className("stick-footer-panel_container")).isDisplayed());

        WebElement cookiesDescription = driver.findElement(By.className("stick-footer-panel__description"));
        String actualDescription = cookiesDescription.getText();

        Assert.assertEquals(actualDescription, expectedDescription);

        Assert.assertEquals(
                driver.findElements(By.xpath("//div[@class = 'stick-footer-panel__btn-container']/*"))
                        .size(),2
        );

        Assert.assertTrue(driver.findElement(
                By.xpath("//div[@class = 'stick-footer-panel__btn-container']/*[text() = '" + button1Text + "']")
                )
                .isDisplayed()
        );

        Assert.assertTrue(driver.findElement(
                By.xpath("//div[@class = 'stick-footer-panel__btn-container']/*[text() = '" + button2Text + "']")
                )

                .isDisplayed()
        );

        driver.quit();
    }


}





