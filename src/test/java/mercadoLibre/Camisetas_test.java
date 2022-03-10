package mercadoLibre;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Camisetas_test {
	private WebDriver driver;
	Camisetas buscarCamisetas;
	
  
	@BeforeMethod
     public void beforeClass() {
	 buscarCamisetas = new Camisetas(driver);
	 //driver = buscarCamisetas.FirefoxDriverConnection();
	 driver = buscarCamisetas.ChromeDriverConnection();
	 driver.manage().window().maximize();
	 buscarCamisetas.getURL("https://listado.mercadolibre.com.uy/");
	 
  }
  
  @Test
  public void f() throws IOException, InterruptedException {
	  buscarCamisetas.camisetas();
  }

  @AfterMethod
  public void afterClass() {
	 driver.close();
  }

}
