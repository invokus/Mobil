package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDemoAppScreen extends PageObject {

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']//android.view.ViewGroup")
    private List<WebElement> lista;

    public void Productos(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']//android.view.ViewGroup")));
        System.out.println("Cantidad de productos: " + lista.size());
    }
    public int Carga(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']//android.view.ViewGroup")));
        return lista.size();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Backpack\"]")
    private WebElement producto_1;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Bolt T-Shirt\"]")
    private WebElement producto_2;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Sauce Labs Bike Light\"]")
    private WebElement producto_3;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")
    private WebElement Btnagregarcantidad;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnAgregarcarrito;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement btnCarrito;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]/android.view.ViewGroup")
    private List<WebElement> validarCarrito;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemsTV\"]")
    private WebElement cantidadCarro;


    public void seleccionarProducto(String nombre, int cantidad) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        // Uso de map para almacenar los productos y sus correspondientes elementos
        Map<String, WebElement> productos = new HashMap<>();
        productos.put("Sauce Labs Backpack", producto_1);
        productos.put("Sauce Labs Bolt - T-Shirt", producto_2);
        productos.put("Sauce Labs Bike Light", producto_3);

        WebElement producto = productos.get(nombre);
        if (producto == null) {
            throw new IllegalArgumentException("Producto no consta en la base de datos: " + nombre);
        }

        try {
            wait.until(ExpectedConditions.visibilityOf(producto));
            producto.click();

            wait.until(ExpectedConditions.visibilityOf(Btnagregarcantidad));
            for (int i = 1; i < cantidad; i++) {
                Btnagregarcantidad.click();
            }
        } catch (TimeoutException e) {
            System.out.println("Error al seleccionar el producto " + nombre + ": " + e.getMessage());
        }
    }

    public void clickAddCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(btnAgregarcarrito));
        btnAgregarcarrito.click();
    }

    public void clickToCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(btnCarrito));
        btnCarrito.click();
    }


    public int validarcantidadCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]/android.view.ViewGroup")));
        return validarCarrito.size();
    }
    public int validarProductoenCarrito(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]/android.view.ViewGroup")));
        return validarCarrito.size();
    }

    public void Chekcout(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/itemsTV\"]")));
        System.out.println("Se agregaron: " + cantidadCarro.getText());
    }


}
