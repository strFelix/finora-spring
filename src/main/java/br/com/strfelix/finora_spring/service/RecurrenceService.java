package br.com.strfelix.finora_spring.service;

import br.com.strfelix.finora_spring.mapper.RecurrenceMapper;
import br.com.strfelix.finora_spring.model.*;
import br.com.strfelix.finora_spring.repository.CategoryRepository;
import br.com.strfelix.finora_spring.repository.LocalRepository;
import br.com.strfelix.finora_spring.repository.RecurrenceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecurrenceService {

    @Autowired
    private RecurrenceRepository recurrenceRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private RecurrenceMapper recurrenceMapper;

    public void createRecurrence(Recurrence recurrence, Long userId, Long categoryId, Long localId) {
        User user = userService.FindUserById(userId);
        recurrence.setUser(user);

        if (categoryId != null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new EntityNotFoundException("Category not found."));
            recurrence.setCategory(category);
        }

        if (localId != null) {
            Local local = localRepository.findById(localId)
                    .orElseThrow(() -> new EntityNotFoundException("Local not found."));
            recurrence.setLocal(local);
        }

        recurrenceRepository.save(recurrence);
    }

    public List<Recurrence> findByUser(Long userId) {
        return recurrenceRepository.findByUserId(userId);
    }

    public Recurrence findRecurrenceById(Long recurrenceId) {
        return recurrenceRepository.findById(recurrenceId)
                .orElseThrow(() -> new EntityNotFoundException("Recurrence not found."));
    }

    public void updateRecurrence(Recurrence recurrence, Long recurrenceId) {
        Recurrence existingRecurrence = findRecurrenceById(recurrenceId);
        recurrenceMapper.updateRecurrenceFromDto(recurrence, existingRecurrence);
        recurrenceRepository.save(existingRecurrence);
    }

    public void deleteRecurrence(Long recurrenceId) {
        findRecurrenceById(recurrenceId);
        recurrenceRepository.deleteById(recurrenceId);
    }
}
