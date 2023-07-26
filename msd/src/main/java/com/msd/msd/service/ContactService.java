package com.msd.msd.service;


import com.msd.msd.entity.Contact;
import com.msd.msd.enums.CustomErrorCode;
import com.msd.msd.exception.CustomException;
import com.msd.msd.repository.ContactRepository;
import com.msd.msd.rest.model.dto.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }


    public Contact getContactById(Long id) {
        log.info("Contact with id{} is getting",id);
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


    public Contact updateContactById(Contact contact, Long id) {
        Optional<Contact> c = contactRepository.findById(id);
        if (c.isPresent()) {
            return contactRepository.save(contact);
        }
        return c.orElseThrow(() -> new RuntimeException("Contact with id=" + id + " was not found"));
    }


    public ContactDTO addContact(Contact contact) {
        return contactRepository.save(contact);
    }

}

    private Contact getContact(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.CONTACT_NOT_FOUND));
    }

    private ContactDTO convertToDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        BeanUtils.copyProperties(contact, contactDTO);
        return contactDTO;
    }

}
