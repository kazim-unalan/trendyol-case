package com.category.dao;

import com.category.model.MainCategory;
import com.category.model.SubCategory;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
public interface CategoryDao {

    Optional<MainCategory> findMainCategories(String mainCategoryCode);

    List<MainCategory> findAllMainCategories();

    Optional<SubCategory> findSubCategories(String mainCategoryCode, String subCategoryCode);

    List<SubCategory> findAllSubCategories();


}
