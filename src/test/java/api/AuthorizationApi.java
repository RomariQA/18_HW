package api;

import models.LoginRequestModel;
import models.LoginResponseModel;
import data.TestData;

import static api.specs.LogSpec.RequestSpec;
import static api.specs.LogSpec.ResponseSpec200;
import static io.restassured.RestAssured.given;

public class AuthorizationApi {


    public static LoginResponseModel getAuthCookie(){
        TestData testData = new TestData();
        LoginRequestModel request = new LoginRequestModel();
        request.setUserName(testData.getUserName());
        request.setPassword(testData.getUserPassword());

        return given(RequestSpec)
                .body(request)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(ResponseSpec200)
                .extract().as(LoginResponseModel.class);
    }
}
