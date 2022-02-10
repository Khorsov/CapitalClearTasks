package apiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;

import java.util.HashSet;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class ResponseValidation {
        @BeforeAll
        public static void init(){
                RestAssured.baseURI = "https://datausa.io/api";
        }

        @Deprecated
        @DisplayName("validates that year is the same in all elements of the data array")
        @org.junit.Test
        public void allDataTheSame(){
                List<String> listOfData = given().contentType(ContentType.JSON)
                        .queryParam("drilldowns","State")
                        .queryParam("measures","Population")
                        .queryParam("year","latest")
                        .when().get("/data")
                        .then().statusCode(200).extract().jsonPath().getList("data.Year");

                System.out.println(listOfData);
                boolean allEqual = new HashSet<String>(listOfData).size() <= 1;
                System.out.println(allEqual);//true

                //OR

                String[] itemsArray = new String[listOfData.size()];
                listOfData.toArray(itemsArray);
                String[] reversed = new String[listOfData.size()];
                for(int i=listOfData.size()-1, j=0;i>=0;i--,j++){
                        reversed[j] = itemsArray[i];
                }
                Assert.assertEquals(reversed,itemsArray); // If reversed array equals original array, it means every data in array the same
        }

        @DisplayName("validates that year is the same in all elements of the data array")
        @Test
        public void stateIsUnique(){
                List<String> listOfData = given().contentType(ContentType.JSON)
                        .queryParam("drilldowns","State")
                        .queryParam("measures","Population")
                        .queryParam("year","latest")
                        .when().get("/data")
                        .then().statusCode(200).extract().jsonPath().getList("data.State");

                int arrayLength = listOfData.size();
                //System.out.println(arrayLength);//52
                String[] stateArray = new String[listOfData.size()];
                listOfData.toArray(stateArray);
                boolean statesUnique;
                for (int i = 0 ;i < stateArray.length-1; i++) {
                        for (int j = i+1; j < stateArray.length; j++) {

                                if (stateArray[i] == stateArray[j]) {
                                        statesUnique = true;
                                        Assert.assertTrue(statesUnique==true);
                                }
                        }
                }
        }

        @AfterAll
        public static void cleanup(){
                reset();
        }


}
