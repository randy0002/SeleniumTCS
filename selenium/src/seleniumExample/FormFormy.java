package seleniumExample;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormFormy {
    public static void main(String[] args) {
        // Configura la ubicación del driver de Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\randy\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        // Crea una nueva instancia del navegador Chrome
        WebDriver driver = new ChromeDriver();

        // Ir a la página de Formy
        driver.get("https://formy-project.herokuapp.com/");

        // Navegar a la sección "Autocomplete"
        WebElement autocompleteLink = driver.findElement(By.linkText("Autocomplete"));
        autocompleteLink.click();

        // En la sección "Autocomplete", encuentra el campo de autocompletado y escribe en él
        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
		autocomplete.sendKeys("Evergreen Terrace");

		WebElement street_number = driver.findElement(By.id("street_number"));
		street_number.sendKeys("742");

		WebElement locality = driver.findElement(By.id("locality"));
		locality.sendKeys("Springfield");

		WebElement administrative_area_level_1 = driver.findElement(By.id("administrative_area_level_1"));
		administrative_area_level_1.sendKeys("EE.UU");

		WebElement postal_code = driver.findElement(By.id("postal_code"));
		postal_code.sendKeys("0001");

		WebElement country = driver.findElement(By.id("country"));
		country.sendKeys("EE.UU");

        // Espera hasta que la opción de autocompletado sea visible y haz clic en ella
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10); WebElement
		 * autocompleteResult =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
		 * "pac-item"))); autocompleteResult.click();
		 */

        // Volver a la página principal
        driver.get("https://formy-project.herokuapp.com/");

        // Navegar a la sección "Complete Web Form"
        WebElement completeWebFormLink = driver.findElement(By.linkText("Complete Web Form"));
        completeWebFormLink.click();

        // En la sección "Complete Web Form", encuentra los campos y rellénalos
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("job-title")).sendKeys("Software Engineer");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.cssSelector("option[value='2']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("05/28/2021");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();

        // Cierra el navegador después de un tiempo
        driver.quit();
    }
}
