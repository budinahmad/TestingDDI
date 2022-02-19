package com.example.tesDDI.testing.Repository;

import com.example.tesDDI.testing.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);

}
