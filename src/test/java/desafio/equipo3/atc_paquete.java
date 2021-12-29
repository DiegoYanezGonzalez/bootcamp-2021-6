package desafio.equipo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        String ciudadOrigen = "La Rioja";
        String ciudadDestino = "Ushuaia";
        String ciudadAlojamiento = "Porvenir";
        String diaIda = "12";
        String diaVuelta = "18";
        String edadMenor = "8";

        WebDriverWait delay = new WebDriverWait(driver,8);

        // Locators
        By calendar = By.xpath("//*[@class='datepicker-packages sbox-v4-components']");
        By dropdownCities = By.xpath("//i[@class='suggester-icon-xsm suggester-icon-city']");
        By inputOrigen = By.xpath("//label[normalize-space()='Origen']/following-sibling::input");
        By inputDestino = By.xpath("//label[normalize-space()='Destino']/following-sibling::input");
        By inputFechaIda = By.xpath("//input[@placeholder='Ida']");
        By inputFechaVuelta = By.xpath("//input[@placeholder='Vuelta']");
        By spanDiaIda = By.xpath("//*[@class='datepicker-packages sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available']//span[.='" + diaIda + "']");
        By spanDiaVuelta = By.xpath("//span[@class='_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip']//span[.='" + diaVuelta + "']");
        By divHabitaciones = By.xpath("//*[@class='sbox-passengers-container']/../..");
        String popupHabitaciones = "//*[@class='distpicker distpicker-rooms-packages sbox-v4-components']";
        By lessIcon = By.xpath(popupHabitaciones + "//label[.='Menores']/../../..//a[@class='steppers-icon-right sbox-3-icon-plus']");
        Select ageBrocaCochi = new Select(driver.findElement(By.xpath(popupHabitaciones + "//*[@class='select-tag']")));
        By inputOpcinesAvanzadas = By.xpath("//input[@class='sbox-advanced-options']");
        By checkboxAlojamientoOtraCiudad = By.xpath("//label[@data-for='sbox-hotel-another-city-check']");
        By inputCiudadAlojamiento = By.xpath("//div[@class='sbox-advanced-options-col']//input[@type='text']");
        By buttonBuscar = By.xpath("//em[.='Buscar']");

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

        // Sumar un menor de edad al viaje.
        driver.findElement(divHabitaciones).click();
        driver.findElement(lessIcon).click();
        ageBrocaCochi.selectByValue(edadMenor);

        // Ir a opciones avanzadas.
        driver.findElement(inputOpcinesAvanzadas).click();
        driver.findElement(checkboxAlojamientoOtraCiudad).click();

        // Añadir lugar de alojamiento.
        driver.findElement(inputCiudadAlojamiento).sendKeys(ciudadAlojamiento);
        delay.until(ExpectedConditions.visibilityOfElementLocated(dropdownCities));
        driver.findElement(inputCiudadAlojamiento).sendKeys(Keys.RETURN);

        // Buscar
        driver.findElement(buttonBuscar).click();
    }

    @Test
    public void atc06_PaqueteFamiliaVueloMasDosAlojamientos() {

        String ciudadOrigen = "coquimbo";
        String ciudadDestino = "punta arenas";
        String ciudadDestinoDos = "ushuaia";
        String diaIda = "14";
        String diaVuelta = "20";
        String diaHastaDestinoUno = "17";
        String[] edadMenores = {"5","10"};

        WebDriverWait delay = new WebDriverWait(driver,8);

        // Locators
        By calendar = By.xpath("//*[@class='datepicker-packages sbox-v4-components']");
        By dropdownCities = By.xpath("//i[@class='suggester-icon-xsm suggester-icon-city']");
        By inputOrigen = By.xpath("//label[normalize-space()='Origen']/following-sibling::input");
        By inputDestino = By.xpath("//label[normalize-space()='Destino']/following-sibling::input");
        By inputFechaIda = By.xpath("//input[@placeholder='Ida']");
        By inputFechaVuelta = By.xpath("//input[@placeholder='Vuelta']");
        By spanDiaIda = By.xpath("//*[@class='datepicker-packages sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available']//span[.='" + diaIda + "']");
        By spanDiaVuelta = By.xpath("//span[@class='_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip']//span[.='" + diaVuelta + "']");
        By inputDestinoDos = By.xpath("//label[.='Segundo destino']/../input");
        By inputFechaHastaDestinoUno = By.xpath("//input[@placeholder='Hasta']");
        By spanDiaHastaDestinoUno = By.xpath("//span[@class='_dpmg2--date _dpmg2--available _dpmg2--nights-tooltip']//span[.='" + diaHastaDestinoUno + "']");
        By divHabitaciones = By.xpath("//*[@class='sbox-passengers-container']/../..");
        String popupHabitaciones = "//*[@class='distpicker distpicker-rooms-packages sbox-v4-components']";
        By lessIcon = By.xpath(popupHabitaciones + "//label[.='Menores']/../../..//a[@class='steppers-icon-right sbox-3-icon-plus']");
        Select ageBrocaCochi = new Select(driver.findElement(By.xpath(popupHabitaciones + "//*[@class='select-tag']")));
        By buttonBuscar = By.xpath("//em[.='Buscar']");

        // Opción de Vuelo más 2 Alojamientos (V.H.H.)
        driver.findElement(By.xpath("//input[@value='vhh']")).click();

        // Ciudad de origen
        driver.findElement(inputOrigen).sendKeys(ciudadOrigen);
        delay.until(ExpectedConditions.visibilityOfElementLocated(dropdownCities));
        driver.findElement(inputOrigen).sendKeys(Keys.RETURN);

        // Ciudad de destino
        driver.findElement(inputDestino).sendKeys(ciudadDestino);
        delay.until(ExpectedConditions.visibilityOfElementLocated(dropdownCities));
        driver.findElement(inputDestino).sendKeys(Keys.RETURN);

        // Fecha de ida del viaje
        driver.findElement(inputFechaIda).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(calendar));
        driver.findElement(spanDiaIda).click();

        // Fecha de vuelta del viaje
        driver.findElement(inputFechaVuelta).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(calendar));
        driver.findElement(spanDiaVuelta).click();

        // Ciudad de segundo destino
        driver.findElement(inputDestinoDos).sendKeys(ciudadDestinoDos);
        delay.until(ExpectedConditions.visibilityOfElementLocated(dropdownCities));
        driver.findElement(inputDestinoDos).sendKeys(Keys.RETURN);

        // Fecha de vuelta del primer destino
        driver.findElement(inputFechaHastaDestinoUno).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(calendar));
        driver.findElement(spanDiaHastaDestinoUno).click();

        // Sumar dos personas menores de edad al viaje.
        // Click en la habitación
        driver.findElement(divHabitaciones).click();

        // Primer menor de edad.
        driver.findElement(lessIcon).click();
        Thread.sleep(5000);
        ageBrocaCochi.selectByValue(edadMenores[0]);

        // Segundo menor de edad.
        driver.findElement(lessIcon).click();
        ageBrocaCochi = new Select(driver.findElement(
                        By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[2]//select")));
        ageBrocaCochi.selectByValue(edadMenores[1]);

        // Buscar
        driver.findElement(buttonBuscar).click();
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