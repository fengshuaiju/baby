package com.feng.baby.adapter.controller;

import com.feng.baby.application.command.AddCategoryCommand;
import com.feng.baby.application.representation.Category;
import com.feng.baby.application.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody AddCategoryCommand command){
        categoryService.addCategory(command.getPid(), command.getIcon(),
                command.getIndexs(), command.getLevel(), command.getName());
    }

    //商品类别无限级接口
    @GetMapping("/all-types")
    public List<Category> allTypes() {
        return categoryService.allTypes();
    }

    @GetMapping("/all")
    public List<Category> categoryAll() {
        return categoryService.all();
    }

}
