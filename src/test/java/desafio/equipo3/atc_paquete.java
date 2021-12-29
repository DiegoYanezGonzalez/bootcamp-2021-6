package desafio.equipo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class atc_paquete {

    private WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @Test
    public void atc04_PaqueteUnAdultoVueloMasAuto() {

        String ciudadOrigen = "Santiago de Chile";
        String ciudadDestino = "Buenos Aires";
        String diaIda = "11";
        String diaVuelta = "18";

        WebDriverWait delay = new WebDriverWait(driver,8);

        By calendar = By.xpath("//*[@class='datepicker-packages sbox-v4-components']");
        By dropdownCities = By.xpath("//i[@class='suggester-icon-xsm suggester-icon-city']");
        By inputOrigen = By.xpath("//label[normalize-space()='Origen']/following-sibling::input");
        By inputDestino = By.xpath("//label[normalize-space()='Destino']/following-sibling::input");
        By inputFechaIda = By.xpath("//input[@placeholder='Ida']");
        By inputFechaVuelta = By.xpath("//input[@placeholder='Vuelta']");
        By spanDiaIda = By.xpath("//*[@class='datepicker-packages sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available']//span[.='" + diaIda + "']");
        By spanDiaVuelta = By.xpath("//span[@class='_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip']//span[.='" + diaVuelta + "']");
        By buttonBuscar = By.xpath("//em[.='Buscar']");


        // Opción de Vuelo más Auto (V.A.)
        driver.findElement(By.xpath("//input[@value='va']")).click();

        // Ciudad de origen
        driver.findElement(inputOrigen).sendKeys(ciudadOrigen);
        delay.until(ExpectedConditions.visibilityOfElementLocated(dropdownCities));
        driver.findElement(inputOrigen).sendKeys(Keys.RETURN);

        // Ciudad de destino
        driver.findElement(inputDestino).sendKeys(ciudadDestino);
        delay.until(ExpectedConditions.visibilityOfElementLocated(dropdownCities));
        driver.findElement(inputDestino).sendKeys(Keys.RETURN);

        // Fecha de ida
        driver.findElement(inputFechaIda).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(calendar));
        driver.findElement(spanDiaIda).click();

        // Fecha de vuelta
        driver.findElement(inputFechaVuelta).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(calendar));
        driver.findElement(spanDiaVuelta).click();

        // Buscar
        driver.findElement(buttonBuscar).click();
    }

    @Test
    public void atc05_PaqueteFamiliaVueloMasAlojamiento() {

    }

    @Test
    public void atc06_PaqueteFamiliaVueloMasDosAlojamientos() {
    }

    @After
    public void close(){
        if(driver != null){
            System.out.println("Close");
            driver.close();
        }
    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }

}