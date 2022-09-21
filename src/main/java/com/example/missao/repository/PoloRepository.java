package com.example.missao.repository;

import com.example.missao.model.Municipio;
import com.example.missao.model.Polo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PoloRepository extends JpaRepository<Polo, Long> {
    List<Polo> findByNumero(Long num);

    @Query("select p from Polo p order by p.numero")
    List<Polo> poloOrdenada();

    @Query("select distinct p from Polo p where p.numero = :#{#idPolo}")
    Polo findPolo(@Param("idPolo") Long idPolo);
}
