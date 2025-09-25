package com.surtimax.gestor_inventario.repository;

import com.surtimax.gestor_inventario.entity.Frutas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutasRepository extends JpaRepository<Frutas,Long> {
    public String existsByNombre(String nombre);
}
