package br.com.strfelix.finora_spring.repository;

import br.com.strfelix.finora_spring.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUserId(Long userId);
    List<Goal> findByCategoryId(Long categoryId);
}
