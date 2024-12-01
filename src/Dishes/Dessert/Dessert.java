package Dishes.Dessert;

import Components.Component;
import Components.Dessert.Chocolate;
import Components.Dessert.Cream;
import Components.Dessert.Strawberry;
import Dishes.Cocktail.Cocktail;
import Dishes.Nutritions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Dessert implements Nutritions {
    private Component component1;
    private Component component2;
    private String name;

    public Dessert() {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("1. Клубника\n" +
                "2. Сливки\n" +
                "3. Шоколад\n" +
                "Выберете первый компонент десерта из списка:\n" );

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
                component1 = new Strawberry();
                break;
            case(2):
                component1 = new Cream();
                break;
            case(3):
                component1 = new Chocolate();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }
        System.out.println( "Выберете второй компонент десерта из списка:\n");
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
                component2 = new Strawberry();
                break;
            case(2):
                component2 = new Cream();
                break;
            case(3):
                component2 = new Chocolate();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }

        name = "Дессерт("+component1.getName()+","+component2.getName()+")";
    }

    public void setDessert()
    {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Выберете первый и второй компонент десерта из списка:\n" +
                "1. Клубника\n" +
                "2. Сливки\n" +
                "3. Шоколад\n");
        n = in.nextInt();
        switch (n)
        {
            case (1):
                component1 = new Strawberry();
                break;
            case(2):
                component1 = new Cream();
                break;
            case(3):
                component1 = new Chocolate();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }
        n = in.nextInt();
        switch (n)
        {
            case (1):
                component2 = new Strawberry();
                break;
            case(2):
                component2 = new Cream();
                break;
            case(3):
                component2 = new Chocolate();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }
        name = "Дессерт("+component1.getName()+","+component2.getName()+")";
    }

    public Component getComponent1() {
        return component1;
    }

    public Component getComponent2() {
        return component2;
    }

    public Map<String,Long> searchDublicate(List<Object> arr)
    {
        Map<String, Long> resultMap = new HashMap<>();
        for (Object element : arr) {
            Dessert temp = (Dessert) element;
            if (resultMap.containsKey(temp.getName())) {
                resultMap.put(temp.getName(), resultMap.get(temp.getName()) + 1L);
            } else {
                resultMap.put(temp.getName(), 1L);
            }
        }
        return resultMap;
    }

    public int getComponentToCompare() {

    return component1.getName().length();
    }
    public String getName()
    {return name;}

    @Override
    public int calculateCalories() {
        return component1.getCaloric()+component2.getCaloric();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Dessert dessert = (Dessert) obj;
        return component1.equals(dessert.component1) && component2.equals(dessert.component2);
    }
}
