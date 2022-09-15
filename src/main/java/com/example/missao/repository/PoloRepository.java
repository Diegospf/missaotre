package com.example.missao.repository;

import com.example.missao.model.Polo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoloRepository extends JpaRepository<Polo, Long> {
    List<Polo> findByNumero(Long num);
}
