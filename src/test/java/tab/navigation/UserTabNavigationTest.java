package tab.navigation;

import com.UserOperations;
import com.selenide.elements.LoginPage;
import com.selenide.elements.MainPage;
import com.selenide.elements.ProfilePage;
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
import static scripts.SetBrowserProperty.setBrowserProperty;

public class UserTabNavigationTest {

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
    @DisplayName("Проверка перехода по клику на «Личный кабинет»")
    public void personalAccountClickTest() {
        MainPage mainPage = open(MainPage.mainPageURL, MainPage.class);
        mainPage.clickSignInButton();

        LoginPage loginPage = page(LoginPage.class).loginUser(credentials.get("email"), credentials.get("password"));
        mainPage.clickPersonalAccountElement();
        ProfilePage profilePage = page(ProfilePage.class);
        assertEquals(ProfilePage.personalAccountURL, getWebDriver().getCurrentUrl());
    }


    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void personalAccountFormToConstructorTest() {
        MainPage mainPage = open(MainPage.mainPageURL, MainPage.class);
        mainPage.clickSignInButton();

        LoginPage loginPage = page(LoginPage.class).loginUser(credentials.get("email"), credentials.get("password"));
        mainPage.clickPersonalAccountElement();
        ProfilePage profilePage = page(ProfilePage.class).clickConstructorElement();
        mainPage.checkBurgerComponents();
    }

    @Test
    @DisplayName("Переход из личного кабинета по логотипу на главную страницу")
    public void personalAccountFormToLogoTest() {
        MainPage mainPage = open(MainPage.mainPageURL, MainPage.class);
        mainPage.clickSignInButton();

        LoginPage loginPage = page(LoginPage.class).loginUser(credentials.get("email"), credentials.get("password"));
        mainPage.clickPersonalAccountElement();
        ProfilePage profilePage = page(ProfilePage.class).clickLogoElement();
        mainPage.checkBurgerComponents();
        assertEquals(MainPage.mainPageURL, getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void logoutTest() {
        MainPage mainPage = open(MainPage.mainPageURL, MainPage.class);
        mainPage.clickSignInButton();

        LoginPage loginPage = page(LoginPage.class).loginUser(credentials.get("email"), credentials.get("password"));
        mainPage.clickPersonalAccountElement();
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickLogoutButton();
        assertEquals(LoginPage.loginPageURL, getWebDriver().getCurrentUrl());
    }
}