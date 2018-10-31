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
    private static WebDriver WebDriver;
    private static String url;

    @BeforeClass
    public static void beforeMethod(){
        WebDriver= new ChromeDriver();
        url="https://mvnrepository.com/";
        WebDriver.get(url);
    }
    //
    @Test
    public void testMethodScriptNumber(){

        int sizeOfScriptTags = WebDriver.findElements(By.xpath("//script[@type='text/javascript']")).size();
        assertEquals(1, sizeOfScriptTags);
        System.out.println(sizeOfScriptTags);
    }
    @Test
    public void testMethodScriptWithoutSrc(){
        int sizeOfAllScripts= WebDriver.findElements(By.xpath("//script")).size();
        int sizeOfScriptTagsWithSrc = WebDriver.findElements(By.xpath("//script[@src]")).size();
        assertEquals(sizeOfScriptTagsWithSrc, sizeOfAllScripts);
    }
    @Test
    public void testMethodCssNumber() {

        int sizeOfCssTags = WebDriver.findElements(By.xpath("//style[@type='text/css']")).size();
        assertEquals(1, sizeOfCssTags);
        System.out.println(sizeOfCssTags);
    }
    @Test
    public void testMethodStyleNumber() {

        int sizeOfStyleTags = WebDriver.findElements(By.xpath("//style")).size();
        assertEquals(0, sizeOfStyleTags);
        System.out.println(sizeOfStyleTags);
    }
    @Test
    public void testMethodH1Number() {

        int sizeOfH1Tags = WebDriver.findElements(By.xpath("//h1")).size();
        assertEquals(1, sizeOfH1Tags);
        System.out.println(sizeOfH1Tags);
    }
    @Test
    public void testMethodID() {

        List<WebElement> ID = WebDriver.findElements(By.xpath("//div[@id]"));
        HashSet<WebElement> UniqueID=new HashSet<WebElement>(ID);
        assertEquals(ID.size(),UniqueID.size());
    }

    @AfterClass
    public static void afterMethod(){
        WebDriver.quit();
    }
}
