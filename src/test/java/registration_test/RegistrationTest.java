package registration_test;

import com.codeborne.selenide.Configuration;

import com.data_generators.UserDataGenerator;
import com.selenide_elements.LoginPage;
import com.selenide_elements.MainPage;
import com.selenide_elements.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Configuration.startMaximized = true;

    }

    @After
    public void tearDown() {
        getWebDriver().quit();
    }

    @Test
    @DisplayName("Создать нового пользователя")
    public void createNewUserTest() {

        UserDataGenerator userData = new UserDataGenerator();

        MainPage newUser = open(MainPage.mainPageURL, MainPage.class);
        newUser.clickSignInButton();

        LoginPage loginPage = page(LoginPage.class).clickRegistrationUrl();

        page(RegisterPage.class)
                .setName(userData.getUserName())
                .setEmail(userData.getEmail())
                .setPassword(userData.getPassword())
                .clickRegisterButton();
        assertEquals(loginPage.loginPageURL, getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Ошибка неверного пароля")
    public void createNewUserWrongPassTest() {

        UserDataGenerator userData = new UserDataGenerator();

        MainPage newUser = open(MainPage.mainPageURL, MainPage.class);
        newUser.clickSignInButton();

        LoginPage loginPage = page(LoginPage.class).clickRegistrationUrl();

        RegisterPage registerPage = page(RegisterPage.class)
                .setName(userData.getUserName())
                .setEmail(userData.getEmail())
                .setPassword("Wrong")
                .clickRegisterButton();
        registerPage.checkWrongPasswordVisibility();

        assertEquals(registerPage.registerPageURL, getWebDriver().getCurrentUrl());
    }
}