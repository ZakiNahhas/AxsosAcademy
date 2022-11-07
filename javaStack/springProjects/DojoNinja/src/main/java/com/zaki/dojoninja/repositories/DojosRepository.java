package com.zaki.dojoninja.repositories;

import com.zaki.dojoninja.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DojosRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
    Optional<Dojo> findById(Long id);

}
