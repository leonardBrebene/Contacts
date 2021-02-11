package ro.contact.controler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.contact.entity.Contact;

import ro.contact.service.ContactServiceSql;

@RestController
public class ContactController {

  @Autowired // constructor
  //private ContactService service; // creaza un obiect ContactService
  private ContactServiceSql servicesql;
  public ArrayList<Contact> contactList = new ArrayList<Contact>();

  // @CrossOrigin
  // @PostMapping("contact/add")
  // public Map<String, Object> saveCotact(@RequestBody Contact contact) {
  //   System.out.println("Am primit:"+contact.toString());
  //   if (service.saveContact(contact)) {
  //     return Collections.singletonMap("succes", true);
  //   }
  //   try{contactList.add(contact);
  //   }
  //   catch(Exception e){
  //     System.out.println(e.getMessage());
  //   }
  //   return Collections.singletonMap("success", true);

  // }
  @CrossOrigin
  @GetMapping("contact/getAll")
  public Object afiseazaContacte() {
    ArrayList<String> measajlipsa = new ArrayList<String>(1);
    measajlipsa.add("There are no contacts in the phonebook");
    // if (contactList.isEmpty()) {
    //   includeContactele();
    // }

    if (contactList.isEmpty()) {
      return measajlipsa;
    } else {
      return contactList;
    }
  }

  @GetMapping("contact/get/{firstName}")
  // @ResponseBody
  public String contact(@PathVariable String firstName) {
    String contactat = "Contact does not exists";
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    for (Contact contact : contactList) {
      if (contact.getFirstName().equals(firstName) || contact.getLastName().equals(firstName)) {
        try {
          contactat = ow.writeValueAsString(contact);
        } catch (Exception e) {
        }

        return contactat;
      }
    }
    return contactat;
  }
  @CrossOrigin //foarte important
  @DeleteMapping("contact/delete/{id}")
  public String deleteContact(@PathVariable Integer id) {
    
    int indexToDelete = -1;
    String response = "The contact was not deleted";
    for (Contact contact : contactList) {
      if (contact.getId() == id) {
        indexToDelete = contactList.indexOf(contact);
        response = "The contact was successfully deleted";
      }
    }
    if (indexToDelete != -1) {
      contactList.remove(indexToDelete);
    }
    System.out.println("A fost apelat delete am sters ID"+ indexToDelete+1);
   
    return response;

  }
  @CrossOrigin
  @GetMapping("contact/getallcontacts")
  public List<Contact> getallcontacts() {
    
   List<Contact>lists=servicesql.getAllContacts();

   return lists;
  }

  

  // public void includeContactele() {
  //   ArrayList<String> listaContacte = searchInFile();
  //   String[] lines = new String[4];
  //   for (String line : listaContacte) {
  //     lines = line.split("\\,(.*?)\\:|;");
  //     Contact contact = new Contact(lines[1], lines[2], lines[3]);
  //     contactList.add(contact);
  //   }
  // }

  public ArrayList<String> searchInFile() {

    ArrayList<String> liniiContacte = new ArrayList<String>();
    try {
      File myObj = new File("agenda.txt");
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        liniiContacte.add(myReader.nextLine());
      }
      myReader.close();
    }

    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    return liniiContacte;
  }

}
