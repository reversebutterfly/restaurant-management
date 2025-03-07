package com.restaurant.controller;

import com.restaurant.entity.Meal;
import com.restaurant.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public ResponseEntity<List<Meal>> list(Meal meal) {
        List<Meal> meals = mealService.list(meal);
        return ResponseEntity.ok(meals);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Meal meal) {
        int result = mealService.insert(meal);
        if (result > 0) {
            return ResponseEntity.ok().body("Meal added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add meal");
        }
    }

    @PutMapping("/{mealName}")
    public ResponseEntity<?> update(@PathVariable String mealName, @RequestBody Meal meal) {
        meal.setMealName(mealName);
        int result = mealService.update(meal);
        if (result > 0) {
            return ResponseEntity.ok().body("Meal updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update meal");
        }
    }

    @DeleteMapping("/{mealName}")
    public ResponseEntity<?> delete(@PathVariable String mealName) {
        if (mealService.hasReferences(mealName)) {
            int result = mealService.updateStatus(mealName, true);
            if (result > 0) {
                return ResponseEntity.ok().body("Meal marked as deleted");
            } else {
                return ResponseEntity.badRequest().body("Failed to mark meal as deleted");
            }
        } else {
            int result = mealService.delete(mealName);
            if (result > 0) {
                return ResponseEntity.ok().body("Meal deleted successfully");
            } else {
                return ResponseEntity.badRequest().body("Failed to delete meal");
            }
        }
    }
}