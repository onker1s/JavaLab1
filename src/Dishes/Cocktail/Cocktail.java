package Dishes.Cocktail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Components.Component;
import Components.Drink.*;
import Dishes.Nutritions;

public class Cocktail implements Nutritions {

    private Component drink;
    private Component fruit;
    private String name;

    public Cocktail()
    {
        System.out.println(
                        "1. Кола     1. Лимон\n" +
                        "2. Фанта    2. Апельсин\n" +
                        "3. Спрайт   3. Яблоко\n" +
                        "Выберете напиток для коктейля из списка:\n");
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        if(n > 3){
            while(n>3)
            {
                n= in.nextInt();
            }
        }
        switch (n)
        {
            case (1):
                drink = new Cola();
                break;
            case(2):
                drink = new Fanta();
                break;
            case(3):
                drink = new Sprite();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }
        System.out.println("Выберете фрукт для коктейля из списка");
        n = in.nextInt();
        if(n > 3){
            while(n>3)
            {
                n= in.nextInt();
            }
        }
        switch (n)
        {
            case (1):
                fruit = new Lemon();
                break;
            case(2):
                fruit = new Orange();
                break;
            case(3):
                fruit = new Apple();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }

        name = "Коктейль("+drink.getName()+","+fruit.getName()+")";
    }

    public void setCocktail()
    {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println( "1. Кола     1. Лимон\n" +
                        "2. Фанта    2. Апельсин\n" +
                        "3. Спрайт   3. Яблоко\n" +
                        "Выберете напиток для коктейля из списка:\n");
        n = in.nextInt();
        switch (n)
        {
            case (1):
                drink = new Cola();
                break;
            case(2):
                drink = new Fanta();
                break;
            case(3):
                drink = new Sprite();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }
        System.out.println("Выберете фрукт для коктейля из списка");
        n = in.nextInt();
        switch (n)
        {
            case (1):
                fruit = new Lemon();
                break;
            case(2):
                fruit = new Orange();
                break;
            case(3):
                fruit = new Apple();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }
        name = "Коктейль("+drink.getName()+","+fruit.getName()+")";
    }

    public String getName()
    {return name;}

    public Map<String,Long> searchDublicate(List<Object> arr)
    {
        Map<String, Long> resultMap = new HashMap<>();
        for (Object element : arr) {
            Cocktail temp = (Cocktail) element;
            if (resultMap.containsKey(temp.getName())) {
                resultMap.put(temp.getName(), resultMap.get(temp.getName()) + 1L);
            } else {
                resultMap.put(temp.getName(), 1L);
            }
        }
        return resultMap;
    }



    @Override
    public int calculateCalories() {
         return drink.getCaloric()+fruit.getCaloric();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Cocktail cocktail = (Cocktail) obj;
        return drink.equals(cocktail.drink) && fruit.equals(cocktail.fruit);
    }
}
