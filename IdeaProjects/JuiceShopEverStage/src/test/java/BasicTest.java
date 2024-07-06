import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.customexceptions.InvalidObjectMapperDetailsException;
import com.everstage.juiceshop.driver.DriverManager;
import com.everstage.juiceshop.pojo.LoginInputBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasicTest {
    static WebDriver driver=null;
    static WebDriverWait wait=null;
    static LoginInputBuilder userCredentials= null;


    @BeforeMethod
    public void setUp(){
        // Reading input from new-user.json using jackson-databind library
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            userCredentials = objectMapper.readValue(new File(FrameworkConstants.getLOGIN_JSON_PATH()), LoginInputBuilder.class);
        } catch (IOException e) {
            throw new InvalidObjectMapperDetailsException("Verify json file path and Class file");
        }

        driver=DriverManager.getInstance();
        driver.get(FrameworkConstants.getWEB_LOGIN_URL());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(FrameworkConstants.getEXP_TIME_WAIT()));
    }
    @AfterMethod
    public void tearDown(){
       driver.quit();
    }

}
