package api;


import io.qameta.allure.Step;
import models.BasketAddRequestModel;
import models.BusketAddRequestCollectionModel;
import data.TestData;

import java.util.List;

import static api.specs.LogSpec.*;
import static io.restassured.RestAssured.given;

public class BasketApi {

    @Step("Добавление товара в корзину")
    public static String addBookToBasket(){

        TestData testData = new TestData();
        BasketAddRequestModel request = new BasketAddRequestModel();
        BusketAddRequestCollectionModel isbnModel = new BusketAddRequestCollectionModel();
        isbnModel.setIsbn(testData.getTestBook());
        request.setUserId(testData.getUserId());
        request.setCollectionOfIsbns(List.of(isbnModel));

        return given(RequestSpec)
                .header("Authorization", "Bearer " + AuthorizationApi.getAuthCookie().getToken())
                .body(request)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(ResponseSpec201).toString();
    }

    @Step("Удаление всех товаров с корзины")
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
