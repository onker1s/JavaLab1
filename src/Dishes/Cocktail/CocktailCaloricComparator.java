package Dishes.Cocktail;

import java.util.Comparator;


public class CocktailCaloricComparator implements Comparator<Cocktail>
{
 @Override
    public int compare(Cocktail o1, Cocktail o2)
 {
     return -1*(o1.calculateCalories()- o2.calculateCalories());
 }


}
