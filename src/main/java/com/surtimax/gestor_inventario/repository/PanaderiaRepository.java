package com.surtimax.gestor_inventario.repository;

import com.surtimax.gestor_inventario.entity.Panaderia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanaderiaRepository extends JpaRepository<Panaderia, Long> {
    public String existsByNombre(String nombre);
}
