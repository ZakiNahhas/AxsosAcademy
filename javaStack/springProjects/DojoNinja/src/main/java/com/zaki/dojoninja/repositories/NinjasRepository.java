package com.zaki.dojoninja.repositories;

import com.zaki.dojoninja.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NinjasRepository extends CrudRepository<Ninja, Long> {
    Optional<Ninja> findById(Long id);

    List<Ninja> findAll();
}
