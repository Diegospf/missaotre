package com.example.missao.repository;

import com.example.missao.model.Municipio;
import com.example.missao.model.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ZonaRepository extends JpaRepository<Zona, Long> {
//    @Query("select distinct z from Zona z join z.municipios m where m.polo = :#{#poloId}")
//    List<Zona> zonaPorPolo(@Param("poloId") Long poloId);
}
