package seleniumExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TestFormy {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// Configura la ubicación del driver de Chrome
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\randy\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

		// Crea una nueva instancia del navegador Chrome
		WebDriver driver = new ChromeDriver();

		// Maximiza la ventana del navegador
		driver.manage().window().maximize();

		driver.get("https://formy-project.herokuapp.com/");
		Thread.sleep(2000);
		// Ir a la página de Formy Autocomplete
		WebElement autocompleteLink = driver.findElement(By.xpath("/html/body/div/div/li[1]/a"));
		autocompleteLink.click();
		Thread.sleep(2000);

		// Encuentra el elemento del campo de autocompletado y escribe en él

		WebElement autocomplete = driver.findElement(By.id("autocomplete"));
		autocomplete.sendKeys("Evergreen Terrace");
		Thread.sleep(500);

		WebElement autocompleteResult = driver.findElement(By.xpath("html/body/div[2]/div/table/tr/td[2]/button"));
		autocompleteResult.click();

		WebElement street_number = driver.findElement(By.id("street_number"));
		street_number.sendKeys("742");
		Thread.sleep(500);

		WebElement locality = driver.findElement(By.id("locality"));
		locality.sendKeys("Springfield");
		Thread.sleep(500);

		WebElement administrative_area_level_1 = driver.findElement(By.id("administrative_area_level_1"));
		administrative_area_level_1.sendKeys("EE.UU");
		Thread.sleep(500);

		WebElement postal_code = driver.findElement(By.id("postal_code"));
		postal_code.sendKeys("0001");
		Thread.sleep(500);

		WebElement country = driver.findElement(By.id("country"));
		country.sendKeys("EE.UU");
		Thread.sleep(500);

		// driver.get("https://formy-project.herokuapp.com/form");
		WebElement logo = driver.findElement(By.id("logo"));
		logo.click();
		Thread.sleep(500);
		WebElement form = driver.findElement(By.xpath("/html/body/div/div/li[14]/a"));
		form.click();
		Thread.sleep(500);

		driver.findElement(By.id("first-name")).sendKeys("Randy");
		Thread.sleep(500);
		driver.findElement(By.id("last-name")).sendKeys("Chilpa");
		Thread.sleep(500);
		driver.findElement(By.id("job-title")).sendKeys("Software Engineer");
		Thread.sleep(500);
		driver.findElement(By.id("radio-button-3")).click();
		Thread.sleep(500);
		driver.findElement(By.id("checkbox-1")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("option[value='2']")).click();
		Thread.sleep(500);
		driver.findElement(By.id("datepicker")).sendKeys("12/02/1995");
		Thread.sleep(500);
		driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
		Thread.sleep(500);
		driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
		Thread.sleep(500);

		 driver.quit();
	}
}
