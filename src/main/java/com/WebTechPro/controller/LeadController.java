package com.WebTechPro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.WebTechPro.entity.Contact;
import com.WebTechPro.entity.Lead;
import com.WebTechPro.service.ContactService;
import com.WebTechPro.service.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	//http://localhost:8080/WebTechPro/viewCreateLeadPage
	@GetMapping("/viewCreateLeadPage")
	public String viewCreateLeadPage() {
		return "create_new_lead";
	}
	@PostMapping("/save")
	public String saveLead(@ModelAttribute("lead")Lead lead, Model model) {
		leadService.saveOneLead(lead);
		model.addAttribute("lead", lead);
		return"lead_info";
	}
	@PostMapping("/convertLead")
	public String ConvertLead(@RequestParam("id")long id, Model model) {
		Lead lead=leadService.findLeadById(id);
		Contact contact = new Contact();
		contact.setFirstname(lead.getFirstname());
		contact.setLastname(lead.getLastname());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactService.saveContact(contact);
		leadService.deleteLeadById(id);
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}
	
	@RequestMapping("/listall") //http://localhost:8080/WebTechPro/listall
	public String listAllLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id")long id,Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return"lead_info";
	}
}
