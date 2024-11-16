package helpers;

import api.AuthorizationApi;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginException implements BeforeEachCallback {

    @Override
    public void beforeEach (ExtensionContext context){
        String token = AuthorizationApi.getAuthCookie().getToken();
        String userId = AuthorizationApi.getAuthCookie().getUserId();
        String expires = AuthorizationApi.getAuthCookie().getExpires();

        open("/images/Toolsqa.jpg");
        getWebDriver().manage().addCookie(new Cookie("token", token));
        getWebDriver().manage().addCookie(new Cookie("expires", expires));
        getWebDriver().manage().addCookie(new Cookie("userID", userId));
    }

}
