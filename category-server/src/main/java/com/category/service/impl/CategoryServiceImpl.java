package com.category.service.impl;

import com.category.dao.CategoryDao;
import com.category.model.MainCategory;
import com.category.model.SubCategory;
import com.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Optional<MainCategory> getMainCategories(String mainCategoryCode) {
        return categoryDao.findMainCategories(mainCategoryCode);
    }

    @Override
    public List<MainCategory> getAllMainCategories() {
        return categoryDao.findAllMainCategories();
    }

    @Override
    public Optional<SubCategory> getSubCategories(String mainCategoryCode, String subCategoryCode) {
        return categoryDao.findSubCategories(mainCategoryCode, subCategoryCode);
    }

    @Override
    public List<SubCategory> getAllSubCategories() {
        return categoryDao.findAllSubCategories();

    }

}
