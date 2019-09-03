/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdg.cdg.repositories;

/**
 *
 * @author victorpuch
 */

import com.cdg.cdg.models.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, String> {
    @Override
    void delete(Group deleted);
}