package ua.lviv.lgs.money.service;

import ua.lviv.lgs.money.domain.Category;

import java.util.List;

public interface CategoryService {

    Category create(Category category);

    List<Category> findAll();
}
