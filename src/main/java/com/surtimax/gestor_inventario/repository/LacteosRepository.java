package com.surtimax.gestor_inventario.repository;

import com.surtimax.gestor_inventario.entity.Lacteos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LacteosRepository extends JpaRepository<Lacteos,Long> {
    public String existsByNombre(String nombre);
}
