package com.axsos.studentroster.services;

import com.axsos.studentroster.models.Dorm;
import com.axsos.studentroster.repositories.DormRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class DormService {

    private final DormRepository dormRepository;

    public DormService(DormRepository dormRepository) {
        this.dormRepository = dormRepository;
    }

    public List<Dorm> findAll() {
        return dormRepository.findAllByOrderByNameAsc();
    }

    public Dorm findById(Long id) {
        return dormRepository.findById(id).orElse(null);
    }

    public Dorm create(Dorm dorm, BindingResult result) {

        // Do not check duplicates when the name already has format errors.
        if (!result.hasFieldErrors("name")) {
            Optional<Dorm> existingDorm =
                    dormRepository.findByNameIgnoreCase(dorm.getName());

            if (existingDorm.isPresent()) {
                result.rejectValue(
                        "name",
                        "Unique",
                        "A dorm with this name already exists."
                );
            }
        }

        if (result.hasErrors()) {
            return null;
        }

        return dormRepository.save(dorm);
    }
}
