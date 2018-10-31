import static org.junit.Assert.assertEquals;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashSet;
import java.util.List;

public class CheckHTMLTagsTest {
    private static WebDriver seleniumWebDriverInstance;
    private static String url;

    @BeforeClass
    public static void beforeMethod(){
        seleniumWebDriverInstance= new ChromeDriver();
        url="https://mvnrepository.com/";
        seleniumWebDriverInstance.get(url);
    }
    @Test
    public void testMethodScriptNumber(){

        int sizeOfScriptTags = seleniumWebDriverInstance.findElements(By.xpath("//script[@type='text/javascript']")).size();
        assertEquals(1, sizeOfScriptTags);
        System.out.println(sizeOfScriptTags);
    }
    @Test
    public void testMethodScriptWithoutSrc(){
        int sizeOfAllScripts= seleniumWebDriverInstance.findElements(By.xpath("//script")).size();
        int sizeOfScriptTagsWithSrc = seleniumWebDriverInstance.findElements(By.xpath("//script[@src]")).size();
        assertEquals(sizeOfScriptTagsWithSrc, sizeOfAllScripts);
    }
    @Test
    public void testMethodCssNumber() {

        int sizeOfCssTags = seleniumWebDriverInstance.findElements(By.xpath("//style[@type='text/css']")).size();
        assertEquals(1, sizeOfCssTags);
        System.out.println(sizeOfCssTags);
    }
    @Test
    public void testMethodStyleNumber() {

        int sizeOfStyleTags = seleniumWebDriverInstance.findElements(By.xpath("//style")).size();
        assertEquals(0, sizeOfStyleTags);
        System.out.println(sizeOfStyleTags);
    }
    @Test
    public void testMethodH1Number() {

        int sizeOfH1Tags = seleniumWebDriverInstance.findElements(By.xpath("//h1")).size();
        assertEquals(1, sizeOfH1Tags);
        System.out.println(sizeOfH1Tags);
    }
    @Test
    public void testMethodID() {

        List<WebElement> ID = seleniumWebDriverInstance.findElements(By.xpath("//div[@id]"));
        HashSet<WebElement> UniqID=new HashSet<WebElement>(ID);
        assertEquals(ID.size(),UniqID.size());
    }

    @AfterClass
    public static void afterMethod(){
        seleniumWebDriverInstance.quit();
    }
}
