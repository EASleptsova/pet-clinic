package com.lacygift.petclinic.services;

import com.lacygift.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Set<Vet> findAll();
    Vet save(Vet vet);
}
