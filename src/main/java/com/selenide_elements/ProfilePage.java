package com.selenide_elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.sleep;

public class ProfilePage {
    //обьявляем URL страницы Личный кабинет
    public static final String personalAccountURL = "https://stellarburgers.nomoreparties.site/account/profile";

    //локатор элемента "Конструктор"
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Конструктор')]")
    private SelenideElement constructorElement;

    //локатор кнопки "Выход"
    @FindBy(how = How.XPATH, using = "//button[.='Выход']")
    private SelenideElement logoutButton;

    //локатор логотип Stellar Burgers
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoElement;

    @Step("Клик по элементу 'Конструктор'")
    public ProfilePage clickConstructorElement() {
        constructorElement.click();
        sleep(300);
        return this;
    }

    @Step("Клик по элементу 'Конструктор'")
    public ProfilePage clickLogoutButton() {
        logoutButton.click();
        sleep(300);
        return this;
    }

    @Step("Клик по элементу 'Конструктор'")
    public ProfilePage clickLogoElement() {
        logoElement.click();
        sleep(300);
        return this;
    }
}
