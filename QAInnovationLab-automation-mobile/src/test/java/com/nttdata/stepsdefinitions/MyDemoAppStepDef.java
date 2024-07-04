package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyDemoAppStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MyDemoAppStepDef {

    @Steps
    MyDemoAppStep demo;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        demo.validacionCarga();

    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(int unidades, String producto) {
        demo.agregarUnidades(producto, unidades);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        demo.validacionCarrito();
    }
}
