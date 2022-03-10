package mercadoLibre;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Camisetas extends Base {

	
	List<Item> itemLista = new ArrayList<Item>();
	
	
	
	By aceptarCookies = By.cssSelector("button.cookie-consent-banner-opt-out__action--key-accept");
	By campoBusqueda=By.id("cb1-edit");
	By botonBuscar = By.cssSelector("form>button.nav-search-btn");
	By botonPaginado = By.xpath("//span[text()=\"Siguiente\"]");
	By lo = By.cssSelector("ol.ui-search-layout.ui-search-layout--stack");
	By li = By.xpath("//li[@class='ui-search-layout__item']");
	By tituloProducto = By.cssSelector("h2.ui-search-item__title");
	By precioProducto = By.cssSelector("span.price-tag-text-sr-only");
	By linkProducto = By.cssSelector("a.ui-search-item__group__element.ui-search-link");

	public Camisetas(WebDriver driver) {
		super(driver);
		
	}
	
	public void camisetas() throws InterruptedException  {
		
		click(aceptarCookies);
		type("camisetas", campoBusqueda);
		click(botonBuscar);
		List<Item> listaItem = buscar();
		if (listaItem.size()!= 0) {
			crearArchivoItem(listaItem);
		}else {
			crearArchivoItem("No se encontraron camisetas");
		}
		
	}
	
	
	public List<Item> buscar() throws InterruptedException {	
		
		List<WebElement> elementosLista = new ArrayList<WebElement>();
		for (int i = 0; i <=2 ; i++) {
			esperaSleep(2000);
			 if (isDisplayed(lo)) {
				 elementosLista = WebElements(li);
				 for (int j = 0; j < elementosLista.size(); j++) {
					Item item = new Item(elementosLista.get(j).findElement(tituloProducto).getText(), elementosLista.get(j).findElement(precioProducto).getText(), elementosLista.get(j).findElement(linkProducto).getAttribute("href"));
					itemLista.add(item);
			}
			
			}else return itemLista;
			scrollDown();
			click(botonPaginado);
		}
		return itemLista;
		
	}
	
	
	public static void crearArchivoItem(List<Item> elementosLista) {
		FileWriter flwriter = null;
		try {
		
			flwriter = new FileWriter("src/test/resources/camisetas/estudiantes.txt");
			
			
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i<elementosLista.size(); i++) {
				bfwriter.write(elementosLista.get(i).nombre +" ---> "+ elementosLista.get(i).precio+ " ---> "+ elementosLista.get(i).link+ "\n");
			}
				
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void crearArchivoItem(String texto) {
		FileWriter flwriter = null;
		try {
		
			flwriter = new FileWriter("src/test/resources/camisetas/estudiantes.txt");
			
			
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			bfwriter.write(texto);
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	

}
