package com.example.missao.repository;

import com.example.missao.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
    @Query("select distinct m from Municipio m where m.polo.numero = :#{#poloId} order by m.nome")
    List<Municipio> cidadesPorPolo(@Param("poloId") Long poloId);
}
