package com.msd.msd.controller;

import com.msd.msd.entity.Contact;
import com.msd.msd.rest.model.dto.ContactDTO;
import com.msd.msd.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/msd/v1/contacts")
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public ContactDTO insertContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @PutMapping("/{id}")
    public ContactDTO updateContact(@RequestBody ContactDTO contactDTO, @PathVariable Long id) {
        return contactService.updateContactById(contactDTO, id);
    }

    @DeleteMapping("/{id}")
    public void removeContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
    }

    @GetMapping("/{id}")
    public Contact findContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @GetMapping
    public List<Contact> findAllContacts() {
        return contactService.getAllContacts();
    }
}
