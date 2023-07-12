package com.msd.msd.controller;

import com.msd.msd.entity.Contact;
import com.msd.msd.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    public Contact insertContact(Contact contact) {
        return contactService.addContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@RequestBody Contact contact, @PathVariable Long id) {
        return contactService.updateContact(contact, id);
    }

    @DeleteMapping("/{id}")
    public void rempveContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
    }

    @GetMapping("/{id}")
    public Contact findContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @GetMapping("/list")
    public List<Contact> findAllContacts() {
        return contactService.getAllContacts();
    }
}
