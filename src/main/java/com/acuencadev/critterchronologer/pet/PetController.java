package com.acuencadev.critterchronologer.pet;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    private final ModelMapper modelMapper;
    private final PetService petService;

    @Autowired
    public PetController(ModelMapper modelMapper, PetService petService) {
        this.modelMapper = modelMapper;
        this.petService = petService;
    }

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = petService.save(dtoToEntity(petDTO), petDTO.getOwnerId());

        return entityToDto(pet);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Pet pet = petService.getOne(petId);

        return entityToDto(pet);
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<PetDTO> petDTOList = new ArrayList<>();

        for (Pet pet : petService.getAll()) {
            petDTOList.add(entityToDto(pet));
        }

        return petDTOList;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<PetDTO> petDTOList = new ArrayList<>();

        for (Pet pet : petService.getByCustomerId(ownerId)) {
            petDTOList.add(entityToDto(pet));
        }

        return petDTOList;
    }

    private Pet dtoToEntity(PetDTO petDTO) {
        return modelMapper.map(petDTO, Pet.class);
    }

    private PetDTO entityToDto(Pet pet) {
        PetDTO petDTO = modelMapper.map(pet, PetDTO.class);
        petDTO.setOwnerId(pet.getCustomer().getId());

        return petDTO;
    }
}
