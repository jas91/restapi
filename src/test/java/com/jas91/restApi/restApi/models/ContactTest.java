package com.jas91.restApi.restApi.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContactTest {

	@Test
	public void createTest() {
		Contact contact  = Contact.builder().id("1").firstName("firstName").lastName("lastName").email("email").build();
		assertEquals("1", contact.getId());
		assertEquals("firstName", contact.getFirstName());
		assertEquals("lastName", contact.getLastName());
		assertEquals("email", contact.getEmail());
		assertEquals(true, contact.isActive());
		contact.toString();
	}
	
	@Test
	public void deleteTest() {
		Contact contact  = new Contact();
		contact.setActive(false);
		assertEquals(false, contact.isActive());	
	}
}
