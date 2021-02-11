package ro.contact.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ro.contact.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    
}
