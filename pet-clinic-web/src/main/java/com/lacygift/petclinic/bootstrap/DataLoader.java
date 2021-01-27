package com.lacygift.petclinic.bootstrap;

import com.lacygift.petclinic.model.*;
import com.lacygift.petclinic.services.OwnerService;
import com.lacygift.petclinic.services.PetTypeService;
import com.lacygift.petclinic.services.SpecialityService;
import com.lacygift.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService= ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count= petTypeService.findAll().size();
        if(count ==0) {
            loadData();
        }
    }

    private void loadData() {

        PetType dog= new PetType();
        dog.setName("Dog");
        PetType savedDogPetType =petTypeService.save(dog);
        PetType cat= new PetType();
        dog.setName("Cat");
        PetType savedCatPetType =petTypeService.save(cat);

        Speciality radiology =  new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery =  new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgey = specialityService.save(surgery);

        Speciality dentistry =  new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1= new Owner();
        owner1.setFirstName("Maria");
        owner1.setLastName("Demidova");
        owner1.setAddress("123 Street");
        owner1.setCity("London");
        owner1.setTelephone("564526369");

        Pet pet1= new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthdate(LocalDate.now());
        pet1.setName("Rosco");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setFirstName("Anna");
        owner2.setLastName("Ivanova");
        owner2.setAddress("456 Street");
        owner2.setCity("London");
        owner2.setTelephone("5687595262");

        Pet pet2= new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthdate(LocalDate.now());
        pet2.setName("Garfield");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        Vet vet1= new Vet();
        vet1.setFirstName("Oleg");
        vet1.setLastName("Buhanov");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Michail");
        vet2.setLastName("Vetrov");
        vet2.getSpecialties().add(savedSurgey);

        vetService.save(vet2);
        System.out.println("Bootstrap data loaded");
    }
}
