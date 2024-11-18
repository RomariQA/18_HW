package helpers;

import api.AuthorizationApi;
import io.qameta.allure.Step;
import models.LoginResponseModel;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginException implements BeforeEachCallback {

    public static LoginResponseModel cookies;

    @Step("Подготовка - Авторизация")
    @Override
    public void beforeEach (ExtensionContext context){
        cookies = AuthorizationApi.getAuthCookie();

        open("/images/Toolsqa.jpg");
        getWebDriver().manage().addCookie(new Cookie("token", cookies.getToken()));
        getWebDriver().manage().addCookie(new Cookie("expires", cookies.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("userID", cookies.getUserId()));
    }

}
