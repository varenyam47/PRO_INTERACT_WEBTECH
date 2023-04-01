package com.WebTechPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WebTechPro.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
