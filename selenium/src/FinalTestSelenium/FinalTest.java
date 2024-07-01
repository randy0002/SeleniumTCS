package FinalTestSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FinalTest {
	private WebDriver driver;
	private Properties properties;

	@Before
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\randy\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver = new ChromeDriver();
		properties = new Properties();
		properties.load(new FileInputStream(
				"C:\\Users\\randy\\Downloads\\demo\\SeleniumTCS\\selenium\\src\\test\\resourses\\config.properties"));
		driver.get("https://www.saucedemo.com/v1/");
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Ignore
	@Test
	public void testLogin() {
		try {
			// Lee el usuario y la contraseña desde las propiedades
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			// Encuentra los elementos de usuario y contraseña e ingresa los valores
			Thread.sleep(900);
			WebElement usernameField = driver.findElement(By.id("user-name"));
			WebElement passwordField = driver.findElement(By.id("password"));
			WebElement loginButton = driver.findElement(By.id("login-button"));

			usernameField.sendKeys(username);
			Thread.sleep(900);
			passwordField.sendKeys(password);
			Thread.sleep(900);
			loginButton.click();
			Thread.sleep(900);
			// Verifica que el inicio de sesión fue exitoso
			assertTrue(driver.findElement(By.className("inventory_list")).isDisplayed());

		} catch (Exception e) {
			// Si ocurre una excepción, falla la prueba
			System.out.println("Error de capa 8");
			fail("Se produjo una excepción: " + e.getMessage());
		}
	}

	@Ignore
	@Test
	public void testAddAndRemoveProducts() throws InterruptedException {
		Thread.sleep(900);
		testLogin();
		Thread.sleep(1900);
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")).click();
		Thread.sleep(900);
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")).click();
		Thread.sleep(900);
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button")).click();
		Thread.sleep(900);
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]/div[3]/button")).click();
		Thread.sleep(900);
		driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button")).click();
		Thread.sleep(900);
		driver.findElement(By.className("shopping_cart_link")).click();
		Thread.sleep(900);
		assertTrue(driver.findElement(By.id("item_4_title_link")).isDisplayed());
		Thread.sleep(900);
		assertTrue(driver.findElement(By.id("item_0_title_link")).isDisplayed());
		Thread.sleep(900);
		assertTrue(driver.findElement(By.id("item_5_title_link")).isDisplayed());
		Thread.sleep(900);
	}

	@Ignore
	@Test
	public void testCheckout() throws InterruptedException {
		try {
			testAddAndRemoveProducts();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")).click();
		driver.findElement(By.id("first-name")).sendKeys("Randy");
		driver.findElement(By.id("last-name")).sendKeys("chilpa");
		driver.findElement(By.id("postal-code")).sendKeys("55603");
		Thread.sleep(900);
		driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();
		Thread.sleep(900);
		driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")).click();
		Thread.sleep(900);
		WebElement thankYouMessage = driver.findElement(By.className("complete-header"));
		assertEquals("THANK YOU FOR YOUR ORDER", thankYouMessage.getText());
		Thread.sleep(900);
	}

	@Ignore
	@Test
	public void testLogout() throws InterruptedException {
		testCheckout();
		Thread.sleep(1900);
		try {
			WebElement menuButton = driver
					.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button"));
			if (menuButton != null) {
				Thread.sleep(1900);
				menuButton.click();
			} else {
				Thread.sleep(1900);
				driver.findElement(By.id("logout_sidebar_link")).click();
			}
		} catch (Exception e) {
			System.out.println("ERROR de CAPA 8");
		}
		Thread.sleep(1900);
	}

	@Test
	public void testLoginFailure() throws InterruptedException {
		
			// Lee el usuario y la contraseña desde las propiedades
			String username = properties.getProperty("usernameWrong");
			String password = properties.getProperty("passwordWrong");

			// Encuentra los elementos de usuario y contraseña e ingresa los valores
			Thread.sleep(900);
			WebElement usernameField = driver.findElement(By.id("user-name"));
			WebElement passwordField = driver.findElement(By.id("password"));
			WebElement loginButton = driver.findElement(By.id("login-button"));

			usernameField.sendKeys(username);
			Thread.sleep(900);
			passwordField.sendKeys(password);
			Thread.sleep(900);
			loginButton.click();
			Thread.sleep(900);
			// Encuentra el mensaje de error
	        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3"));
	        String actualMessage = errorMessage.getText();

	        // Verifica que el mensaje de error sea el esperado
	        String expectedMessage = "Username is required";
	        assertEquals(expectedMessage, actualMessage);
	}
	

}
