package com.restaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.restaurant.entity.Meal;
import com.restaurant.mapper.MealMapper;
import com.restaurant.service.MealService;
import com.restaurant.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealMapper mealMapper;

    @Override
    public List<Meal> list(Meal meal) {
        QueryWrapper<Meal> queryWrapper = new QueryWrapper<>();
        if (meal != null && StringUtil.isNotEmpty(meal.getMealName())) {
            queryWrapper.eq("meal_name", meal.getMealName());
        }
        queryWrapper.eq("is_deleted", false);
        return mealMapper.selectList(queryWrapper);
    }

    @Override
    public int delete(String mealName) {
        QueryWrapper<Meal> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("meal_name", mealName);
        return mealMapper.delete(queryWrapper);
    }

    @Override
    public int insert(Meal meal) {
        meal.setIsDeleted(false);
        return mealMapper.insert(meal);
    }

    @Override
    public int update(Meal meal) {
        QueryWrapper<Meal> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("meal_name", meal.getMealName());
        return mealMapper.update(meal, queryWrapper);
    }

    @Override
    public boolean hasReferences(String mealName) {
        return mealMapper.countReferences(mealName) > 0;
    }

    @Override
    public int updateStatus(String mealName, boolean isDeleted) {
        return mealMapper.updateDeleteStatus(mealName, isDeleted);
    }

    @Override
    public Meal findByMealName(String mealName) {
        return mealMapper.findByMealName(mealName);
    }
}