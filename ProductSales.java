/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO T495
 */
public class ProductSales implements IProduct {
    
  
    public int TotalSales(int[][] productSales) {
        if (productSales == null || productSales.length == 0) {
            return 0;
        }
        
        int total = 0;
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                total += productSales[year][quarter];
            }
        }
        return total;
    }
    
  // (W3schools,2025)
    public double AverageSales(int[][] productSales) {
        if (productSales == null || productSales.length == 0) {
            return 0.0;
        }
        
        int total = TotalSales(productSales);
        int numberOfQuarters = 0;
        
        for (int year = 0; year < productSales.length; year++) {
            numberOfQuarters += productSales[year].length;
        }
        
        if (numberOfQuarters == 0) {
            return 0.0;
        }
        
        return (double) total / numberOfQuarters;
    }
    
    
    public int MaxSale(int[][] productSales) {
        if (productSales == null || productSales.length == 0) {
            return 0;
        }
        
        int max = productSales[0][0];
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                if (productSales[year][quarter] > max) {
                    max = productSales[year][quarter];
                }
            }
        }
        return max;
    }
    

    public int MinSale(int[][] productSales) {
        if (productSales == null || productSales.length == 0) {
            return 0;
        }
        
        int min = productSales[0][0];
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                if (productSales[year][quarter] < min) {
                    min = productSales[year][quarter];
                }
            }
        }
        return min;
    }
    
    public void displaySalesData(int[][] productSales) {
        System.out.println("PRODUCT SALES DATA");
        System.out.println("+---------+-----------+-----------+-----------+");
        System.out.println("|         | QUARTER 1 | QUARTER 2 | QUARTER 3 |");
        System.out.println("+---------+-----------+-----------+-----------+");
        
        for (int year = 0; year < productSales.length; year++) {
            System.out.printf("| YEAR %d  |", year + 1);
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                System.out.printf(" %-9d |", productSales[year][quarter]);
            }
            System.out.println();
        }
        System.out.println("+---------+-----------+-----------+-----------+");
    }
    
    public void generateReport(int[][] productSales, int reportYear) {
        System.out.println("\nPRODUCT SALES REPORT - " + reportYear);
        System.out.println("----------------------------------------");
        
        int total = TotalSales(productSales);
        double average = AverageSales(productSales);
        int max = MaxSale(productSales);
        int min = MinSale(productSales);
        
        System.out.println("Total sales: " + total);
        System.out.printf("Average sales: %.0f%n", average);
        System.out.println("Maximum sale: " + max);
        System.out.println("Minimum sale: " + min);
        System.out.println("\nif function (Pty) Ltd " + reportYear);
    }
}