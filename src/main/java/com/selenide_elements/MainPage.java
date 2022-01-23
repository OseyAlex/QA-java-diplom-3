package com.selenide_elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {
    //обьявляем URL главной страницы
    public static final String mainPageURL = "https://stellarburgers.nomoreparties.site/";

    //локатор кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[.='Войти в аккаунт']")
    private SelenideElement signInButton;

    //локатор кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//button[.='Оформить заказ']")
    private SelenideElement makeOrderButton;

    //локатор элемента 'Личный кабинет'"
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement personalAccountElement;

    //локатор элементов бургреа
    @FindBy(how = How.CLASS_NAME, using = "BurgerIngredients_ingredients__menuContainer__Xu3Mo")
    private SelenideElement burgerElements;

    //локатор элемента Булки
    @FindBy(how = How.XPATH, using = "//*[@class='App_componentContainer__2JC2W']//span[text()='Булки']")
    private SelenideElement breadsElement;

    //локатор раздела Булки
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']")
    private SelenideElement breadsSection;

    //локатор элемента Соусы
    @FindBy(how = How.XPATH, using = "//*[@class='App_componentContainer__2JC2W']//span[text()='Соусы']")
    private SelenideElement sauceElement;

    //локатор раздела Соусы
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']")
    private SelenideElement sauceSection;

    //локатор элемента Начинки
    @FindBy(how = How.XPATH, using = "//*[@class='App_componentContainer__2JC2W']//span[text()='Начинки']")
    private SelenideElement fillingElement;

    //локатор раздела Начинки
    @FindBy(how = How.XPATH, using = ".//*[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']")
    private SelenideElement fillingSection;

    @Step("Клик по кнопке 'Войти'")
    public void clickSignInButton() {
        signInButton.click();
    }

    @Step("Проверка отображения нопки оформить заказ")
    public void checkMakeOrderButtonVisibility() {
        makeOrderButton.shouldBe(visible);
    }

    @Step("Клик по локатору 'Личный кабинет'")
    public void clickPersonalAccountElement() {
        personalAccountElement.click();
        sleep(300);
    }

    @Step("Проверка отображения булок и соусов бургера'")
    public void checkBurgerComponents() {
        burgerElements.shouldBe(visible);
    }

    @Step("Клик по элементам коснструктора и проверка видимости")
    public MainPage checkSauceSection() {
        sauceElement.click();
        sleep(300);
        sauceSection.shouldBe(visible, enabled);
        return this;
    }

    @Step("Клик по элементам коснструктора и проверка видимости")
    public MainPage checkFillingSection() {
        fillingElement.click();
        sleep(300);
        fillingSection.shouldBe(visible, enabled);
        return this;
    }

    @Step("Клик по элементам коснструктора и проверка видимости")
    public MainPage checkBreadSection() {
        breadsElement.click();
        sleep(300);
        breadsSection.shouldBe(visible, enabled);
        return this;
    }
}

