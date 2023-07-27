package com.msd.msd.controller;

import com.msd.msd.entity.Contact;
import com.msd.msd.rest.model.dto.ContactDTO;
import com.msd.msd.rest.model.response.ContactResponse;
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
    public ContactDTO insertContact(@RequestBody ContactDTO contactDTO) {
        return contactService.addContact(contactDTO);
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
    public ContactDTO findContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @GetMapping
    public ContactResponse findAllContacts() {
        return contactService.getAllContacts();
    }
}
