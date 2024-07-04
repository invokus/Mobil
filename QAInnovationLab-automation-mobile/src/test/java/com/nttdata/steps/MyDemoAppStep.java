package com.nttdata.steps;

import com.nttdata.screens.MyDemoAppScreen;
import org.junit.Assert;

public class MyDemoAppStep {
    MyDemoAppScreen demo;

    public void validacionCarga() {
        Assert.assertTrue("No Existen los Productos", demo.Carga() > 0);
        demo.Productos();
    }
    public void agregarUnidades(String producto, int unidades) {
        demo.seleccionarProducto(producto,unidades);
        demo.clickAddCarrito();
    }
    public void validacionCarrito() {
        demo.clickToCarrito();
        Assert.assertTrue("Carrito Vacio", demo.validarProductoenCarrito() > 0);
        demo.validarcantidadCarrito();
        demo.Chekcout();
    }
}
