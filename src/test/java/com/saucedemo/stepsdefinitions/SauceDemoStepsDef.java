package com.saucedemo.stepsdefinitions;

import com.saucedemo.steps.SauceDemoSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;


public class SauceDemoStepsDef {

    int cantidadSeleccionada = 0;
    String nombreProductoSeleccionado = "";

    @Steps
    SauceDemoSteps sauceDemoSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        sauceDemoSteps.validarHomePage();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        sauceDemoSteps.validarExistenciaDeProductos();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoCantidadDadaDelProductoPorNombre(int cantidad, String nombreProducto) {
        cantidadSeleccionada = cantidad;
        nombreProductoSeleccionado = nombreProducto;
        sauceDemoSteps.seleccionarProductoDeTienda(nombreProducto);
        sauceDemoSteps.seleccionoCantidadDeProductosAComprar(cantidad);
        sauceDemoSteps.seleccionoAddToCart();
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        sauceDemoSteps.ingresarAlCarrito();
        sauceDemoSteps.validarNombreDeProductoEnCarrito(nombreProductoSeleccionado);
        sauceDemoSteps.validarCantidadDelProductoEnCarrito(cantidadSeleccionada);
    }
}
