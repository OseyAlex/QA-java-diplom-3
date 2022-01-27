package tab.navigation;

import com.UserOperations;
import com.selenide.elements.LoginPage;
import com.selenide.elements.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static scripts.SetBrowserProperty.setBrowserProperty;

public class ConstructorNavigationTest {

    UserOperations createNewUser = new UserOperations();
    Map<String, String> credentials = new HashMap<>();

    @Before
    public void setUp() {
        setBrowserProperty();
        credentials = createNewUser.register();
    }

    @After
    public void tearDown() {
        getWebDriver().quit();
        createNewUser.delete();
    }

    @Test
    @DisplayName("Проверка перехода по кликам на «Булки», «Соусы», «Начинки» в конструкторе")
    public void clickConstructorElementsTest() {
        MainPage mainPage = open(MainPage.mainPageURL, MainPage.class);
        mainPage.clickSignInButton();
        page(LoginPage.class).loginUser(credentials.get("email"), credentials.get("password"));
        mainPage.checkSauceSection().checkFillingSection().checkBreadSection();
    }
}
