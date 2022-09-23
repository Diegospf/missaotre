package com.example.missao.repository;

import com.example.missao.model.Municipio;
import com.example.missao.model.Secao;
import com.example.missao.model.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecaoRepository extends JpaRepository<Secao, Long> {
    @Query("select count(id) from Secao s where s.polo.numero = :#{#poloId}")
    Long qntSecoesPorPolo(@Param("poloId") Long poloId);

    @Query("select count(id) from Secao s where s.municipio.codTse = :#{#codTse}")
    Long qntSecoesPorMunicipio(@Param("codTse") Long codTse);

    @Query("select distinct s from Secao s where s.municipio.codTse = :#{#codTse} order by s.numero")
    List<Secao> secoesPorMunicipio(@Param("codTse") Long codTse);

    @Query("select distinct s from Secao s where s.numero = :#{#numero} order by s.polo.numero, s.zona.numero")
    List<Secao> findSecao(@Param("numero") Long numero);

    @Query("select distinct s from Secao s where s.numero = :#{#numero} order by s.numero")
    List<Secao> findSecaoOrder(@Param("numero") Long numero);

    @Query("select distinct s from Secao s where s.numero = :#{#numero} order by s.zona.numero")
    List<Secao> findSecaoOrderByZona(@Param("numero") Long numero);

    @Query("select distinct s.numero from Secao s order by s.numero")
    List<Long> numerosSecaoOrdenada();
}
