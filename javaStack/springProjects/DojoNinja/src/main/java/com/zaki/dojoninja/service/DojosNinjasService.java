package com.zaki.dojoninja.service;

import com.zaki.dojoninja.models.Dojo;
import com.zaki.dojoninja.models.Ninja;
import com.zaki.dojoninja.repositories.DojosRepository;
import com.zaki.dojoninja.repositories.NinjasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojosNinjasService {

    private final DojosRepository dojosRepository;
    private final NinjasRepository ninjasRepository;

    public DojosNinjasService(DojosRepository dojosRepository, NinjasRepository ninjasRepository) {
        this.dojosRepository = dojosRepository;
        this.ninjasRepository = ninjasRepository;
    }
    public List<Dojo> allDojos() {
        return dojosRepository.findAll();
    }
    public List<Ninja> allNinjas() {
        return ninjasRepository.findAll();
    }
    public Ninja createNinja(Ninja ninja) {
        return ninjasRepository.save(ninja);
    }
    public Dojo createDojo(Dojo dojo) {
        return dojosRepository.save(dojo);
    }
    public Dojo findDojo(Long id) {
        return this.dojosRepository.findById(id).orElse(null);
    }
    public Ninja findNinja(Long id) {
        return this.ninjasRepository.findById(id).orElse(null);
    }
    public Dojo updateDojos(Dojo dojo){
        return dojosRepository.save(dojo);
    }
}
