package maja_chaja_java_wroclaw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasketAnalyzer {
    private List<String> basket;
    private Map<String, List<String>> products;
    private Map<String, List<String>> basketAndDeliveryMethods;
    private List<String> deliveryMethods;
    private Map<String, List<String>> finalGroups;

    public BasketAnalyzer(List<String> basket, Map<String, List<String>> products) {
        this.basket = basket;
        this.products = products;
        basketAndDeliveryMethods = new HashMap<>();
        deliveryMethods = new ArrayList<>();
        finalGroups = new HashMap<>();
    }

    public Map<String, List<String>> analyze() {
        getBasketDeliveryMethods();
        if (basketAndDeliveryMethods.isEmpty()) {
            System.out.println("No basket delivery methods found");
            return null;
        }

        extractDeliveryMethods();
        if (deliveryMethods.isEmpty()) {
            System.out.println("No delivery methods found");
            return null;
        }

        finalGroups = findOptimalGroups();

        return finalGroups;

    }


    // This method extracts the delivery methods for each product in the basket from the products map
    // obtained from the JSON file

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


    // This method extracts all unique delivery methods from the basketAndDeliveryMethods map

    private void extractDeliveryMethods() {
        for (Map.Entry<String, List<String>> entry : basketAndDeliveryMethods.entrySet()) {
            for (String deliveryMethod : entry.getValue()) {
                if (!deliveryMethods.contains(deliveryMethod)) {
                    deliveryMethods.add(deliveryMethod);
                }
            }
        }
    }

    // This method finds the optimal groups of products for each delivery method

    private Map<String, List<String>> findOptimalGroups() {
        Set<String> ungroupedProducts = new HashSet<>(basket);
        while (!ungroupedProducts.isEmpty()) {
            String bestDeliveryMethod = null;
            int maxProductsCovered = 0;
            List<String> bestProducts = new ArrayList<>();

            for (String deliveryMethod : deliveryMethods) {
                Set<String> productsCovered = new HashSet<>();
                for (String product : ungroupedProducts) {
                    if (basketAndDeliveryMethods.get(product).contains(deliveryMethod)) {
                        productsCovered.add(product);

                    }
                }
                if (productsCovered.size() > maxProductsCovered) {
                    bestDeliveryMethod = deliveryMethod;
                    maxProductsCovered = productsCovered.size();
                    bestProducts = new ArrayList<>(productsCovered);
                }
            }
            if (!bestProducts.isEmpty()) {
                finalGroups.put(bestDeliveryMethod, bestProducts);
                ungroupedProducts.removeAll(bestProducts);

            }
        }
        return finalGroups;

    }
}
