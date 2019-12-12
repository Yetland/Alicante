package com.yetland.alicante.generic;

public class Cook {
    public static void main(String... args) {
        Chef chef = new Chef();
        Food food = chef.cook(new Egg(), new Tomato());
        Food food2 = chef.cookMeat(new Egg(), new Pork());
        System.out.print("\n foodName = " + food.getFoodName());
        System.out.print("\n foodName = " + food2.getFoodName());
        Chef.MeatChef<? super Meat> meatChef = new Chef.MeatChef<>();
        meatChef.cook2(new Pork());

        Plate<Apple> applePlate = new Plate<>();
        applePlate.setItem(new Apple());
        Plate<? extends Fruit> fruitPlate = applePlate;

        Plate<? super Fruit> plate = new Plate<>();
        plate.setItem(new Apple());
        Fruit fruit = (Fruit) plate.getItem();

        Apple apple = (Apple) fruitPlate.getItem();

        System.out.print(" \n fruitName = " + apple.getFoodName());
        Plate<? super Vegetable> meatPlate2 = new Plate<>();
        meatPlate2.setItem(new Tomato());
        meatPlate2.setItem(new RedTomato());


        RedTomato tomato = (RedTomato) meatPlate2.getItem();
        System.out.print("\n foodName = " + tomato.getFoodName());
    }
}
