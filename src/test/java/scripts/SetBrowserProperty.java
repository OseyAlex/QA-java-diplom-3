package scripts;

import com.codeborne.selenide.Configuration;

public class SetBrowserProperty {
    public static void setBrowserProperty() {
        Configuration.startMaximized = true;
        String browser = System.getProperty("browser.type");

        if (browser.equals("yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        }
    }
}
