package ro.contact.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.contact.entity.Contact;
import ro.contact.repository.ContactRepository;

@Service
public class ContactServiceSql {

    @Autowired
    public ContactRepository repo;
    
    public List <Contact> getAllContacts(){
        return repo.findAll();
    }
}
