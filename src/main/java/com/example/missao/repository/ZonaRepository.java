package com.example.missao.repository;

import com.example.missao.model.Municipio;
import com.example.missao.model.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ZonaRepository extends JpaRepository<Zona, Long> {
    //@Query("select distinct z from Zona z inner join z.municipios m where m.polo = :#{#poloId}")
    @Query("select distinct z from Zona z inner join z.municipios m where m.polo.numero = :#{#poloId} order by z.numero")
    List<Zona> zonaPorPolo(@Param("poloId") Long poloId);

    @Query("select distinct z from Zona z inner join z.municipios m where m.codTse = :#{#codTse} order by z.numero")
    List<Zona> zonaPorMunicipio(@Param("codTse") Long codTse);

    @Query("select distinct z from Zona z where z.numero = :#{#numero}")
    Zona findZona(@Param("numero") Long numero);

    @Query("select z from Zona z order by z.numero")
    List<Zona> zonaOrdenada();
}
