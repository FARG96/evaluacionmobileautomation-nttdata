package com.saucedemo.steps;

import com.saucedemo.screens.MainScreen;
import org.junit.Assert;

public class SauceDemoSteps {

    MainScreen mainScreen;

    public void validarHomePage() {
        mainScreen.validarHomePage();
    }

    public void validarExistenciaDeProductos() {
        Assert.assertTrue(mainScreen.getCantidadDeProductos() > 0);
    }

    public void seleccionarProductoDeTienda(String nombreProducto) {
        mainScreen.seleccionarProductoPorNombre(nombreProducto);
    }

    public void seleccionoCantidadDeProductosAComprar(int cantidad) {
        mainScreen.seleccionarCantidadDeProductosAComprar(cantidad);
    }

    public void seleccionoAddToCart() {
        mainScreen.clickAddToCart();
    }

    public void ingresarAlCarrito() {
        mainScreen.clickCarritoDeCompras();
    }

    public void validarNombreDeProductoEnCarrito(String nombreProductoSeleccionado) {
       mainScreen.validarNombreDeProductoEnCarrito(nombreProductoSeleccionado);
    }

    public void validarCantidadDelProductoEnCarrito(int cantidadSeleccionada) {
        mainScreen.validarCantidadDelProductoEnCarrito(cantidadSeleccionada);
    }
}
