package api;


import models.BasketAddRequestModel;
import models.BusketAddRequestCollectionModel;
import data.TestData;

import java.util.List;

import static api.specs.LogSpec.*;
import static io.restassured.RestAssured.given;

public class BasketApi {

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
