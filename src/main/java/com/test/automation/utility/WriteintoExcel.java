/**
 * 
 */
package com.test.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * @author GayaniGunawardhana
 *
 */
public class WriteintoExcel {

    public static void writeToExcel(double memoryUsage) {
        try {
            File file = new File("memory_usage_stats.xlsx");
            XSSFWorkbook workbook;
            XSSFSheet sheet;
            Row row;
            Cell cell;

            // If file does not exist, create a new workbook and sheet
            if (!file.exists()) {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Memory Usage Stats");
                // Create header row
                row = sheet.createRow(0);
                cell = row.createCell(0);
                cell.setCellValue("Memory Usage");
            }
            // If file exists, open the existing workbook and sheet
            else {
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
                // Find the next empty row in the sheet
                int lastRowNum = sheet.getLastRowNum();
                row = sheet.createRow(lastRowNum + 1);
            }

            // Create a new cell in the row and set its value
            cell = row.createCell(0);
            cell.setCellValue("Memory Usage");
            // Create a new cell in the row and set its value
            cell = row.createCell(1);
            cell.setCellValue(memoryUsage);

            // Write the workbook to a file
            FileOutputStream fileOut = new FileOutputStream("memory_usage_stats.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Memory usage stats written to Excel successfully!");
        } catch (IOException e) {
            System.out.println("Error writing memory usage stats to Excel: " + e.getMessage());
        }
    }
}
