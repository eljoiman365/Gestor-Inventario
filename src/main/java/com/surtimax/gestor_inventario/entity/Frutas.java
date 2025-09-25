package com.surtimax.gestor_inventario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Frutas {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_producto")
    private Long idProducto;
    private String nombre;
    private int cantidad;
    private double precio;

    public Frutas (Producto producto){
        this.nombre = producto.getNombre();
        this.cantidad = producto.getCantidad();
        this.precio = producto.getPrecio();
    }

    @Override
    public String toString(){
        return "--------------------------------------" + "\n" +
                "* Id Producto: " + idProducto + "\n" +
                "* Nombre: " + nombre + "\n" +
                "* Cantidad: " + cantidad + "\n" +
                "* Ṕrecio: " + precio + "\n" +
                "--------------------------------------";
    }
}
