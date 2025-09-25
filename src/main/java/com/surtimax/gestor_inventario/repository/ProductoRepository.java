package com.surtimax.gestor_inventario.repository;

import com.surtimax.gestor_inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.OptionalDouble;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
