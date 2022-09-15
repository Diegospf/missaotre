package com.example.missao.repository;

import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import com.example.missao.model.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RootRepository extends JpaRepository<Root, Long> {
    @Query("select distinct r.numPolo from Root r order by r.numPolo")
    List<Long> numerosPolos();

    @Query("select distinct r.nomMunicipio from Root r order by r.nomMunicipio")
    List<String> nomesCidades();

    @Query("select distinct r.nomMunicipio from Root r where r.numPolo = :#{#poloId} order by r.nomMunicipio")
    List<String> cidadesPorPolo(@Param("poloId") String poloId);

    @Query("select distinct r.nomMunicipio from Root r where r.numSecao = :#{#secaoId} order by r.nomMunicipio")
    List<String> cidadesPorSecao(@Param("secaoId") String secaoId);

    @Query("select distinct r.numPolo from Root r where r.codMunicipioTse = :#{#codMunicipio} order by r.numPolo")
    String poloPorCidade(@Param("codMunicipio") String codMunicipio);

}
