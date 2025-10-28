package br.com.strfelix.finora_spring.service;

import br.com.strfelix.finora_spring.mapper.GoalMapper;
import br.com.strfelix.finora_spring.model.Category;
import br.com.strfelix.finora_spring.model.Goal;
import br.com.strfelix.finora_spring.repository.GoalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private GoalMapper goalMapper;

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> findGoalsByUser(Long userId) {
        List<Goal> goals = goalRepository.findByUserId(userId);
        if (goals.isEmpty()) {
            throw new EntityNotFoundException("No goals found for user id: " + userId);
        }
        return goals;
    }


    public List<Goal> findGoalsByCategory(Long categoryId) {
        List<Goal> goals = goalRepository.findByCategoryId(categoryId);
        if (goals.isEmpty()) {
            throw new EntityNotFoundException("No goals found for category id: " + categoryId);
        }
        return goals;
    }

    private Goal findGoalById(Long goalId) {
        return goalRepository.findById(goalId)
                .orElseThrow(() -> new EntityNotFoundException("Goal not found."));
    }

    public void updateGoal(Goal goal, Long goalId) {
        Goal existingGoal = findGoalById(goalId);
        goalMapper.updateGoalFromDto(goal, existingGoal);
        goalRepository.save(existingGoal);
    }

    public void deleteGoal(Long goalId) {
        findGoalById(goalId);
        goalRepository.deleteById(goalId);
    }
}
