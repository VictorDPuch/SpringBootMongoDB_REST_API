/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdg.cdg.controllers;

/**
 *
 * @author victorpuch
 */
import com.cdg.cdg.models.Congregant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.cdg.cdg.repositories.CongregantRepository;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class CongregantController {

    @Autowired
    CongregantRepository congregantRepository;

    @RequestMapping(method=RequestMethod.GET, value="/congregants")
    public Iterable<Congregant> contact() {
        return congregantRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/congregants")
    public Congregant save(@RequestBody Congregant contact) {
        contact.setStatus("A");
        congregantRepository.save(contact);
        return contact;
    }

    @RequestMapping(method=RequestMethod.GET, value="/congregants/{id}")
    public Optional<Congregant> show(@PathVariable String id) {
        return congregantRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/congregants/{id}")
    public Congregant update(@PathVariable String id, @RequestBody Congregant congregant) {
        Optional<Congregant> optcontact = congregantRepository.findById(id);
        Congregant c = optcontact.get();
        if(congregant.getName() != null)
            c.setName(congregant.getName());
        if(congregant.getFirst_last_name() != null)
            c.setFirst_last_name(congregant.getFirst_last_name());
        if(congregant.getSecond_last_name() != null)
            c.setSecond_last_name(congregant.getSecond_last_name());
        if(congregant.getAddress() != null)
            c.setAddress(congregant.getAddress());
        if(congregant.getPhone() != null)
            c.setPhone(congregant.getPhone());
        if(congregant.getEmail() != null)
            c.setEmail(congregant.getEmail());
        if(congregant.getBirthday() != null)
            c.setBirthday(congregant.getBirthday());
        if(congregant.getGender() != null)
            c.setGender(congregant.getGender());
        if(congregant.getCivil_status() != null)
            c.setCivil_status(congregant.getCivil_status());
        if(congregant.getType() != null)
            c.setType(congregant.getType());
         if(congregant.getBaptized() != null)
            c.setBaptized(congregant.getBaptized());
        congregantRepository.save(c);
        return c;
    }

    @RequestMapping(method=RequestMethod.PUT, value="/congregants/delete/{id}")
    public Congregant delete(@PathVariable String id) {
        Optional<Congregant> optcontact = congregantRepository.findById(id);
        Congregant c = optcontact.get();
        c.setStatus("B");
        congregantRepository.save(c);
        return c;
    }
    
     @RequestMapping(method=RequestMethod.PUT, value="/congregants/activate/{id}")
        public Congregant activate(@PathVariable String id) {
        Optional<Congregant> optcontact = congregantRepository.findById(id);
        Congregant c = optcontact.get();
        c.setStatus("A");
        congregantRepository.save(c);
        return c;
    }
}
