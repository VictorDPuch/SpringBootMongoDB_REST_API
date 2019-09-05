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

import com.cdg.cdg.models.Membership;
import org.springframework.data.repository.CrudRepository;

public interface MembershipRepository extends CrudRepository<Membership, String> {
    @Override
    void delete(Membership deleted);
}