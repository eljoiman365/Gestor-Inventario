package com.surtimax.gestor_inventario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cosmeticos {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_producto")
    private Long idProducto;
    @Column(unique = true)
    private String nombre;
    private int cantidad;
    private double precio;

    public Cosmeticos (Producto producto){
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
