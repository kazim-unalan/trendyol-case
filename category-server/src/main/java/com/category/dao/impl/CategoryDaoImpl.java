package com.category.dao.impl;

import com.category.dao.CategoryDao;
import com.category.model.MainCategory;
import com.category.model.SubCategory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    private static List<MainCategory> MAIN_CATEGORIES = null;
    private static List<SubCategory> SUB_CATEGORIES = null;

    @PostConstruct
    public void init() {
        MainCategory mainCategory = new MainCategory("food", "Food", "FOOD");
        MAIN_CATEGORIES = Arrays.asList(mainCategory);
        SUB_CATEGORIES = Arrays.asList(new SubCategory("fruit", "Fruit", "FRUIT", mainCategory), new SubCategory("vegetables", "Vegetables", "VEGETABLES", mainCategory));
    }

    @Override
    public Optional<MainCategory> findMainCategories(String mainCategoryCode) {
        return MAIN_CATEGORIES.stream().filter(mainCategory -> mainCategory.getCode().equals(mainCategoryCode)).findAny();
    }

    @Override
    public List<MainCategory> findAllMainCategories() {
        return MAIN_CATEGORIES;
//        return Optional.empty();
    }

    @Override
    public Optional<SubCategory> findSubCategories(String mainCategoryCode, String subCategoryCode) {
        return SUB_CATEGORIES.stream().filter(subCategory -> subCategory.getMainCategory().getCode().equals(mainCategoryCode) && subCategory.getCode().equals(subCategoryCode)).findAny();
    }

    @Override
    public List<SubCategory> findAllSubCategories() {
        return SUB_CATEGORIES;
    }


}
