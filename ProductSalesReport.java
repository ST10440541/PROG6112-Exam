/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO T495
 */
public class ProductSalesReport {
    public static void main(String[] args) {
        int[][] productSales = {
            {300, 150, 700},  // Year 1
            {250, 200, 600}   // Year 2
        };
        
    //(GeekforGeeks , 2025)
        ProductSales salesAnalyzer = new ProductSales();
        

        salesAnalyzer.displaySalesData(productSales);
        
    
        salesAnalyzer.generateReport(productSales, 2025);
        
 
        displayDetailedAnalysis(salesAnalyzer, productSales);
    }
    
    private static void displayDetailedAnalysis(ProductSales analyzer, int[][] salesData) {
        System.out.println("\nDETAILED ANALYSIS");
        System.out.println("----------------------------------------");
        
     
        for (int year = 0; year < salesData.length; year++) {
            int yearlyTotal = 0;
            for (int quarter = 0; quarter < salesData[year].length; quarter++) {
                yearlyTotal += salesData[year][quarter];
            }
            System.out.printf("Year %d Total: %d%n", year + 1, yearlyTotal);
        }
        

        System.out.println("\nQuarterly Analysis:");
        for (int quarter = 0; quarter < salesData[0].length; quarter++) {
            int quarterTotal = 0;
            for (int year = 0; year < salesData.length; year++) {
                quarterTotal += salesData[year][quarter];
            }
            double quarterAverage = (double) quarterTotal / salesData.length;
            System.out.printf("Quarter %d Average: %.1f%n", quarter + 1, quarterAverage);
        }
    }
}