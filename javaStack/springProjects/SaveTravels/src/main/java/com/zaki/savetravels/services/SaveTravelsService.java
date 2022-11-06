package com.zaki.savetravels.services;

import com.zaki.savetravels.models.SaveTravels;
import com.zaki.savetravels.repositories.SaveTravelsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SaveTravelsService {
    private final SaveTravelsRepository saveRepository;

    public SaveTravelsService(SaveTravelsRepository saveRepository) {
        this.saveRepository = saveRepository;
    }
    public List<SaveTravels> allSaveTravels() {
        return saveRepository.findAll();
    }
    public SaveTravels createSaveTravels(SaveTravels st) {
        return saveRepository.save(st);
    }
    public SaveTravels findSaveTravels(Long id) {
        Optional<SaveTravels> optionalSaveTravels = saveRepository.findById(id);
        if(optionalSaveTravels.isPresent()) {
            return optionalSaveTravels.get();
        } else {
            return null;
        }
    }
    public SaveTravels updateSavetravels(SaveTravels st){
        return saveRepository.save(st);
    }
    public SaveTravels updateSaveTravels(Long id, String expense, String desc, String vendor, Integer amount) {
        SaveTravels saveTravels = findSaveTravels(id);
        if(saveTravels.getId()==id) {
            saveTravels.setExpense(expense);
            saveTravels.setDescription(desc);
            saveTravels.setVendor(vendor);
            saveTravels.setAmount(amount);
            return createSaveTravels(saveTravels);
        } else {
            return null;
        }
    }

    public void deleteSaveTravels(Long id) {
        Optional<SaveTravels> op = saveRepository.findById(id);
        if(op.isPresent()) {
            saveRepository.deleteById(id);
        }
    }
}
