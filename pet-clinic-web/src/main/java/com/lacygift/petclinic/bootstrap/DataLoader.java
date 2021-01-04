package com.lacygift.petclinic.bootstrap;

import com.lacygift.petclinic.model.Owner;
import com.lacygift.petclinic.model.Vet;
import com.lacygift.petclinic.services.OwnerService;
import com.lacygift.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService= ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1= new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Maria");
        owner1.setLastName("Demidova");

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Anna");
        owner2.setLastName("Ivanova");

        ownerService.save(owner2);

        Vet vet1= new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Oleg");
        vet1.setLastName("Buhanov");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Michail");
        vet2.setLastName("Vetrov");

        vetService.save(vet2);
        System.out.println("Bootstrap data loaded");
    }
}
