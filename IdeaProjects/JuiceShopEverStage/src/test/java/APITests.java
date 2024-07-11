import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.pojo.ReqBodyForCardCreationBuilder;
import com.everstage.juiceshop.requestBuilders.RequestBuilders;
import com.everstage.juiceshop.utils.FileReadAndWriter;
import com.everstage.juiceshop.utils.RandomValueProvider;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.equalTo;

public final class APITests {
    private APITests(){}

    int id =0;
    @SneakyThrows
    @Test()
    public void postCall() {

        ReqBodyForCardCreationBuilder reqBody=ReqBodyForCardCreationBuilder.builder()
                .setFullName(RandomValueProvider.randomFullName())
                .setCardNum(RandomValueProvider.randomCardNumber())
                .setExpMonth(RandomValueProvider.randomExpMonth())
                .setExpYear(RandomValueProvider.randomExpYear())
                .build();

        Response postResponse=RequestBuilders.postCalls()
                .body(reqBody)
                .post("/api/Cards/");
        postResponse.prettyPrint();
        id = postResponse.jsonPath().getInt("data.id");

        // Writing response
        FileReadAndWriter.writeJsonAndStoreAsString(FrameworkConstants.getPOST_RESPONSE_PATH(),postResponse);

        // Assertions
        postResponse.then()
                .assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\ragus\\IdeaProjects\\JuiceShopEverStage\\src\\test\\resources\\schemas\\schemapost.json")))
                .log();
    }
    @Test(dependsOnMethods = "postCall",priority = 1)
    public void getCall() {
        Response getResponse=RequestBuilders.getCalls()
                .pathParam("id",id)
                .get("/api/Cards/{id}");
        getResponse.prettyPrint();

        // Writing Response
        FileReadAndWriter.writeJsonAndStoreAsString(FrameworkConstants.getGET_RESPONSE_PATH(),getResponse);


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

        // Writing Response
        FileReadAndWriter.writeJsonAndStoreAsString(FrameworkConstants.getDELETE_RESPONSE_PATH(),deleteResponse);

        // Assertions
        deleteResponse.then()
                .assertThat()
                .statusCode(200)
                .body("data",equalTo("Card deleted successfully."))
                .body("status",equalTo("success"))
                .log();
    }

}
