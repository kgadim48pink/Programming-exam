package IProduct;

/**
 *
 * @author Student
 */
public class ProductCalculationsTest {
    private ProductCalculations calculator;

    @BeforeEach
    void setUp() {
        calculator = new ProductCalculations();
    }

    @Test
    void testCalculateVat_StandardAmount() {
        double result = calculator.calculateVat(1000.00);
        assertEquals(150.00, result, 0.001, "VAT on 1000 at 15% should be 150");
    }

    @Test
    void testCalculateVat_ZeroAmount() {
        double result = calculator.calculateVat(0.00);
        assertEquals(0.00, result, 0.001, "VAT on 0 should be 0");
    }

    @Test
    void testCalculateVat_NegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateVat(-50.00);
        });
    }

    @Test
    void testCalculateCommission_StandardRate() {
        // 5% commission
        double result = calculator.calculateCommission(1000.00, 0.05); 
        assertEquals(50.00, result, 0.001, "5% commission on 1000 should be 50");
    }

    @Test
    void testCalculateTotalSales_ValidInputs() {
        // 1000 + VAT (150) + Commission at 10% (100) = 1250
        double result = calculator.calculateTotalSales(1000.00, 0.10);
        assertEquals(1250.00, result, 0.001, "Total sales should sum base, VAT, and commission");
    }
}
   
}
