package com.axsos.studentroster.repositories;

import com.axsos.studentroster.models.Dorm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {

    List<Dorm> findAllByOrderByNameAsc();

    Optional<Dorm> findByNameIgnoreCase(String name);
}
