import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class codeTestingAruodas {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        options.addArguments("--headless");
        driver.get("https://m.aruodas.lt/");
        sleep();
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        sleep();
        driver.get("https://m.aruodas.lt/ideti-skelbima/?obj=1");
    }

    public void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setValue(String id, String searchId, String value) {
        driver.findElement(By.id(id)).click();
        sleep();
        driver.findElement(By.id(searchId)).sendKeys(value);
        sleep();
        var elements = driver.findElements(By.tagName("li"));
        for (int i =0; i < elements.stream().count(); i++) {
            if(elements.get(i).isDisplayed()){
                elements.get(i).click();
                sleep();
                break;
            }
        }
    }

    @Test
    public void search() {
        var savivaldybe = "Šiauliai";
        var gyvenviete = "Žaliūkių k.";
        var mikrorajonas = "";
        var gatve = "Danės g.";

//        var savivaldybe = "Kretingos r.";
//        var gyvenviete = "Alko k.";
//        var mikrorajonas = "";
//        var gatve = "";

//        var savivaldybe = "Palanga";
//        var gyvenviete = "Palangos m.";
//        var mikrorajonas = "Šventoji";
//        var gatve = "Apynių g.";

        setValue("regionTitle", "regionSearchInput", savivaldybe);
        setValue("districtTitle", "districtSearchInput", gyvenviete);
        if(mikrorajonas != "")
            setValue("quartalTitle", "quartalSearchInput", mikrorajonas);
        if(gatve != "")
            setValue("streetTitle", "streetSearchInput", gatve);
    }


//    Aruodas.lt       a) paieška, kuri veiktų su dinaminiu turiniu;
//    b)paieška išdalinta funkcijomis, kad būtų galima kode įrašyti ko ieškosime
//    Aruodas.lt
//    siauliai
//    zaliukiu k
//    danes g
//
//    kretingos r.
//    alko k.
//
//    palanga
//    palangos m,
//    sventoji
//    apyniu g.
}
