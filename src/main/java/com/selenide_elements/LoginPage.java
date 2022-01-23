package com.selenide_elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage {

    //обьявляем URL страницы логина
    public static final String loginPageURL = "https://stellarburgers.nomoreparties.site/login";

    //локатор элемента "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registerUrl;

    //локатор элемента "Восстановить пароль"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Восстановить пароль')]")
    private SelenideElement restorePasswordUrl;

    //локатор поля "Email"
    @FindBy(how = How.XPATH, using = "//label[.='Email']/following-sibling::input")
    private SelenideElement emailField;

    //локатор поля "Пароль"
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;

    //локатор кнопки "Войти"
    @FindBy(how = How.XPATH, using = "//button[.='Войти']")
    private SelenideElement sighInButton;

    @Step("Клик по ссылке 'Зарегистрироваться'")
    public LoginPage clickRegistrationUrl() {
        registerUrl.click();
        return this;
    }

    @Step("Клик по ссылке 'Восстановите пароль'")
    public LoginPage clickRestorePasswordUrl() {
        restorePasswordUrl.click();
        return this;
    }


    @Step("Проиводим логин пользователя")
    public LoginPage loginUser(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        sighInButton.click();
        sleep(300);
        return this;
    }
}
