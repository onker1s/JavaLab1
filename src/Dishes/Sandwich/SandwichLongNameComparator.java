package Dishes.Sandwich;

import java.util.Comparator;


public class SandwichLongNameComparator implements Comparator<Sandwich>
{
    @Override
    public int compare(Sandwich o1, Sandwich  o2)
    {
        return o1.getFeeling1().getName().length() - o2.getFeeling1().getName().length();
    }
}

