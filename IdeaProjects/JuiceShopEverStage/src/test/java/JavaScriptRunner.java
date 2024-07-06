import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class JavaScriptRunner {
    private JavaScriptRunner(){}

    static void runJavaScript(WebDriver driver, String javaScript){
        ((JavascriptExecutor) driver).executeScript(javaScript);
    }
    static void runJavaScript(WebDriver driver, WebElement element, String javaScript){
        ((JavascriptExecutor) driver).executeScript(javaScript, element);
    }

    static Object runJavaScriptAndObject(WebDriver driver, String javaScript){
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

}
