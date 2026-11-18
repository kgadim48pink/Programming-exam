/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IProduct;

/**
 *
 * @author Student
 */
public class MattressSales {

    public static void main(String[] args) {
        // Mattress Model Name and Number of units sold
        Map<String, Integer> mattressSales = new HashMap<>();
        mattressSales.put("CloudRest Comfort (Single)", 15);
        mattressSales.put("Orthopedic Supreme (Double)", 28);
        mattressSales.put("Plushopedic Memory Foam (Queen)", 34);
        mattressSales.put("Luxury Crown (King)", 12);
        mattressSales.put("BudgetCoir Firm (Double)", 20);

        int totalProductsSold = 0;
        String mostPopularProduct = "";
        int highestSalesCount = -1;

        // Show/Display header
        System.out.println("==========================================");
        System.out.println("       LOCAL MATTRESS COMPANY REPORT      ");
        System.out.println("==========================================");
        System.out.println(String.format("%-32s | %s", "Mattress Model", "Units Sold"));
        System.out.println("------------------------------------------");

        // Display sales per product and calculate the total
        for (Map.Entry<String, Integer> entry : mattressSales.entrySet()) {
            String product = entry.getKey();
            int soldCount = entry.getValue();

            System.out.println(String.format("%-32s | %d", product, soldCount));

            // Accumulate total products sold
            totalProductsSold += soldCount;

            // Find the most popular product
            if (soldCount > highestSalesCount) {
                highestSalesCount = soldCount;
                mostPopularProduct = product;
            }
        }

        System.out.println("------------------------------------------");
        System.out.println("Total Number of Products Sold: " + totalProductsSold);
        System.out.println("Most Popular Product:          " + mostPopularProduct + " (" + highestSalesCount + " units)");
        System.out.println("==========================================");
    }
}
  

   
