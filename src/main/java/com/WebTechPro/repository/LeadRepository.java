package com.WebTechPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WebTechPro.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
