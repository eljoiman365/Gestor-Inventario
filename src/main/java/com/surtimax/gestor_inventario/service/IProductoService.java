package com.surtimax.gestor_inventario.service;

import com.surtimax.gestor_inventario.entity.Producto;

import java.util.List;

public interface IProductoService {
    void agregarProductos();
    void organizarPorCategoria();
    void filtroFrutas();
    void filtroPrecioLacteos();
    void filtroPrecioBajo();
    void calculoPromedioPorCategoria();


}
