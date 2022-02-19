package com.example.tesDDI.testing.Service;

import com.example.tesDDI.testing.Entity.Category;
import com.example.tesDDI.testing.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
    public  Iterable<Category> saveAllCategory(Iterable<Category> categories){
        return categoryRepository.saveAll(categories);
    }
    public Category updateCategory(Category category){
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);
        existingCategory.setName(category.getName());
        existingCategory.setGambar(category.getGambar());
        return categoryRepository.save(existingCategory);
    }
    public Category findCategoryById(int id){
        return categoryRepository.findById(id).orElse(null);
    }
    public Iterable<Category> findCategoryAll(){
        return categoryRepository.findAll();
    }
    public Category findCategoryByName (String name){
        return categoryRepository.findByName(name);
    }
    public String deleteCategory (int id){
         categoryRepository.deleteById(id);
        return "Category was deleted";
    }
}
