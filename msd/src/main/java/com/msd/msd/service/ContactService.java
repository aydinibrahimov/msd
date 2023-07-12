package com.msd.msd.service;


import com.msd.msd.entity.Contact;
import com.msd.msd.repository.ClientRepository;
import com.msd.msd.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }


    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact with id=" + id + " was not found"));
    }


    public void deleteContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if (contact.isPresent()) {
            contactRepository.deleteById(id);
        } else {
            contact.orElseThrow(() -> new RuntimeException("Contact with id=" + id + " was not found"));
        }
    }


    public Contact updateContact(Contact contact,Long id ) {
        Optional<Contact> c = contactRepository.findById(id);
        if (c.isPresent()) {
            return contactRepository.save(contact);
        }
        return c.orElseThrow(() -> new RuntimeException("Contact with id=" + id + " was not found"));
    }


    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }
}
