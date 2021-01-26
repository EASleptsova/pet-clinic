package com.lacygift.petclinic.bootstrap;

import com.lacygift.petclinic.model.Owner;
import com.lacygift.petclinic.model.PetType;
import com.lacygift.petclinic.model.Vet;
import com.lacygift.petclinic.services.OwnerService;
import com.lacygift.petclinic.services.PetTypeService;
import com.lacygift.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService= ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog= new PetType();
        dog.setName("Dog");
        PetType savedDogPetType =petTypeService.save(dog);
        PetType cat= new PetType();
        dog.setName("Cat");
        PetType savedCatPetType =petTypeService.save(cat);

        Owner owner1= new Owner();
        owner1.setFirstName("Maria");
        owner1.setLastName("Demidova");

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Anna");
        owner2.setLastName("Ivanova");

        ownerService.save(owner2);

        Vet vet1= new Vet();
        vet1.setFirstName("Oleg");
        vet1.setLastName("Buhanov");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Michail");
        vet2.setLastName("Vetrov");

        vetService.save(vet2);
        System.out.println("Bootstrap data loaded");
    }
}
