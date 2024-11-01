package com.task.Library.Management.System.services;

import com.task.Library.Management.System.models.Patron;
import com.task.Library.Management.System.repositories.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {
    PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }
    public List<Patron> getAll(){
        return patronRepository.findAll();
    }
    public Patron getOne(long id){
        return patronRepository.findById(id).orElse(null);
    }
    public String create(String name,String contact,String information){
        try {
            Patron patron = new Patron(name, contact, information);
            patronRepository.save(patron);
            return "success";
        }catch (Exception e){
            return "failed";
        }

    }
    public String update(String name,String contact,String information,long id){
        Patron patron=patronRepository.findById(id).orElse(null);
        if(patron==null){
            return "failed";
        }else{
            try{
                patron.setContact(contact);
                patron.setInformation(information);
                patron.setName(name);
                patronRepository.save(patron);
                return "success";
            }catch (Exception e){
                return "failed";
            }
        }
    }
    public String delete(long id){
        try{
            patronRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }
}
