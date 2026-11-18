package IProduct;

/**
 *
 * @author Student
 */
public class ProductTest {

    // Fake data used only for testing (matching the assignment's numbers)
    int[][] testSales = {
        {25, 18, 20}, // Total 63 (Monarch)
        {15, 10, 12}, // Total 37 (Barbados)
        {18, 15, 20}  // Total 53 (Phuket)
    };
    String[] testNames = {"Product A", "Product B", "Product C"};
    
    // Creating the object once so both tests can use it
    Product testProduct = new Product(testSales, testNames);

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        // 63 + 37 + 53 = 153. I expect the method to return exactly 153 only.
        assertEquals(153, testProduct.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        // 153 total divided by 3 products = 51.0.
        assertEquals(51.0, testProduct.GetAverageProductSold(), 0.01);
    }
} 
