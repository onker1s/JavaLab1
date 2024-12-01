

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            InstantiationException, IllegalAccessException {

       try {

           Class cocktails = Class.forName("Dishes.Cocktail.Cocktail");
           Class desserts = Class.forName("Dishes.Dessert.Dessert");
           Class sandwichs = Class.forName("Dishes.Sandwich.Sandwich");

        List<Object> cocktailsArr = new ArrayList<>();
        List<Object> dessertArr = new ArrayList<>();
        List<Object> sandwichArr = new ArrayList<>();

        boolean n = true;
        int choise;
        Scanner in = new Scanner(System.in);

        while(n)
        {
            System.out.println("Выбери продукт для своего завтрака:\n"+
                    "1) Сэндвич\n" +
                    "2) Дессерт\n" +
                    "3) Коктейль\n"+
                    "0) Законить сборку\n");
            choise = in.nextInt();
            switch (choise){
                case 0:
                    n = false;
                    continue;
                case 1:
                    sandwichArr.add(sandwichs.newInstance());
                    break;
                case 2:
                    dessertArr.add(desserts.newInstance());

                    break;
                case 3:
                    cocktailsArr.add(cocktails.newInstance());

                    break;
                default:
                    System.out.println("Нет такого продукта");
                    break;
            }

        }

        Method calculateCaloricC = cocktails.getMethod("calculateCalories");
        Method calculateCaloricD = desserts.getMethod("calculateCalories");
        Method calculateCaloricS = sandwichs.getMethod("calculateCalories");

        Method getComponentToCompareD = desserts.getMethod("getComponentToCompare");
        Method getComponentToCompareS = sandwichs.getMethod("getComponentToCompare");

        Method searchDublicateC = cocktails.getMethod("searchDublicate", List.class);
           Method searchDublicateD = desserts.getMethod("searchDublicate", List.class);
           Method searchDublicateS = sandwichs.getMethod("searchDublicate", List.class);

        int temp = 0;
        for(String i : args) {
            if(i.equals("-calories")) {
                for(Object curr : cocktailsArr)
                {
                    temp += (int) calculateCaloricC.invoke(curr);
                }
                for(Object curr : sandwichArr)
                {
                    temp += (int) calculateCaloricS.invoke(curr);
                }
                for(Object curr : dessertArr)
                {
                    temp += (int) calculateCaloricD.invoke(curr);
                }
                System.out.println("Калорийность завтрака = " + temp);
            }

            if(i.equals("-sort"))
            {
               Collections.sort(cocktailsArr, new Comparator<Object>()
               {
                   @Override
                   public int compare(Object o1, Object o2)
                   {
                       try {
                           return -1*((int) calculateCaloricC.invoke(o1) - (int) calculateCaloricC.invoke(o2));
                       } catch (Exception e) {
                           e.printStackTrace();
                           return 0;
                       }
                   }
               });
                Collections.sort(sandwichArr, new Comparator<Object>()
                {
                    @Override
                    public int compare(Object o1, Object o2)
                    {
                        try {
                            return ((int) getComponentToCompareS.invoke(o1) - (int) getComponentToCompareS.invoke(o2));
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 0;
                        }
                    }
                });
                Collections.sort(dessertArr, new Comparator<Object>()
                {
                    @Override
                    public int compare(Object o1, Object o2)
                    {
                        try {
                            return -1*((int) getComponentToCompareD.invoke(o1) - (int) getComponentToCompareD.invoke(o2));
                        } catch (Exception e) {
                            e.printStackTrace();
                            return 0;
                        }
                    }
                });
            }
        }
        System.out.printf("Съедено: ");

           if(!cocktailsArr.isEmpty()) {
               System.out.println(searchDublicateC.invoke(cocktailsArr.get(0), cocktailsArr));
           }

        if(!sandwichArr.isEmpty()){
            System.out.println(searchDublicateS.invoke(sandwichArr.get(0), sandwichArr));
        }

        if(!dessertArr.isEmpty()){
            System.out.println(searchDublicateD.invoke(dessertArr.get(0), dessertArr));
        }

       } catch(ClassNotFoundException e){
           System.out.println("Данный класс не существует");
           e.printStackTrace();
       } catch (NoSuchMethodException e){
           System.out.println("Данный метод не существует");
           e.printStackTrace();
       }

    }
}