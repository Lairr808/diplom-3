package Pages;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CreateUser {
    private static final String PATH = "/api/auth/register";
    private static final String INF_PATH = "/api/auth/user";
    private static final String LOGIN_PATH = "/api/auth/login";
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    protected static RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }

    public static ValidatableResponse create(User user){//создать
        return given().log().all()
                .spec(getSpec())
                .body(user)
                .when()
                .post(PATH)
                .then().log().all();
    }

    public static ValidatableResponse delete(String accessToken) {//удалить
        return given().log().all()
                .spec(getSpec())
                .header("Authorization", accessToken)
                .body("")
                .when()
                .delete(INF_PATH)
                .then().log().all();
    }

    public static ValidatableResponse login(CredentialsUser credentials) {//войти
        return given().log().all()
                .spec(getSpec())
                .body(credentials) //тело запроса
                .when()
                .post(LOGIN_PATH)
                .then().log().all();
    }
}
