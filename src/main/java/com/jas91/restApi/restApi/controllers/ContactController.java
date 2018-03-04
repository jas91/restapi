package com.jas91.restApi.restApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jas91.restApi.restApi.models.Contact;
import com.jas91.restApi.restApi.repositories.ContactRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ContactController {

	@Autowired
	private ContactRepo repository;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET, produces = "application/json")
	List<Contact> getContacts() {
		return repository.findByActiveTrue();
	}

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE, produces = "application/json")
	List<Contact> delete(@PathVariable(value = "id", required = true) String id) {
		Contact contact = repository.findById(id).get();
		contact.setActive(false);
		repository.save(contact);
		log.info("Contact disabled {}", contact);
		return repository.findByActiveTrue();
	}

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> edit(Contact contact) {
		repository.save(contact);
		log.info("Contact updated {}", contact);
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> create(Contact contact) {
		repository.save(contact);
		log.info("Contact created {}", contact);
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}

}