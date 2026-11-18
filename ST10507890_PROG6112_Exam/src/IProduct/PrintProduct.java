package IProduct;

/**
 *
 * @author Student
 */
public class PrintProduct {
    
// It's responsible for displaying the report on the screen
public class PrintProduct {
    
    public void printTotalSales(Product product) {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageSales(Product product) {
        // Formats the decimal to show 0 at decimal places only
        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n", product.GetAverageProductSold());
    }

    public void printMostPopular(Product product) {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
