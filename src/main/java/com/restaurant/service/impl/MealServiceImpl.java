package com.restaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.restaurant.entity.Meal;
import com.restaurant.exception.ResourceNotFoundException;
import com.restaurant.mapper.MealMapper;
import com.restaurant.service.MealService;
import com.restaurant.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MealServiceImpl implements MealService {

    private final MealMapper mealMapper;

    @Autowired
    public MealServiceImpl(MealMapper mealMapper) {
        this.mealMapper = mealMapper;
    }

    @Override
    public List<Meal> list(Meal meal) {
        LambdaQueryWrapper<Meal> queryWrapper = new LambdaQueryWrapper<>();
        if (meal != null && StringUtil.isNotEmpty(meal.getMealName())) {
            queryWrapper.eq(Meal::getMealName, meal.getMealName());
        }
        queryWrapper.eq(Meal::getIsDeleted, false);
        return mealMapper.selectList(queryWrapper);
    }

    @Override
    public int delete(String mealName) {
        LambdaQueryWrapper<Meal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Meal::getMealName, mealName);
        return mealMapper.delete(queryWrapper);
    }

    @Override
    public int insert(Meal meal) {
        meal.setIsDeleted(false);
        return mealMapper.insert(meal);
    }

    @Override
    public int update(Meal meal) {
        LambdaQueryWrapper<Meal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Meal::getMealName, meal.getMealName());
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

    @Override
    public Meal findById(Integer id) {
        Meal meal = mealMapper.selectById(id);
        if (meal == null) {
            throw new ResourceNotFoundException("Meal", "id", id);
        }
        return meal;
    }
}