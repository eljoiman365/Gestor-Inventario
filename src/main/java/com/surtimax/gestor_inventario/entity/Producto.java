package com.surtimax.gestor_inventario.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_producto")
    private Long idProducto;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;

    public Producto(Producto productos) {
        this.nombre = productos.nombre;
        this.categoria = productos.categoria;
        this.cantidad = productos.cantidad;
        this.precio = productos.precio;
    }

    @Override
    public String toString(){
        return "--------------------------------------" + "\n" +
                "* Id Producto: " + idProducto + "\n" +
                "* Categoria: " + categoria + "\n" +
                "* Nombre: " + nombre + "\n" +
                "* Cantidad: " + cantidad + "\n" +
                "* Ṕrecio: " + precio + "\n" +
                "--------------------------------------";
    }
}
