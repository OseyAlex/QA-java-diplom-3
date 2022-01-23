package login_test;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import com.selenide_elements.LoginPage;
import com.selenide_elements.MainPage;
import com.selenide_elements.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertEquals;

public class LoginTest {
    UserOperations createNewUser = new UserOperations();
    Map<String, String> credentials = new HashMap<>();

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
        credentials = createNewUser.register();
    }

    @After
    public void tearDown() {
        getWebDriver().quit();
        createNewUser.delete();
    }

    @Test
    @DisplayName("Логин пользователя с главной страницы")
    public void loginUserMainPageTest() {
        MainPage mainPage = open(MainPage.mainPageURL, MainPage.class);
        mainPage.clickSignInButton();

        LoginPage loginPage = page(LoginPage.class).loginUser(credentials.get("email"), credentials.get("password"));
        mainPage.checkMakeOrderButtonVisibility();
        assertEquals(MainPage.mainPageURL, getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Логин пользователя через кнопку 'Личный кабинет'")
    public void loginUserViaPersonalAccountTest() {
        MainPage mainPage = open(MainPage.mainPageURL, MainPage.class);
        mainPage.clickPersonalAccountElement();

        LoginPage loginPage = page(LoginPage.class).loginUser(credentials.get("email"), credentials.get("password"));
        mainPage.checkMakeOrderButtonVisibility();
        assertEquals(MainPage.mainPageURL, getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Логин пользователя через форму регистрации")
    public void loginUserViaRegistrationFormTest() {
        MainPage mainPage = open(MainPage.mainPageURL, MainPage.class);
        mainPage.clickSignInButton();

        LoginPage loginPage = page(LoginPage.class).clickRegistrationUrl();
        RegisterPage registerPage = page(RegisterPage.class).clickSignInUrl();
        loginPage.loginUser(credentials.get("email"), credentials.get("password"));
        mainPage.checkMakeOrderButtonVisibility();
        assertEquals(MainPage.mainPageURL, getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Логин пользователя через форму восстановления пароля")
    public void loginUserViaRestoreCredentialsFormTest() {
        MainPage mainPage = open(MainPage.mainPageURL, MainPage.class);
        mainPage.clickSignInButton();

        LoginPage loginPage = page(LoginPage.class).clickRestorePasswordUrl();
        RegisterPage registerPage = page(RegisterPage.class).clickSignInUrl();
        loginPage.loginUser(credentials.get("email"), credentials.get("password"));
        mainPage.checkMakeOrderButtonVisibility();
        assertEquals(MainPage.mainPageURL, getWebDriver().getCurrentUrl());
    }
}