/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LENOVO T495
 */


public class ProductSalesTest {
    
    private ProductSales productSales = new ProductSales();
    
    // Test data from the requirements
    private final int[][] SAMPLE_SALES_DATA = {
        {300, 150, 700},  // Year 1
        {250, 200, 600}   // Year 2
    };
    
    // Test: CalculateTotalSales_ReturnsTotalSales
    
    public void CalculateTotalSales_ReturnsTotalSales() {
        // Arrange
        int expectedTotal = 2200; // 300+150+700+250+200+600 = 2200
        
        // Act
        int actualTotal = productSales.TotalSales(SAMPLE_SALES_DATA);
        
        // Assert
        assertEquals("Total sales should be 2200", expectedTotal, actualTotal);
    }
    
    // Test: CalculateAverageSales_ReturnsAverageSales
   
    public void CalculateAverageSales_ReturnsAverageSales() {
        // Arrange
        double expectedAverage = 366.666; // 2200 / 6 = 366.666...
        double delta = 0.001; // Tolerance for floating point comparison
        
        // Act
        double actualAverage = productSales.AverageSales(SAMPLE_SALES_DATA);
        
        // Assert
        assertEquals("Average sales should be approximately 366.667", 
                    expectedAverage, actualAverage, delta);
    }
    
    // Additional comprehensive tests
    
    
    public void CalculateTotalSales_WithEmptyArray_ReturnsZero() {
        // Arrange
        int[][] emptyData = {};
        
        // Act
        int result = productSales.TotalSales(emptyData);
        
        // Assert
        assertEquals("Total sales with empty array should be 0", 0, result);
    }
    
    
    public void CalculateAverageSales_WithEmptyArray_ReturnsZero() {
        // Arrange
        int[][] emptyData = {};
        
        // Act
        double result = productSales.AverageSales(emptyData);
        
        // Assert
        assertEquals("Average sales with empty array should be 0", 0.0, result, 0.001);
    }
    
    
    public void CalculateTotalSales_WithNullArray_ReturnsZero() {
        // Arrange
        int[][] nullData = null;
        
        // Act
        int result = productSales.TotalSales(nullData);
        
        // Assert
        assertEquals("Total sales with null array should be 0", 0, result);
    }
    
    
    public void CalculateAverageSales_WithNullArray_ReturnsZero() {
        // Arrange
        int[][] nullData = null;
        
        // Act
        double result = productSales.AverageSales(nullData);
        
        // Assert
        assertEquals("Average sales with null array should be 0", 0.0, result, 0.001);
    }
    
    
    public void CalculateTotalSales_WithSingleValue_ReturnsCorrectTotal() {
        // Arrange
        int[][] singleData = {{100}};
        
        // Act
        int result = productSales.TotalSales(singleData);
        
        // Assert
        assertEquals("Total sales with single value should be 100", 100, result);
    }
    
    
    public void CalculateAverageSales_WithSingleValue_ReturnsCorrectAverage() {
        // Arrange
        int[][] singleData = {{100}};
        
        // Act
        double result = productSales.AverageSales(singleData);
        
        // Assert
        assertEquals("Average sales with single value should be 100", 100.0, result, 0.001);
    }
    
    
    public void CalculateTotalSales_WithNegativeValues_ReturnsCorrectTotal() {
        // Arrange
        int[][] negativeData = {{-100, 200}, {-50, 150}};
        
        // Act
        int result = productSales.TotalSales(negativeData);
        
        // Assert
        assertEquals("Total sales with negative values should be correct", 200, result);
    }
    
    
    public void CalculateAverageSales_WithNegativeValues_ReturnsCorrectAverage() {
        // Arrange
        int[][] negativeData = {{-100, 200}, {-50, 150}};
        
        // Act
        double result = productSales.AverageSales(negativeData);
        
        // Assert
        assertEquals("Average sales with negative values should be correct", 50.0, result, 0.001);
    }
    
    
    public void CalculateMaxSale_ReturnsMaximumSale() {
        // Arrange
        int expectedMax = 700;
        
        // Act
        int actualMax = productSales.MaxSale(SAMPLE_SALES_DATA);
        
        // Assert
        assertEquals("Maximum sale should be 700", expectedMax, actualMax);
    }
    
    
    public void CalculateMinSale_ReturnsMinimumSale() {
        // Arrange
        int expectedMin = 150;
        
        // Act
        int actualMin = productSales.MinSale(SAMPLE_SALES_DATA);
        
        // Assert
        assertEquals("Minimum sale should be 150", expectedMin, actualMin);
    }

    private void assertEquals(String maximum_sale_should_be_700, int expectedMax, int actualMax) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}