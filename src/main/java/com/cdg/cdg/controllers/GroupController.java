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
import com.cdg.cdg.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.cdg.cdg.repositories.GroupRepository;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @RequestMapping(method=RequestMethod.GET, value="/groups")
    public Iterable<Group> contact() {
        return groupRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/groups")
    public Group save(@RequestBody Group group) {
        group.setStatus("A");
        groupRepository.save(group);
        return group;
    }

    @RequestMapping(method=RequestMethod.GET, value="/groups/{id}")
    public Optional<Group> show(@PathVariable String id) {
        return groupRepository.findById(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/groups/{id}")
    public Group update(@PathVariable String id, @RequestBody Group group) {
        Optional<Group> optgroup = groupRepository.findById(id);
        Group g = optgroup.get();
        if(group.getName() != null)
            g.setName(group.getName());
        groupRepository.save(g);
        return g;
    }

    @RequestMapping(method=RequestMethod.PUT, value="/groups/delete/{id}")
    public Group delete(@PathVariable String id) {
        Optional<Group> optgroup = groupRepository.findById(id);
        Group g = optgroup.get();
        g.setStatus("B");
        groupRepository.save(g);
        return g;
    }
    
     @RequestMapping(method=RequestMethod.PUT, value="/groups/activate/{id}")
    public Group activate(@PathVariable String id) {
        Optional<Group> optgroup = groupRepository.findById(id);
        Group g = optgroup.get();
        g.setStatus("A");
        groupRepository.save(g);
        return g;
    }
}
