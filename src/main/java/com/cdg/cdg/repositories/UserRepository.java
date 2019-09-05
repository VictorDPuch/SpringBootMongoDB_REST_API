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

import com.cdg.cdg.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    @Override
    void delete(User deleted);
}