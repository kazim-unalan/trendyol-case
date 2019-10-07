package com.category.service;

import com.category.model.MainCategory;
import com.category.model.SubCategory;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
public interface CategoryService {

    Optional<MainCategory> getMainCategories(String mainCategoryCode);

    List<MainCategory> getAllMainCategories();

    Optional<SubCategory> getSubCategories(String mainCategoryCode, String subCategoryCode);

    List<SubCategory> getAllSubCategories();

}
