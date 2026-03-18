package com.saucedemo.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.List;

public class MainScreen extends PageObject {

    WebDriverWait wait;

    public MainScreen(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productsTitle;

    @AndroidFindBy(xpath ="//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']/android.view.ViewGroup")
    private List<WebElement> listaProductos;

    @AndroidFindBy(id ="com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productoPorNombre;

    @AndroidFindBy(id ="com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement cantidadDeProductosDisplayed;

    @AndroidFindBy(id ="com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement btnAumentarCantidadProducto;

    @AndroidFindBy(id ="com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement btnAddToCart;

    @AndroidFindBy(id ="com.saucelabs.mydemoapp.android:id/cartRL")
    private WebElement carritoDeCompras;

    @AndroidFindBy(id ="com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement nombreProductoEnCarrito;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Displays selected product']")
    private WebElement imagenProductoCargada;


    public void validarHomePage(){
        wait.until(ExpectedConditions.visibilityOf(productsTitle));
    }

    public int getCantidadDeProductos(){
        wait.until(ExpectedConditions.visibilityOf(productsTitle));
        return listaProductos.size();
    }

    public void seleccionarProductoPorNombre(String nombreProducto) {
        String xpathBase = "//android.widget.ImageView[@content-desc='%s']";
        String xpathProductoPorNombre = String.format(xpathBase, nombreProducto);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathProductoPorNombre)));
        find(By.xpath(xpathProductoPorNombre)).click();
        wait.until(ExpectedConditions.elementToBeClickable(imagenProductoCargada));
    }



    public void seleccionarCantidadDeProductosAComprar(int cantidad) {
        getDriver().findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"1\"))"
        ));
        wait.until(ExpectedConditions.visibilityOf(cantidadDeProductosDisplayed));
        int cantidadActual = Integer.parseInt(cantidadDeProductosDisplayed.getText().trim());
        while(cantidadActual < cantidad){
            wait.until(ExpectedConditions.elementToBeClickable(btnAumentarCantidadProducto));
            btnAumentarCantidadProducto.click();
            cantidadActual++;
        }
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
        btnAddToCart.click();
    }

    public void clickCarritoDeCompras() {
        wait.until(ExpectedConditions.elementToBeClickable(carritoDeCompras));
        carritoDeCompras.click();
    }

    public void validarNombreDeProductoEnCarrito(String nombreProductoSeleccionado) {
        wait.until(ExpectedConditions.visibilityOf(nombreProductoEnCarrito));
        Assert.assertEquals(nombreProductoEnCarrito.getText().trim(), nombreProductoSeleccionado);
    }

    public void validarCantidadDelProductoEnCarrito(int cantidadSeleccionada) {
        wait.until(ExpectedConditions.visibilityOf(cantidadDeProductosDisplayed));
        Assert.assertEquals(cantidadDeProductosDisplayed.getText().trim(), String.valueOf(cantidadSeleccionada));
    }
}
