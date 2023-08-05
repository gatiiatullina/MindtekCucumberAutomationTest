package utilities;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RestAPITest {
    public static void main(String[] args) {
        /**
         * Make get yard API call.
         * Request:
            1. URL -> BaseURL & Endpoint -> http://3.137.169.132/en-us/api/v2/yards/10/
            2. Headers -> Authorisation(Token), Accept(application/json), Content-type
            3. Method -> GET
         * Response:

         */
        given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().header("Accept","application/json")
                .when().get("yards/10/")
                .then().log().all();
//        System.out.println(response.statusCode());
//        System.out.println(response.body().asString());

        /**
         * POST call
         * Request:
         *             1. URL -> BaseURL & Endpoint -> http://3.137.169.132/en-us/api/v2/yards/51/
         *             2. Headers -> Authorisation(Token), Content-type(application/json), Accept(application/json)
         *             3. Payload/Body -> json
         *             4. Method -> POST
         *  Response:
         *  1. Status code -> 201
         *  2. Body -> json
         */
        Response postResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization","Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"id\": 51,\n" +
                        "  \"location\": \"Mila101\",\n" +
                        "  \"name\": \"Y51\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"112 Street\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"Raleigh\",\n" +
                        "  \"state\": \"NC\",\n" +
                        "  \"zip_code\": \"27611\",\n" +
                        "  \"spots\": 123,\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"contacts\": []\n" +
                        "}")
                .when().post("/yards/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.body().asString());

        /**
         * Patch Call
         * Request:
         *  1. URL -> BaseURL & Endpoint -> http://3.137.169.132/en-us/api/v2/yards/
         *  2. Headers -> Authorisation(Token), Content-type(application/json), Accept(application/json)
         *  3. Payload/Body -> json
         *  4. Method -> PATCH
         * Response:
         *           1. Status code -> 200
         *           2. Body -> json
         */
        Response updateResponse = given().baseUri("http://3.137.169.132/en-us/api/v2")
                .and().header("Authorization", "Token 9d3994dd2afd7d1d8ae9ecf4d77e45932bb210d6")
                .and().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\n" +
                        "  \"id\": 51,\n" +
                        "  \"location\": \"Mila101\",\n" +
                        "  \"name\": \"Y51\",\n" +
                        "  \"status\": \"active\",\n" +
                        "  \"address\": \"112 Street\",\n" +
                        "  \"apt_suite_company_co\": \"\",\n" +
                        "  \"city\": \"Raleigh\",\n" +
                        "  \"state\": \"NC\",\n" +
                        "  \"zip_code\": \"27611\",\n" +
                        "  \"spots\": 123,\n" +
                        "  \"warning\": \"\",\n" +
                        "  \"notes\": \"\",\n" +
                        "  \"contacts\": []\n" +
                        "}")
                .when().patch("/yards/51/");
        System.out.println(updateResponse.statusCode());
        System.out.println(updateResponse.body().asString());
    }
}
