package com.surtimax.gestor_inventario.repository;

import com.surtimax.gestor_inventario.entity.Verduras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerdurasRepository extends JpaRepository<Verduras,Long> {
    public String existsByNombre(String nombre);
}
