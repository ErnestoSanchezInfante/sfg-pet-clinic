package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetService petService;

    public PetSDJpaService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petService.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petService.findById(aLong);
    }

    @Override
    public Pet save(Pet object) {
        return petService.save(object);
    }

    @Override
    public void delete(Pet object) {
        petService.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petService.deleteById(aLong);
    }
}
