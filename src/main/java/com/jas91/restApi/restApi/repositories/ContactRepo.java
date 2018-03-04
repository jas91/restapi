package com.jas91.restApi.restApi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jas91.restApi.restApi.models.Contact;

public interface ContactRepo extends MongoRepository<Contact, String> {

	List<Contact> findByActiveTrue();
}