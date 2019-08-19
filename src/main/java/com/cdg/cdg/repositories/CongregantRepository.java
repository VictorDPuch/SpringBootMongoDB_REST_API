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

import com.cdg.cdg.models.Congregant;
import org.springframework.data.repository.CrudRepository;

public interface CongregantRepository extends CrudRepository<Congregant, String> {
    @Override
    void delete(Congregant deleted);
}