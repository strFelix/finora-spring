package br.com.strfelix.finora_spring.service;

import br.com.strfelix.finora_spring.mapper.CategoryMapper;
import br.com.strfelix.finora_spring.model.Category;
import br.com.strfelix.finora_spring.model.User;
import br.com.strfelix.finora_spring.repository.CategoryRepository;
import br.com.strfelix.finora_spring.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public Category createCategory(Category category, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        category.setUser(user);

        return categoryRepository.save(category);
    }

    public List<Category> findCategoriesByUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User not found.");
        }
        return categoryRepository.findByUserId(userId);
    }

    private Category findCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found."));
    }

    public void updateCategory(Category category, Long categoryId) {
        Category existing = findCategoryById(categoryId);
        categoryMapper.updateCategoryFromDto(category, existing);
        categoryRepository.save(existing);
    }

    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Category not found.");
        }
        categoryRepository.deleteById(id);
    }
}
