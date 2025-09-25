package com.surtimax.gestor_inventario.repository;

import com.surtimax.gestor_inventario.entity.Farmacia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaRepository extends JpaRepository<Farmacia,Long> {
    public String existsByNombre(String nombre);
}
