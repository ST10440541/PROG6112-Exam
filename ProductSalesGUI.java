/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesgui;

/**
 *
 * @author LENOVO T495
 */
//(Edureka, 2025)
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSalesGUI extends JFrame {
    private JTextArea textArea;
    private JLabel totalSalesLabel, averageSalesLabel, overLimitLabel, underLimitLabel, yearsProcessedLabel;
    private List<int[]> salesData;
    private final int SALES_LIMIT = 500;
    
    public ProductSalesGUI() {
        setTitle("Product Sales Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);
        
        salesData = new ArrayList<>();
        initializeComponents();
        layoutComponents();
        
        
        loadSampleData();
        updateDisplay();
    }
    //(deranch,2018)
    private void initializeComponents() {
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu testMenu = new JMenu("Test"); 
        
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        
        
        JMenuItem runTestsItem = new JMenuItem("Run Unit Tests");
        JMenuItem totalSalesTestItem = new JMenuItem("Test Total Sales");
        JMenuItem averageSalesTestItem = new JMenuItem("Test Average Sales");
        JMenuItem allTestsItem = new JMenuItem("Run All Tests");
        
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        
        testMenu.add(runTestsItem);
        testMenu.add(totalSalesTestItem);
        testMenu.add(averageSalesTestItem);
        testMenu.addSeparator();
        testMenu.add(allTestsItem);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(testMenu); 
        setJMenuBar(menuBar);
        
       
        JButton loadButton = new JButton("Load Product Data");
        JButton saveButton = new JButton("Save Product Data");
        JButton printButton = new JButton("Print");
        JButton listButton = new JButton("List");
        JButton runTestsButton = new JButton("Run Tests"); // New Test button
        
        
        textArea = new JTextArea(15, 50);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        
        totalSalesLabel = new JLabel("Total Sales: 0");
        averageSalesLabel = new JLabel("Average Sales: 0");
        overLimitLabel = new JLabel("Sales over limit: 0");
        underLimitLabel = new JLabel("Sales under limit: 0");
        yearsProcessedLabel = new JLabel("Years Processed: 0");
        
        
        loadButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                loadProductData();
            }
        });
        
        saveButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                saveProductData();
            }
        });
        
        loadItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                loadProductData();
            }
        });
        
        saveItem.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                saveProductData();
            }
        });
        
        printButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                printData();
            }
        });
        
        listButton.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
                listData();
            }
        });
        
        
        runTestsButton.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                runUnitTests();
            }
        });
        
        runTestsItem.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                runUnitTests();
            }

            private void runUnitTests() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        totalSalesTestItem.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
                testTotalSales();
            }
        });
        
        averageSalesTestItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testAverageSales();
            }
        });
        
        allTestsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runAllTests();
            }
        });
        
        //(GeeksforGeeks, 2025)
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(printButton);
        buttonPanel.add(listButton);
        buttonPanel.add(runTestsButton); // Add test button
        
        JPanel statsPanel = new JPanel(new GridLayout(2, 3, 10, 5));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Sales Statistics"));
        statsPanel.add(totalSalesLabel);
        statsPanel.add(averageSalesLabel);
        statsPanel.add(overLimitLabel);
        statsPanel.add(underLimitLabel);
        statsPanel.add(yearsProcessedLabel);
        
       
        setLayout(new BorderLayout(10, 10));
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(statsPanel, BorderLayout.SOUTH);
        
        
        JLabel footerLabel = new JLabel("Institute of Education (Pty) Ltd 2025", JLabel.CENTER);
        add(footerLabel, BorderLayout.PAGE_END);
    }
    
    private void layoutComponents() {
        
    }
    
    private void loadSampleData() {
      
        salesData.clear();
        salesData.add(new int[]{300, 150, 700}); // Year 1: Microphone, Speakers, Mixing Desk
        salesData.add(new int[]{250, 200, 600}); // Year 2: Microphone, Speakers, Mixing Desk
    }
    
    private void updateDisplay() {
       
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s %-12s %-12s %-12s\n", "", "Microphone", "Speakers", "Mixing Desk"));
        sb.append("------------------------------------------------------------\n");
        
        for (int i = 0; i < salesData.size(); i++) {
            int[] yearData = salesData.get(i);
            sb.append(String.format("Sales for year %-2d %-12d %-12d %-12d\n", 
                i + 1, yearData[0], yearData[1], yearData[2]));
        }
        
        textArea.setText(sb.toString());
        
    
        calculateStatistics();
    }
    
    private void calculateStatistics() {
        int totalSales = 0;
        int totalEntries = 0;
        int overLimit = 0;
        int underLimit = 0;
        
        for (int[] yearData : salesData) {
            for (int sales : yearData) {
                totalSales += sales;
                totalEntries++;
                if (sales > SALES_LIMIT) {
                    overLimit++;
                } else {
                    underLimit++;
                }
            }
        }
        
        double averageSales = totalEntries > 0 ? (double) totalSales / totalEntries : 0;
        
        totalSalesLabel.setText("Total Sales: " + totalSales);
        averageSalesLabel.setText(String.format("Average Sales: %.0f", averageSales));
        overLimitLabel.setText("Sales over limit: " + overLimit);
        underLimitLabel.setText("Sales under limit: " + underLimit);
        yearsProcessedLabel.setText("Years Processed: " + salesData.size());
    }
    
    private void loadProductData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                salesData.clear();
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        int[] yearData = new int[3];
                        for (int i = 0; i < 3; i++) {
                            yearData[i] = Integer.parseInt(parts[i].trim());
                        }
                        salesData.add(yearData);
                    }
                }
                updateDisplay();
                JOptionPane.showMessageDialog(this, "Product data loaded successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error loading file: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //TutorialsPoint was used for brainstorming
    private void saveProductData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                for (int[] yearData : salesData) {
                    writer.println(yearData[0] + "," + yearData[1] + "," + yearData[2]);
                }
                JOptionPane.showMessageDialog(this, "Product data saved successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void printData() {
        try {
            textArea.print();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error printing: " + ex.getMessage(), 
                "Print Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listData() {
        StringBuilder listInfo = new StringBuilder();
        listInfo.append("=== PRODUCT SALES LISTING ===\n");
        listInfo.append("Sales Limit: ").append(SALES_LIMIT).append("\n");
        listInfo.append("Products: Microphone, Speakers, Mixing Desk\n");
        listInfo.append("Years Processed: ").append(salesData.size()).append("\n\n");
        listInfo.append(textArea.getText());
        
        JTextArea listArea = new JTextArea(listInfo.toString());
        listArea.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(listArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        
        JOptionPane.showMessageDialog(this, scrollPane, "Product Sales Listing", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
  