package com.lacygift.petclinic.services;

import com.lacygift.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
}
