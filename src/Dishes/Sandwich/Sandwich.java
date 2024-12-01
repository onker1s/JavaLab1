package Dishes.Sandwich;

import Components.Component;
import Components.Sandwich.Beaffilling;
import Components.Sandwich.Fishfilling;
import Components.Sandwich.Veganfilling;
import Dishes.Cocktail.Cocktail;
import Dishes.Nutritions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Sandwich implements Nutritions
{

    private Component feeling1;
    private Component feeling2;
    private String name;

    public Sandwich(){
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println(
                "1. Мясная\n" +
                "2. Рыбная\n" +
                "3. Овощная\n" +
                        "Выберете первую начинку для сэндвича из списка:\n");
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
                feeling1 = new Beaffilling();
                break;
            case(2):
                feeling1 = new Fishfilling();
                break;
            case(3):
                feeling1 = new Veganfilling();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }
        System.out.println("Выберете вторую начинку для сэндвича из списка:\n");
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
                feeling2 = new Beaffilling();
                break;
            case(2):
                feeling2 = new Fishfilling();
                break;
            case(3):
                feeling2 = new Veganfilling();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }

        name = "Cэндвич("+feeling1.getName()+","+feeling2.getName()+")";
    }

    public void setSandwitch()
    {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Выберете две начинки для сэндвича из списка:\n" +
                "1. Мясная\n" +
                "2. Рыбная\n" +
                "3. Овощная\n");
        n = in.nextInt();
        switch (n)
        {
            case (1):
                feeling1 = new Beaffilling();
                break;
            case(2):
                feeling1 = new Fishfilling();
                break;
            case(3):
                feeling1 = new Veganfilling();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }
        n = in.nextInt();
        switch (n)
        {
            case (1):
                feeling2 = new Beaffilling();
                break;
            case(2):
                feeling2 = new Fishfilling();
                break;
            case(3):
                feeling2 = new Veganfilling();
                break;
            default:
                System.out.println("Нет такого варианта");
                break;
        }
        name = "Cэндвич("+feeling1.getName()+","+feeling2.getName()+")";
    }

    public Component getFeeling1()
    {
        return feeling1;
    }

    public Component getFeeling2()
    {
        return feeling2;
    }

    public int getComponentToCompare() {
        return feeling1.getName().length();
    }

    public String getName()
    {return name;}

    public Map<String,Long> searchDublicate(List<Object> arr)
    {
        Map<String, Long> resultMap = new HashMap<>();
        for (Object element : arr) {
            Sandwich temp = (Sandwich) element;
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
        return feeling1.getCaloric() + feeling2.getCaloric();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Sandwich sandwich = (Sandwich) obj;
        return feeling1.equals(sandwich.feeling1) && feeling2.equals(sandwich.feeling2);
    }

}
