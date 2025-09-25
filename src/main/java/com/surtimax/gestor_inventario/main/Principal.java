package com.surtimax.gestor_inventario.main;

import com.surtimax.gestor_inventario.service.ProductoService;
import org.springframework.stereotype.Component;

@Component
public class Principal {

   private final ProductoService productoService;

    public Principal(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void menuPrincipal(){

        System.out.println("""
                ------------------------------------------------------------------------------------------
                ***Bienvenido al programa de control de inventario***
                ------------------------------------------------------------------------------------------""");
        productoService.agregarProductos();

        System.out.println("""
                ------------------------------------------------------------------------------------------
                ***Categorizando productos***
                ------------------------------------------------------------------------------------------""");
        productoService.organizarPorCategoria();

        System.out.println("""
                ------------------------------------------------------------------------------------------
                ***Mostrando datos registrados correspondientes a la categoria frutas***
                ------------------------------------------------------------------------------------------""");
        productoService.filtroFrutas();

        System.out.println("""
                ------------------------------------------------------------------------------------------
                ***Valor total de los productos relacionados a la categoria lácteos***
                ------------------------------------------------------------------------------------------""");
        productoService.filtroPrecioLacteos();

        System.out.println("""
                ------------------------------------------------------------------------------------------
                ***Producto con el valor mas bajo de los prodcutos registrados***
                ------------------------------------------------------------------------------------------""");
        productoService.filtroPrecioBajo();

        System.out.println("""
                ------------------------------------------------------------------------------------------
                ***Promedio más alto de precio correspondiente a los productos***
                ------------------------------------------------------------------------------------------""");

        productoService.calculoPromedioPorCategoria();
    }
}
