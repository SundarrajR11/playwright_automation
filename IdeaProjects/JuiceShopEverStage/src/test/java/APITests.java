import com.everstage.juiceshop.pojo.ReqBodyForCardCreationBuilder;
import com.everstage.juiceshop.requestBuilders.RequestBuilders;
import com.everstage.juiceshop.utils.RandomValueProvider;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public final class APITests {
    private APITests(){}

    int id =0;
    @Test()
    public void postCall() {

        /*String reqBody="{\n" +
                "  \"fullName\": \"Sundarraj R\",\n" +
                "  \"cardNum\": \"1234123412341234\",\n" +
                "  \"expMonth\": \"12\",\n" +
                "  \"expYear\": \"2080\"\n" +
                "}";*/

        ReqBodyForCardCreationBuilder reqBody=ReqBodyForCardCreationBuilder.builder()
                .setFullName(RandomValueProvider.randomFullName())
                .setCarNUm(RandomValueProvider.randomCardNumber())
                .setExpMonth(RandomValueProvider.randomExpMonth())
                .setExpYear(RandomValueProvider.randomExpYear())
                .build();

        Response postResponse=RequestBuilders.postCalls()
                .body(reqBody)
                .post("/api/Cards/");
        postResponse.prettyPrint();
        id = postResponse.jsonPath().getInt("data.id");

        // Assertions
        postResponse.then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .log();
    }
    @Test(dependsOnMethods = "postCall",priority = 1)
    public void getCall() {
        Response getResponse=RequestBuilders.getCalls()
                .pathParam("id",id)
                .get("/api/Cards/{id}");
        getResponse.prettyPrint();

        // Assertions
        getResponse.then()
                .assertThat()
                .statusCode(200)
                .header("Connection","keep-alive")
                .log();
    }
    @Test(dependsOnMethods = "postCall",priority = 2)
    public void deleteCall() {
        Response deleteResponse=RequestBuilders.deleteCalls()
                .pathParam("id",id)
                .delete("/api/Cards/{id}");
        deleteResponse.prettyPrint();

        // Assertions
        deleteResponse.then()
                .assertThat()
                .statusCode(200)
                .body("data",equalTo("Card deleted successfully."))
                .body("status",equalTo("success"))
                .log();
    }

}
