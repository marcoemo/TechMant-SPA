package com.example.Diagnosticos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Diagnosticos.model.Diagnostico;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {

}
