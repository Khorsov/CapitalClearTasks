package apiTest;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

public class BDDStyledMethod {
    public static void SimpleGetRequest(){
        given().contentType(ContentType.JSON)
                .queryParam("drilldowns","State")
                .queryParam("measures","Population")
                .queryParam("year","latest")
                .when().get("https://datausa.io/api/data")
                .then().statusCode(200);
    }
}
