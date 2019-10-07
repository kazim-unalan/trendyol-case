package com.category.model;

import com.category.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Kazim Unalan
 */
@Entity
@Table(name = "main_category")
public class MainCategory extends BaseEntity {

//    @OneToMany(mappedBy = "main_category", cascade = CascadeType.ALL)
//    private List<SubCategory> subCategoryOid;

    public MainCategory() {
    }

    public MainCategory(String code, String name, String header) {
        super(code, name, header);
    }

}
