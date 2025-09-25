package com.surtimax.gestor_inventario.repository;

import com.surtimax.gestor_inventario.entity.Cosmeticos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CosmeticosRepository extends JpaRepository<Cosmeticos,Long> {
    public String existsByNombre(String nombre);
}
