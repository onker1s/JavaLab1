package Dishes.Dessert;

import java.util.Comparator;


public class DessertLongComparator implements Comparator<Dessert>
{
    @Override
    public int compare(Dessert o1, Dessert o2)
    {
        return (o1.getComponent1().getName().length() - o2.getComponent1().getName().length())*-1;
    }
}
