package com.WebTechPro.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.WebTechPro.entity.Contact;
import com.WebTechPro.service.ContactService;

@Controller
public class ContactController {
	private ContactService contactService;
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping("/listallcontacts") //http://localhost:8080/WebTechPro/listallcontacts
	public String listAllLeads(Model model) {
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}

}
