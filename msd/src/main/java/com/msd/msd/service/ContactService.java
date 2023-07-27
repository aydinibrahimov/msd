package com.msd.msd.service;


import com.msd.msd.entity.Contact;
import com.msd.msd.enums.CustomErrorCode;
import com.msd.msd.exception.CustomException;
import com.msd.msd.repository.ContactRepository;
import com.msd.msd.rest.model.dto.ContactDTO;
import com.msd.msd.rest.model.response.ContactResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactResponse getAllContacts() {
        List<ContactDTO> contactDTOList = contactRepository.findAll()
                .stream()
                .map(contacts -> convertToDTO(contacts))
                .collect(Collectors.toList());

        return makeContactResponse(contactDTOList);
    }


    public ContactDTO getContactById(Long id) {
        log.info("Contact with id{} is getting", id);

        return convertToDTO(getContact(id));
    }


    public void deleteContactById(Long id) {
        contactRepository.delete(getContact(id));
    }


    public ContactDTO updateContactById(ContactDTO contactDTO, Long id) {
        Contact contact = getContact(id);
        log.info("Contact with id{} is uodated", id);
        contact.setContact(contactDTO.getContact());
        contact.setContactType(contact.getContactType());
        contactRepository.save(contact);
        return convertToDTO(contact);

    }


    public ContactDTO addContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDTO, contact);
        log.info("Contact is been saving . . . ");
        contactRepository.save(contact);
        return convertToDTO(contact);

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

    private ContactResponse makeContactResponse(List<ContactDTO> contactDTOList) {
        return ContactResponse.builder()
                .contacts(contactDTOList)
                .build();

    }

}
