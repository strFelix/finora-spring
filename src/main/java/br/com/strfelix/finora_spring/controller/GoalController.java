package br.com.strfelix.finora_spring.controller;

import br.com.strfelix.finora_spring.model.Goal;
import br.com.strfelix.finora_spring.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.createGoal(goal);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Goal> findGoalsByUser(@PathVariable Long userId) {
        return goalService.findGoalsByUser(userId);
    }

    @GetMapping("/category/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Goal> findGoalsByCategory(@PathVariable Long categoryId) {
        return goalService.findGoalsByCategory(categoryId);
    }

    @PutMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGoal(@RequestBody Goal goal, @PathVariable Long categoryId) {
        goalService.updateGoal(goal, categoryId);
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGoal(@PathVariable Long categoryId) {
        goalService.deleteGoal(categoryId);
    }
}
