package com.example.athleticssports;

public class CategoryDetails {
    int categoryID;
    String CategoryType;

    public CategoryDetails(){

    }

    public CategoryDetails(int categoryID, String categoryType) {
        this.categoryID = categoryID;
        CategoryType = categoryType;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryType() {
        return CategoryType;
    }

    public void setCategoryType(String categoryType) {
        CategoryType = categoryType;
    }
}
