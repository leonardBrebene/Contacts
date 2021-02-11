package ro.contact.service;

import java.io.FileWriter;
import org.springframework.stereotype.Service;
import ro.contact.entity.*;

@Service
public class ContactService {
    
    public boolean saveContact(Contact contact){
        try{
            FileWriter writer= new FileWriter("agenda.txt",true);
            String line="ID:"+ contact.getId()+", Firstname:"+contact.getFirstName()+", Lastname:" +contact.getLastName()+", phonenumber:"+ contact.getPhoneNumber()+";\n";
            writer.append(line);
            writer.close();
        }
      catch(Exception e){
          System.out.println(e.getLocalizedMessage());
      }
      return false;
    }

    public boolean saveContact2(String contact){
        try{
            FileWriter writer= new FileWriter("agenda.json",true);
            String line =contact+",\n";
            writer.append(line);
            writer.close();
        }
      catch(Exception e){
          System.out.println(e.getLocalizedMessage());
      }
      return false;
    }
}
