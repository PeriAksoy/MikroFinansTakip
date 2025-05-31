package com.mikrofinans.MikroFinans.repository;

import com.mikrofinans.MikroFinans.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
