package tests;

import api.BasketApi;
import helpers.WithLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BasketPage;

@Tag("REGRESS")
@DisplayName("Корзина")
public class BasketTests extends TestBase{

    BasketPage basketPage = new BasketPage();

    @WithLogin
    @DisplayName("Успешное удаления товара из корзины авторизованного пользователя")
    @Test
    void successfulDeleteBookFromBasketTest(){
        BasketApi.deleteAllBooksFromBasket();
        BasketApi.addBookToBasket();

        basketPage
                .openBasketPage()
                .clickDeleteFirstBookOnList()
                .clickOkOnDeleteModal()
                .checkEmptyBookList();
    }
}
