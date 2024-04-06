package maja_chaja_java_wroclaw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BasketAnalyzer {
    private List<String> basket;
    private Map<String, List<String>> products;
    private Map<String, List<String>> basketAndDeliveryMethods;
    private List<String> deliveryMethods;
    private Map<String, List<String>> deliveryMap;
    private Map<String, List<String>> finalGroups;

    public BasketAnalyzer(List<String> basket, Map<String, List<String>> products) {
        this.basket = basket;
        this.products = products;
        basketAndDeliveryMethods = new HashMap<>();
        deliveryMethods = new ArrayList<>();
        deliveryMap = new HashMap<>();
        finalGroups = new HashMap<>();
    }

    public void analyze() {
        getBasketDeliveryMethods();
        if (basketAndDeliveryMethods.isEmpty()) {
            System.out.println("No basket delivery methods found");
            return;
        }
        
        //print basketanddelivery

        for (Map.Entry<String, List<String>> entry : basketAndDeliveryMethods.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.print("Values: ");
            for (String value : entry.getValue()) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
       
    }
    

    private void getBasketDeliveryMethods() {
        if (basket == null || products == null) {
            System.out.println("Basket or products are null");
            return;
        }
        for (String product : basket) {
            if (products.containsKey(product)) {
                basketAndDeliveryMethods.put(product, products.get(product));
            }
        }
    }
}
