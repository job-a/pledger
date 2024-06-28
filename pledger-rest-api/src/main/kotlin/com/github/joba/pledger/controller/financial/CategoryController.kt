package com.github.joba.pledger.controller.financial

import com.github.joba.pledger.entity.financial.Category
import com.github.joba.pledger.service.financial.CategoryService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
class CategoryController(private val categoryService: CategoryService) {

    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    fun getCategory(): List<Category> {
        return categoryService.getAllCategories().toList()
    }

    @PostMapping(consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun createCategory(@RequestBody category: Category): Category {
        return categoryService.create(category)
    }

}