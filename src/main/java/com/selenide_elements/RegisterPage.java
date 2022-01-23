package com.selenide_elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class RegisterPage {

    //обьявляем URL страницы регистрации
    public static final String registerPageURL = "https://stellarburgers.nomoreparties.site/register";

    //локатор поля "Имя"
    @FindBy(how = How.NAME, using = "name")
    private SelenideElement nameField;

    //локатор поля "Email"
    @FindBy(how = How.XPATH, using = "//label[.='Email']/following-sibling::input")
    private SelenideElement emailField;

    //локатор поля "Пароль"
    @FindBy(how = How.NAME, using = "Пароль")
    private SelenideElement passwordField;

    //локатор кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//button[.='Зарегистрироваться']")
    private SelenideElement registerButton;

    //локатор для ошибки некорректного пароля
    @FindBy(how = How.XPATH, using = ".//*[@class='input__error text_type_main-default']")
    private SelenideElement wrongPasswordMessage;

    //локатор элемента "Регистрация"
    @FindBy(how = How.CLASS_NAME, using = "Auth_login__3hAey")
    private SelenideElement loginHeader;

    //локатор элемента "Войти"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Войти')]")
    private SelenideElement signInUrl;

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public RegisterPage clickRegisterButton() {
        registerButton.click();
        sleep(300);
        return this;
    }

    @Step("Заполняем имя")
    public RegisterPage setName(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Заполняем пароль")
    public RegisterPage setPassword(String password) {
        passwordField.setValue(password).sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Заполняем Email")
    public RegisterPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Проверка отображения сообщения о неправильном пароле")
    public void checkWrongPasswordVisibility() {
        wrongPasswordMessage.shouldBe(visible);
    }

    @Step("Клик по ссылке 'Войти'")
    public RegisterPage clickSignInUrl() {
        signInUrl.click();
        return this;
    }
}
