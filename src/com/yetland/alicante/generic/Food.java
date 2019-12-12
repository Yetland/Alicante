package com.yetland.alicante.generic;

public class Food {
    private String foodName = "";

    public static Food make(Food... foods) {
        Food food = new Food();
        for (int i = 0; i < foods.length; i++) {
            food.setFoodName(food.getFoodName() + foods[i].getFoodName());
        }
        return food;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
