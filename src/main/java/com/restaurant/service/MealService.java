package com.restaurant.service;

import com.restaurant.entity.Meal;
import java.util.List;

public interface MealService {

    List<Meal> list(Meal meal);

    int delete(String mealName);

    int insert(Meal meal);

    int update(Meal meal);

    boolean hasReferences(String mealName);

    int updateStatus(String mealName, boolean isDeleted);

    Meal findByMealName(String mealName);

    Meal findById(Integer id);
}