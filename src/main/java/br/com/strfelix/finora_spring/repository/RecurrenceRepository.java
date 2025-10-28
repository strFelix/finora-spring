package br.com.strfelix.finora_spring.repository;

import br.com.strfelix.finora_spring.model.Recurrence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecurrenceRepository extends JpaRepository<Recurrence, Long> {
    List<Recurrence> findByUserId(Long userId);
}
