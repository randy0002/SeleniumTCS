package sauceDemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

public class AutomatizationSauceDemo {
    private WebDriver driver;
    private Properties properties;

    @Before
    public void setUp() throws IOException {
        // Configura el driver de Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\randy\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");

        // Carga las propiedades desde el archivo
        properties = new Properties();
        FileInputStream in = new FileInputStream("C:\\Users\\randy\\Downloads\\demo\\SeleniumTCS\\selenium\\src\\test\\resourses\\config.properties");
        properties.load(in);
        in.close();
    }

    @Test
    public void testLogin() {
        try {
            // Lee el usuario y la contraseña desde las propiedades
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            // Encuentra los elementos de usuario y contraseña e ingresa los valores
            Thread.sleep(900);
            WebElement usernameField = driver.findElement(By.id("user-name"));
            Thread.sleep(900);
            WebElement passwordField = driver.findElement(By.id("password"));
            Thread.sleep(900);
            WebElement loginButton = driver.findElement(By.id("login-button"));
            Thread.sleep(900);

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);
            loginButton.click();

            // Verifica que el inicio de sesión fue exitoso
            WebElement productsTitle = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
            productsTitle.click();
            //WebElement allProducts = driver.findElement((By.id("inventory_sidebar_link")));
            assertEquals("Sauce Labs Backpack", productsTitle.getText());
            productsTitle.click();
        } catch (Exception e) {
            // Si ocurre una excepción, falla la prueba
        	System.out.println("Error de capa 8");
            fail("Se produjo una excepción: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        // Cierra el navegador
        if (driver != null) {
            driver.quit();
        }
    }
}
