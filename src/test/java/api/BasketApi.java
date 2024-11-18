package api;


import io.qameta.allure.Step;
import models.BasketAddRequestModel;
import models.BusketAddRequestCollectionModel;
import data.TestData;

import java.util.List;

import static api.specs.LogSpec.*;
import static io.restassured.RestAssured.given;

public class BasketApi {

    @Step("Подготовка. Добавление товара в корзину")
    public static String addBookToBasket(){

        TestData testData = new TestData();
        BusketAddRequestCollectionModel isbnModel = new BusketAddRequestCollectionModel(testData.getTestBook());
        BasketAddRequestModel request = new BasketAddRequestModel(testData.getUserId(), List.of(isbnModel));

        return given(RequestSpec)
                .header("Authorization", "Bearer " + AuthorizationApi.getAuthCookie().getToken())
                .body(request)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(ResponseSpec201).toString();
    }

    @Step("ПОдготовка. Удаление всех товаров с корзины")
    public static String deleteAllBooksFromBasket(){

        TestData testData = new TestData();

        return given(RequestSpec)
                .header("Authorization", "Bearer " + AuthorizationApi.getAuthCookie().getToken())
                .queryParam("UserId", testData.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(ResponseSpec400).toString();
    }
}
