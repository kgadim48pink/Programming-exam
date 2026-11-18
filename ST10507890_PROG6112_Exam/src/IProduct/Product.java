package IProduct;

/**
 *
 * @author Student
 */
public class Product {
    private String[] productNames;
    private int[] quantitiesSold;

    // Initializing the product names and their corresponding sales
    public Product(String[] productNames, int[] quantitiesSold) {
        if (productNames.length != quantitiesSold.length) {
            throw new IllegalArgumentException("Product names and quantities must have the same length.");
        }
        this.productNames = productNames;
        this.quantitiesSold = quantitiesSold;
    }

    // A equation to get the total number of products sold
    public int getTotalProductsSold() {
        int total = 0;
        for (int quantity : quantitiesSold) {
            total += quantity;
        }
        return total;
    }

    // Calculating the average products sold
    public double calculateAverageSold() {
        if (quantitiesSold.length == 0) {
            return 0.0;
        }
        return (double) getTotalProductsSold() / quantitiesSold.length;
    }

    // Determining the most popular product
    public String getMostPopularProduct() {
        if (productNames.length == 0) {
            return "No products available";
        }

        int maxIndex = 0;
        for (int i = 1; i < quantitiesSold.length; i++) {
            if (quantitiesSold[i] > quantitiesSold[maxIndex]) {
                maxIndex = i;
            }
        }
        return productNames[maxIndex];
    }

    // Testing the class
    public static void main(String[] args) {
        String[] names = {"Laptop", "Mouse", "Keyboard", "Monitor"};
        int[] sales = {45, 120, 85, 60};

        Product storeProducts = new Product(names, sales);

        System.out.println("Total Products Sold: " + storeProducts.getTotalProductsSold());
        System.out.printf("Average Products Sold: %.2f%n", storeProducts.calculateAverageSold());
        System.out.println("Most Popular Product: " + storeProducts.getMostPopularProduct());
    }
}  
}
