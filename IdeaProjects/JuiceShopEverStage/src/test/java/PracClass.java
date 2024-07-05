import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracClass {


    @Test
    public void prac() {
        WebDriver driver=new ChromeDriver();
        driver.get("");
    }

}
