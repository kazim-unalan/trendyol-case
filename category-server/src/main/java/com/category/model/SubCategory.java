package com.category.model;

import com.category.model.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * @author Kazim Unalan
 */
@Entity
@Table(name = "sub_category")
public class SubCategory extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "main_category_oid")
    private MainCategory mainCategory;

    @Column(name = "product_code_list")
    private List<String> productCodeList;

    public SubCategory() {
    }

    public SubCategory(String code, String name, String header) {
        super(code, name, header);
    }

    public SubCategory(String code, String name, String header, MainCategory mainCategory) {
        super(code, name, header);
        this.mainCategory = mainCategory;
    }

    public SubCategory(String code, String name, String header, MainCategory mainCategory, List<String> productCodeList) {
        super(code, name, header);
        this.mainCategory = mainCategory;
        this.productCodeList = productCodeList;
    }

    public MainCategory getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(MainCategory mainCategory) {
        this.mainCategory = mainCategory;
    }
}
