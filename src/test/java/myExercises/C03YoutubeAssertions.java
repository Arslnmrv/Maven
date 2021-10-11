package myExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03YoutubeAssertions {

    //1) Bir class oluşturun: YoutubeAssertions

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com");
        //2) https://www.youtube.com adresine gidin

    }

    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    @Test
    public void titleTest() {

        String actualTitle = driver.getTitle();
        Assert.assertEquals("title uyumlu degil", "YouTube", actualTitle);

        //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    }

    @Test
    public void imageTest() {
        // WebElement logo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("image goruntulenmedi", driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());

        //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    }

    @Test
    public void searchBoxTest() {
        Assert.assertTrue("searcbox erisilebilir degil!", driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
        //   ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    }

    @Test
    public void wrongTitleTest() {
        String actualTitle = driver.getTitle();
        String olmayasiBaslik = "youtube";
        Assert.assertFalse("basliklar uyustu", actualTitle.equals(olmayasiBaslik));
        //  ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
