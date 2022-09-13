package com.example.missao.repository;

import com.example.missao.model.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RootRepository extends JpaRepository<Root, Long> {
    @Query("select distinct r.numPolo from Root r order by r.numPolo")
    List<Integer> numerosPolos();

}
