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
import com.cdg.cdg.models.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.cdg.cdg.repositories.MembershipRepository;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class MembershipController {

    @Autowired
    MembershipRepository membershipRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/memberships")
    public Iterable<Membership> membership() {
        return membershipRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/memberships")
    public Membership save(@RequestBody Membership membership) {
        membership.setStatus("A");
        membershipRepository.save(membership);
        return membership;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/memberships/{id}")
    public Optional<Membership> show(@PathVariable String id) {
        return membershipRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/memberships/{id}")
    public Membership update(@PathVariable String id, @RequestBody Membership membership) {
        Optional<Membership> optmembership = membershipRepository.findById(id);
        Membership m = optmembership.get();
        if (membership.getGroup_id() != null) {
            m.setGroup_id(membership.getGroup_id());
        }
        membershipRepository.save(m);
        return m;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/memberships/delete/{id}")
    public Membership delete(@PathVariable String id) {
        Optional<Membership> optmembership = membershipRepository.findById(id);
        Membership m = optmembership.get();
        m.setStatus("B");
        membershipRepository.save(m);
        return m;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/memberships/activate/{id}")
    public Membership activate(@PathVariable String id) {
        Optional<Membership> optmembership = membershipRepository.findById(id);
        Membership m = optmembership.get();
        m.setStatus("A");
        membershipRepository.save(m);
        return m;
    }
}
