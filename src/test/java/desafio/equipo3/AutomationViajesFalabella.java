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

public class AutomationViajesFalabella {

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
    public void act01_AlojamientoSinFechaPrevista() {

        String lugarDestino = "Rio de janeiro";

        By alojamientos = By.xpath("//label[.='Alojamientos']");
        By casilla = By.xpath("//label[@class='checkbox-label']");
        By inputDestino = By.xpath("//label[.='Destino']/../input");
        By buscador = By.xpath("//em[.='Buscar']");

        //seleccionamos alojamiento
        driver.findElement(alojamientos).click();

        //marca casilla
        driver.findElement(casilla).click();

        //escribe el destino
        WebElement destino = driver.findElement(inputDestino);
        destino.sendKeys(lugarDestino);
        destino.sendKeys(Keys.ENTER);

        //Buscador
        driver.findElement(buscador).click();

        /*
        //Devuelve resultados según disponibilidad.
        String urlEsperada = "https://www.viajesfalabella.cl/accommodations/results/";
        String urlResultados = driver.getCurrentUrl();

        System.out.println(urlResultados);

        Assert.assertTrue(urlResultados.startsWith(urlEsperada));
        */
    }

    @Test
    public void atc02_AlojamientoConFechas() {

        By alojamientos = By.xpath("//label[.='Alojamientos']");
        By buscador = By.xpath("//em[.='Buscar']");
        By fecha = By.xpath("//input[@placeholder='Entrada']");

        //seleccionamos alojamiento
        driver.findElement(alojamientos).click();

        //escribe el destino
        WebElement destino= driver.findElement(By.xpath("//label[.='Destino']/../input"));
        destino.sendKeys("Rio de janeiro");
        destino.sendKeys(Keys.ENTER);

        //fecha
        driver.findElement(fecha).click();
        driver.findElement(By.xpath("//*[@data-month=\"2022-02\"]//span[.='18']")).click();
        driver.findElement(By.xpath("//*[@data-month=\"2022-02\"]//span[.='26']")).click();
        driver.findElement(By.xpath("//em[.='Aplicar']")).click();

        //habitaciones
        driver.findElement(By.xpath("//div[@class='sbox-passengers-container']/../..")).click();

        // Sumar un menor
        driver.findElement(By.xpath("//label[.='Menores']/../../..//a[@class='steppers-icon-right sbox-3-icon-plus']")).click();

        // Edad del menor
        driver.findElement(By.xpath("//select")).click();
        driver.findElement(By.xpath("//select/option[5]")).click();

        driver.findElement(By.xpath("//a[.='Aplicar']")).click();

        //Buscador
        driver.findElement(buscador).click();
    }

    @Test
    public void atc03_AlojamientoParaDosFamilias() {

        By alojamientos = By.xpath("//label[.='Alojamientos']");
        By buscador = By.xpath("//em[.='Buscar']");
        By fecha = By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input");

        //seleccionamos alojamiento
        driver.findElement(alojamientos).click();

        //escribe el destino
        WebElement destino= driver.findElement(By.xpath("//label[.='Destino']/../input"));
        destino.sendKeys("Rio de janeiro");
        destino.sendKeys(Keys.ENTER);

        //fecha
        driver.findElement(fecha).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[4]/span[10]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[4]/span[15]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[2]/button[2]/em")).click();

        //habitaciones
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div")).click();

        //click en menores 5
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();

        //1 menor
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select/option[5]")).click();

        //2menor
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div/div/select/option[9]")).click();

        //3menor
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div/div/select")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[3]/div[2]/div/div/select/option[11]")).click();

        //4menor
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[4]/div[2]/div/div/select")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[4]/div[2]/div/div/select/option[14]")).click();

        //5menor
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[5]/div[2]/div/div/select")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[5]/div[2]/div/div/select/option[16]")).click();

        //otra habitacion
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();

        //sumar 4 menores de edad
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/a[2]")).click();

        //1 menor
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/select")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div/div/select/option[4]")).click();

        //2 menor
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/div/div/select")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/div/div/select/option[12]")).click();

        //3 menor
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[3]/div[2]/div/div/select")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[3]/div[2]/div/div/select/option[17]")).click();

        //4menor
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[4]/div[2]/div/div/select")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[4]/div[2]/div/div/select/option[19]")).click();

        //aplicar
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]")).click();

        //Buscador
        driver.findElement(buscador).click();
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

        // Obervar si hay resultados.
        System.out.println(driver.findElements(By.className("empty-state-message-content")).size());
        System.out.println(driver.findElements(By.id("clusters")).size());
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
        Select ageKids = new Select(driver.findElement(By.xpath(popupHabitaciones + "//*[@class='select-tag']")));
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
        ageKids.selectByValue(edadMenores[0]);

        // Segundo menor de edad.
        driver.findElement(lessIcon).click();
        ageKids = new Select(driver.findElement(
                By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[2]//select")));
        ageKids.selectByValue(edadMenores[1]);

        // Buscar
        driver.findElement(buttonBuscar).click();
    }

    @Test
    public void act07_TrasladosFamiliaDesdeAeropuerto(){

        WebDriverWait espera= new WebDriverWait(driver, 8000);
        String aeropuerto = "Aeropuerto Desierto de Atacama, Copiapo, Chile";
        String hotel = "Hampton by Hilton Antofagasta - Avenida Edmundo Pérez Zujovic, Antofagasta, Chile";
        String diaArribo = "25";
        String horaArribo = "12:00";

        By traslados = By.xpath("//label[.='Traslados']");
        By calendario = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']");
        By desdeElAeropuerto = By.xpath("//*[@class='radio-circle sbox-radio-circle']");
        By inputAeropuerto = By.xpath("//*[@class='sbox-place-container -mb4-s']//input[@placeholder='Ingresa un aeropuerto']");
        By inputHotel = By.xpath("//*[@class='sbox-second-place-container']//span[@class='input-gradient']/..//input");
        By inputFecha = By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Arribo']");
        By spanDia = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']//span[@class='_dpmg2--date _dpmg2--available']//span[.='" + diaArribo + "']");
        By buscar = By.xpath("//em[@class='btn-text']");
        By recomendaciones_aeropuerto = By.xpath("//ul[@class='ac-group-items']");
        By recomendaciones_hotel = By.xpath("//*[@class='ac-wrapper -desktop -facet -show']//ul");

        //1) Seleccionar traslados.
        driver.findElement(traslados).click();

        //2) Selección "desde el aeropuerto".
        driver.findElement(desdeElAeropuerto).click();

        //3) Ingresar un aeropuerto
        driver.findElement(inputAeropuerto).sendKeys(aeropuerto);
        espera.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_aeropuerto));
        driver.findElement(inputAeropuerto).sendKeys(Keys.RETURN);

        //4) Ingresar un hotel
        driver.findElement(inputHotel).sendKeys(hotel);
        espera.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_hotel));
        driver.findElement(inputHotel).sendKeys(Keys.RETURN);

        //5) Seleccionamos día y hora
        driver.findElement(inputFecha).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(calendario));
        driver.findElement(spanDia).click();
        Select select = new Select(driver.findElement(By.xpath("//span[.='hora']/..//select")));
        select.selectByVisibleText(horaArribo); //hora

        //6) Click en buscar
        driver.findElement(buscar).click();
    }

    @Test
    public void atc08_TrasladosFamiliaHaciaAeropuerto () {

        WebDriverWait espera= new WebDriverWait(driver, 8000);

        String aeropuerto = "Aeropuerto Desierto de Atacama, Copiapo, Chile";
        String hotel = "Hampton by Hilton Antofagasta - Avenida Edmundo Pérez Zujovic, Antofagasta, Chile";
        String diaArribo = "25";
        String horaArribo = "12:00";
        String edad_menor1 = "10 años";
        String edad_menor2 = "10 años";

        By traslados = By.xpath("//label[.='Traslados']"); //boton
        By calendario = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']");
        By haciaElAeropuerto = By.xpath("//*[@class='sbox-radio-buttons']/span[2]");
        By inputAeropuerto = By.xpath("//*[@class='sbox-place-container -mb4-s']//input[@placeholder='Ingresa un aeropuerto']");
        By recomendaciones_aeropuerto = By.xpath("//ul[@class='ac-group-items']");
        By recomendaciones_hotel = By.xpath("//*[@class='ac-wrapper -desktop -facet -show']//ul");
        By pasajeros = By.xpath("//label[.='Pasajeros']/../*[@class='sbox-row sbox-distribution-picker-wrapper-ui']");
        By inputHotel = By.xpath("//*[@class='sbox-second-place-container']//span[@class='input-gradient']/..//input");
        By inputFecha = By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Partida']");
        By spanDia = By.xpath("//*[@data-month='2022-01']//span[.='" + diaArribo + "']");
        By buscar = By.xpath("//em[@class='btn-text']");
        By sumar_menores = By.xpath("//label[.='Menores']/../../..//a[@class='steppers-icon-right sbox-3-icon-plus']");
        By aplicar_pasajeros = By.xpath("//*[@class='_pnlpk-panel__footer -medium-down-to-lg']//a");
        By opciones_pasajeros = By.xpath("//*[@class='_pnlpk-panel-scroll']");

        //1) Seleccionar traslados.
        driver.findElement(traslados).click();

        //2) Selección "hacia el aeropuerto".
        driver.findElement(haciaElAeropuerto).click();

        //3) Ingresar un hotel
        driver.findElement(inputHotel).sendKeys(hotel);
        espera.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_hotel));
        driver.findElement(inputHotel).sendKeys(Keys.RETURN);

        //4) Ingresar un aeropuerto
        driver.findElement(inputAeropuerto).sendKeys(aeropuerto);
        espera.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_aeropuerto));
        driver.findElement(inputAeropuerto).sendKeys(Keys.RETURN);

        //5) Seleccionamos día y hora
        driver.findElement(inputFecha).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(calendario));
        driver.findElement(spanDia).click();
        Select select = new Select(driver.findElement(By.xpath("//*[@class='select-tag sbox-time-departure']")));
        select.selectByVisibleText(horaArribo); //hora

        //6) Seleccionamos 2 adultos y 2 menores
        driver.findElement(pasajeros).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(opciones_pasajeros));
        driver.findElement(sumar_menores).click();
        driver.findElement(sumar_menores).click();
        driver.findElement(aplicar_pasajeros).click();

        //7) Seleccionarmos una edad para ambos menores
        Select select_edad_menor1 = new Select(driver.findElement(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[1]//select")));
        Select select_edad_menor2 = new Select(driver.findElement(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[2]//select")));
        select_edad_menor1.selectByVisibleText(edad_menor1);
        select_edad_menor2.selectByVisibleText(edad_menor2);

        //8) Click en aplicar
        driver.findElement(aplicar_pasajeros).click();

        //9) Click en buscar
        driver.findElement(buscar).click();
    }


    @Test
    public void atc09_TrasladosDesdeAeropuertoConRegreso(){
        WebDriverWait espera= new WebDriverWait(driver, 8000);

        String aeropuerto = "Aeropuerto Desierto de Atacama, Copiapo, Chile";
        String hotel = "Hampton by Hilton Antofagasta - Avenida Edmundo Pérez Zujovic, Antofagasta, Chile";
        String horaArribo = "12:00";
        String edad_menor1 = "10 años";
        String edad_menor2 = "9 años";
        String edad_menor3 = "12 años";
        String edad_menor4 = "9 años";
        String fecha_regreso = "28";
        String hora_regreso = "16:00";

        By traslados = By.xpath("//label[.='Traslados']"); //boton
        By calendario = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']");
        By desdeElAeropuerto = By.xpath("//*[@class='radio-circle sbox-radio-circle']");
        By inputAeropuerto = By.xpath("//*[@class='sbox-place-container -mb4-s']//input[@placeholder='Ingresa un aeropuerto']");
        By recomendaciones_aeropuerto = By.xpath("//ul[@class='ac-group-items']");
        By recomendaciones_hotel = By.xpath("//*[@class='ac-wrapper -desktop -facet -show']//ul");
        By pasajeros = By.xpath("//label[.='Pasajeros']/../*[@class='sbox-row sbox-distribution-picker-wrapper-ui']");
        By inputHotel = By.xpath("//*[@class='sbox-second-place-container']//span[@class='input-gradient']/..//input");
        By inputFecha = By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Arribo']");
        By spanDia = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']//*[@data-month='2022-01']//span[.='25']");
        By buscar = By.xpath("//em[@class='btn-text']");
        By sumar_menores = By.xpath("//label[.='Menores']/../../..//a[@class='steppers-icon-right sbox-3-icon-plus']");
        By aplicar_pasajeros = By.xpath("//*[@class='_pnlpk-panel__footer -medium-down-to-lg']//a");
        By opciones_pasajeros = By.xpath("//*[@class='_pnlpk-panel-scroll']");
        By quiero_agregar_regreso = By.xpath("//label[.='Quiero agregar el regreso']");
        By input_regreso = By.xpath("//*[@class='sbox-row']//input[@class='input-tag sbox-checkout']");
        By spanDia_regreso = By.xpath("//*[@class='datepicker-transfers sbox-v4-components']//span[.='" + fecha_regreso + "']");

        //1) Seleccionar traslados.
        driver.findElement(traslados).click();

        //2) Selección "desde el aeropuerto".
        driver.findElement(desdeElAeropuerto).click();

        //3) Ingresar un aeropuerto
        driver.findElement(inputAeropuerto).sendKeys(aeropuerto);
        espera.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_aeropuerto));
        driver.findElement(inputAeropuerto).sendKeys(Keys.RETURN);

        //4) Ingresar un hotel
        driver.findElement(inputHotel).sendKeys(hotel);
        espera.until(ExpectedConditions.visibilityOfElementLocated(recomendaciones_hotel));
        driver.findElement(inputHotel).sendKeys(Keys.RETURN);

        //5) Seleccionamos día
        driver.findElement(inputFecha).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(calendario));
        driver.findElement(spanDia).click();

        //6) Seleccionamos una hora
        Select select = new Select(driver.findElement(By.xpath("//span[.='hora']/..//*[@class='select-tag sbox-time-arrival']")));
        select.selectByVisibleText(horaArribo); //hora

        //7) Seleccionamos 2 adultos y 4 menores
        driver.findElement(pasajeros).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(opciones_pasajeros));
        for(int i=0; i<4; i++) driver.findElement(sumar_menores).click();

        //8) Seleccionarmos una edad para el menor 1
        Select select_edad_menor1 = new Select(driver.findElement(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[1]//select")));
        select_edad_menor1.selectByVisibleText(edad_menor1);

        //9) Seleccionamos una edad para el menor 2
        Select select_edad_menor2 = new Select(driver.findElement(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[2]//select")));
        select_edad_menor2.selectByVisibleText(edad_menor2);

        //10) Seleccionamos una edad para el menor 3
        Select select_edad_menor3 = new Select(driver.findElement(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[3]//select")));
        select_edad_menor3.selectByVisibleText(edad_menor3);

        //11) Seleccionamos una edad para el menor 4
        Select select_edad_menor4 = new Select(driver.findElement(By.xpath("//*[@class='_pnlpk-minors-age-select-wrapper']/div[4]//select")));
        select_edad_menor4.selectByVisibleText(edad_menor4);

        //12) Damos click en aplicar
        driver.findElement(aplicar_pasajeros).click();

        //13) Damos click en "Quiero agregar un regreso
        driver.findElement(quiero_agregar_regreso).click();

        //14) Seleccionamos un día
        driver.findElement(input_regreso).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(calendario));
        driver.findElement(spanDia_regreso).click();

        //15) Seleccionamos una hora
        Select select_hora = new Select(driver.findElement(By.xpath("//*[@class='select-tag sbox-time-departure']")));
        select_hora.selectByVisibleText(hora_regreso); //hora

        //16) Click en "Buscar"
        driver.findElement(buscar).click();

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