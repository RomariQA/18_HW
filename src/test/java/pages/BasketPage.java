package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasketPage {

    private SelenideElement firstButtonDeleteBook = $("#delete-record-undefined"),
            okButtonOnDeleteBookModal = $("#closeSmallModal-ok"),
            bookList = $(".rt-tbody");

    @Step("Открываем страницу корзины")
    public BasketPage openBasketPage(){
        open("/profile");

        return this;
    }

    @Step("Клик на кнопку удаления в первом елементе списка")
    public BasketPage clickDeleteFirstBookOnList(){
        firstButtonDeleteBook.click();;

        return this;
    }

    @Step("Подтверждение удаления в попапе")
    public BasketPage clickOkOnDeleteModal(){
        okButtonOnDeleteBookModal.click();

        return this;
    }

    @Step("В списке нет удаленной книги")
    public BasketPage checkEmptyBookList(){
        bookList.shouldNotHave(text("Speaking JavaScript"));

        return this;
    }
}
