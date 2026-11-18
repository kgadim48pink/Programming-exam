package IProduct;

    private double calculateVAT(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

/**
 *
 * @author Student
 */
public class ProductCalculations {

    // The standard South African VAT rate is 15%
    private static final double VAT_RATE = 0.15;

    // Calculates the VAT amount for a given base price.
    // @return The calculated VAT amount.
    }

    // Calculates the commission amount based on a base amount and a percentage rate.
    // @return The calculated commission amount
    public double calculateCommission(double amount, double commissionPercentage) {
        return amount * (commissionPercentage / 100.0);
    }

     // Calculates the Total Sales amount (Base Price + VAT).
     // @return The final total including VAT.
    public double calculateTotalSales(double amount) {
        double vat = calculateVAT(amount);
        return amount + vat;
    }

    // The main method that tests the class
    public static void main(String[] args) {
        productCalculations calc = new productCalculations();

        double productPrice = 1000.00; 
        double commRate = 5.0;        

        double vat = calc.calculateVAT(productPrice);
        double commission = calc.calculateCommission(productPrice, commRate);
        double totalSales = calc.calculateTotalSales(productPrice);

        System.out.printf("Base Price:  R%.2f%n", productPrice);
        System.out.printf("VAT (15%%):   R%.2f%n", vat);
        System.out.printf("Commission:  R%.2f%n", commission);
        System.out.printf("Total Sales: R%.2f%n", totalSales);
    }
}
   
}
