package com.restaurant.controller;

import com.restaurant.entity.Meal;
import com.restaurant.service.MealService;
import com.restaurant.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public ApiResponse<List<Meal>> list(Meal meal) {
        List<Meal> meals = mealService.list(meal);
        return ApiResponse.success(meals);
    }

    @GetMapping("/{id}")
    public ApiResponse<Meal> getById(@PathVariable Integer id) {
        Meal meal = mealService.findById(id);
        return ApiResponse.success(meal);
    }

    @PostMapping
    public ApiResponse<?> add(@RequestBody Meal meal) {
        int result = mealService.insert(meal);
        if (result > 0) {
            return ApiResponse.success("菜品添加成功", null);
        } else {
            return ApiResponse.error("菜品添加失败");
        }
    }

    @PutMapping("/{mealName}")
    public ApiResponse<?> update(@PathVariable String mealName, @RequestBody Meal meal) {
        meal.setMealName(mealName);
        int result = mealService.update(meal);
        if (result > 0) {
            return ApiResponse.success("菜品更新成功", null);
        } else {
            return ApiResponse.error("菜品更新失败");
        }
    }

    @DeleteMapping("/{mealName}")
    public ApiResponse<?> delete(@PathVariable String mealName) {
        // 检查是否有关联记录
        if (mealService.hasReferences(mealName)) {
            // 逻辑删除
            int result = mealService.updateStatus(mealName, true);
            if (result > 0) {
                return ApiResponse.success("菜品已标记为删除", null);
            } else {
                return ApiResponse.error("菜品标记删除失败");
            }
        } else {
            // 物理删除
            int result = mealService.delete(mealName);
            if (result > 0) {
                return ApiResponse.success("菜品删除成功", null);
            } else {
                return ApiResponse.error("菜品删除失败");
            }
        }
    }

    @GetMapping("/name/{mealName}")
    public ApiResponse<Meal> getByName(@PathVariable String mealName) {
        Meal meal = mealService.findByMealName(mealName);
        if (meal != null) {
            return ApiResponse.success(meal);
        } else {
            return ApiResponse.error("未找到该菜品");
        }
    }
}