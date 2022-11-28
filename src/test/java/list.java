//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//import static java.sql.DriverManager.getDriver;
//
//public class list {
//    private List<String> getElementsText(By by, WebDriver driver){
//        List <WebElement> elementsList = getListOfElements(by, driver);
//        //мы создаем листЭлементов, использую предыдущий метов getListOfElements
//        // по локатору и драйверу. Далее мы хотим считать с каждого элемента
//        // из листаЭлементов текст и записать его в листТекстов. Для этого мы
//        // создаем листТекстов
//        List<String> textList = new ArrayList<>();
//        //после создания листаТекстов мы через цикл foreach
//        // 1.мы из каждого элемента из листаЭлементов \ WebElement element : elementsList
//        // 2. будем считывать текст \ element.getText()
//        // 3. переводить в нижний регистр \ element.getText().toLowerCase())
//        // 4. записывать в листТекстов \ textList.add
//        for(WebElement element : elementsList){
//            textList.add(element.getText().toLowerCase());
//        }
//
//        return textList;
//    }
//    public void waitTextToBeChanged(By by, String text, WebDriver driver, WebDriverWait wait) {
//        wait.until(ExpectedConditions
//                .not(ExpectedConditions.textToBePresentInElement(driver.findElement(by), text)));
//    }
//    private String getText(By by, WebDriver driver){
//        return driver.findElement(by).getText();
//    }
//    @Test
//    public void testSearchForLanguageByName_HappyPath(){
//        final String LANGUAGE_NAME = "python";
//
//        openBaseURL(getDriver());
//        click(SEARCH_LANGUAGES_MENU, getDriver());
//        click(SEARCH_FOR_FIELD, getDriver());
//        input(LANGUAGE_NAME,SEARCH_FOR_FIELD, getDriver());
//        click(GO_BUTTON, getDriver());
//        //  мы записали в переменную List<String> languageNames все тексты,
//        //  что мы нашли с помощью метода getElementsText , когда мы сначала
//        //  находили списокЭлементов, затем считывали с каждого из эл-в текст
//        //  и записывали все в листТекстов
//        List<String> languageNames = getElementsText(LANGUAGES_NAMES_LIST,getDriver());
//
//        int sizeOfLanguagesNamesList = getListSize(languageNames);
//        //мы определеяем размер листаТекстов
//        Assert.assertTrue(languageNames.size() > 0);
//        //cчитываем что в каждом тексте из листаТекстов содержится искомый "текст"
//        for (String languageName : languageNames) {
//            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
//        }
//    }
//}
