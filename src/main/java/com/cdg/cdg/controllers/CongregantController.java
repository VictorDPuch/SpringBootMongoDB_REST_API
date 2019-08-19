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
        congregantRepository.save(contact);
        return contact;
    }

    @RequestMapping(method=RequestMethod.GET, value="/congregants/{id}")
    public Optional<Congregant> show(@PathVariable String id) {
        System.out.println("reached");
        return congregantRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/congregants/{id}")
    public Congregant update(@PathVariable String id, @RequestBody Congregant congregant) {
        Optional<Congregant> optcontact = congregantRepository.findById(id);
        Congregant c = optcontact.get();
        if(congregant.getName() != null)
            c.setName(congregant.getName());
        if(congregant.getFirst_last_name() != null)
            c.setName(congregant.getFirst_last_name());
        if(congregant.getSecond_last_name() != null)
            c.setName(congregant.getSecond_last_name());
        if(congregant.getAddress() != null)
            c.setAddress(congregant.getAddress());
        if(congregant.getPhone() != null)
            c.setPhone(congregant.getPhone());
        if(congregant.getEmail() != null)
            c.setEmail(congregant.getEmail());
        if(congregant.getBirthday() != null)
            c.setEmail(congregant.getBirthday());
        if(congregant.getGender() != null)
            c.setEmail(congregant.getGender());
        if(congregant.getCivil_status() != null)
            c.setEmail(congregant.getCivil_status());
        if(congregant.getType() != null)
            c.setEmail(congregant.getType());
         if(congregant.getBaptized() != null)
            c.setEmail(congregant.getBaptized());
        congregantRepository.save(c);
        return c;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/congregants/{id}")
    public String delete(@PathVariable String id) {
        Optional<Congregant> coptcongregant = congregantRepository.findById(id);
        Congregant congregant=  coptcongregant.get();
        congregantRepository.delete(congregant);
        return "";
    }
}
