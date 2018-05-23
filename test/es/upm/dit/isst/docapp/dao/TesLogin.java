package es.upm.dit.isst.docapp.dao;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class TesLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
   // driver = new FirefoxDriver();
	  driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTesLogin() throws Exception {
    driver.get("http://localhost:8080/DocApp/inicio.jsp#team");
    driver.findElement(By.linkText("Inicio de Sesion")).click();
    driver.findElement(By.id("nombreUsuario")).click();
    driver.findElement(By.id("nombreUsuario")).clear();
    driver.findElement(By.id("nombreUsuario")).sendKeys("root");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("root");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='registros']/div/a/h5")).click();
    driver.findElement(By.id("nombrePaciente")).click();
    driver.findElement(By.id("nombrePaciente")).click();
    driver.findElement(By.id("nombrePaciente")).clear();
    driver.findElement(By.id("nombrePaciente")).sendKeys("Dania");
    driver.findElement(By.xpath("//form[@action='FormRegistroPacienteServlet']")).click();
    driver.findElement(By.id("emailPaciente")).click();
    driver.findElement(By.id("emailPaciente")).click();
    driver.findElement(By.id("emailPaciente")).click();
    driver.findElement(By.id("emailPaciente")).click();
    driver.findElement(By.id("emailPaciente")).clear();
    driver.findElement(By.id("emailPaciente")).sendKeys("daniasoto9601@gmail.com");
    driver.findElement(By.id("contraseñaPaciente")).click();
    driver.findElement(By.id("contraseñaPaciente")).clear();
    driver.findElement(By.id("contraseñaPaciente")).sendKeys("dania");
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Inicio de Sesion')])[2]")).click();
    driver.findElement(By.id("nombreUsuario")).click();
    driver.findElement(By.id("nombreUsuario")).clear();
    driver.findElement(By.id("nombreUsuario")).sendKeys("maria@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("maria");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Pedir Cita")).click();
    driver.findElement(By.id("dLabel")).click();
    driver.findElement(By.linkText("radiología")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[2]")).click();
    driver.findElement(By.linkText("Amelia García")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Reservar')])[5]")).click();
    driver.findElement(By.id("exampleFormControlTextarea1")).click();
    driver.findElement(By.id("exampleFormControlTextarea1")).clear();
    driver.findElement(By.id("exampleFormControlTextarea1")).sendKeys("me duele");
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    driver.findElement(By.linkText("Mis Citas")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Cancelar')])[3]")).click();
    driver.findElement(By.linkText("Modificar cita")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[3]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Laura Hernandez')])[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Reservar')])[5]")).click();
    driver.findElement(By.xpath("(//textarea[@id='exampleFormControlTextarea1'])[2]")).click();
    driver.findElement(By.xpath("(//textarea[@id='exampleFormControlTextarea1'])[2]")).clear();
    driver.findElement(By.xpath("(//textarea[@id='exampleFormControlTextarea1'])[2]")).sendKeys("me duele");
    driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Inicio de Sesion')])[2]")).click();
    driver.findElement(By.id("nombreUsuario")).click();
    driver.findElement(By.id("nombreUsuario")).clear();
    driver.findElement(By.id("nombreUsuario")).sendKeys("laura@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("laura");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Mi horario")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Asignar')])[5]")).click();
    driver.findElement(By.id("exampleFormControlSelect1")).click();
    driver.findElement(By.xpath("(//textarea[@id='exampleFormControlTextarea1'])[2]")).click();
    driver.findElement(By.xpath("(//textarea[@id='exampleFormControlTextarea1'])[2]")).clear();
    driver.findElement(By.xpath("(//textarea[@id='exampleFormControlTextarea1'])[2]")).sendKeys("necesitas consulta");
    driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
    driver.findElement(By.linkText("Programar nueva cita")).click();
    driver.findElement(By.id("dLabel")).click();
    driver.findElement(By.linkText("Dania")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[2]")).click();
    driver.findElement(By.linkText("radiología")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[3]")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[3]")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[3]")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[2]")).click();
    driver.findElement(By.linkText("radiología")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[3]")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[3]")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[3]")).click();
    driver.findElement(By.xpath("(//button[@id='dLabel'])[3]")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
