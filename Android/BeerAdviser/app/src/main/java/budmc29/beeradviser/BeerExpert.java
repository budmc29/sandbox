package budmc29.beeradviser;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    List<String> getBrands(String colour ) {
        List<String> brands = new ArrayList<String>();

        switch (colour) {
            case "light":
                brands.add("Jail Pale Ale");
                brands.add("Gout Stout");
                break;
            case "amber":
                brands.add("Jack Amber");
                brands.add("Red Rose");
                break;
            case "brown":
                brands.add("Gnarly Brown");
                brands.add("Brown Beard");
                break;
            case "dark":
                brands.add("Guiness");
                brands.add("Brasserie Dupont Monk's Stout");
                break;
        }

        return brands;
    }
}
