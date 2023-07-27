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
        log.info("Contact with id{} is getting", id);
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact with id=" + id + " was not found"));
    }


    public void deleteContactById(Long id) {
        contactRepository.delete(getContact(id));
    }


    public ContactDTO updateContactById(ContactDTO contactDTO, Long id) {
        Contact contact = getContact(id);
        contact.setContact(contactDTO.getContact());
        contactRepository.save(contact);
        return convertToDTO(contact);

    }


    public ContactDTO addContact(ContactDTO contactDTO) {
        Contact contact=new Contact();
        BeanUtils.copyProperties(contactDTO,contact);
        contactRepository.save(contact);
        return convertToDTO(contact);

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
