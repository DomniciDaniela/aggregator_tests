package helpers.utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataArrayPool {

    public static ArrayList<ArrayList<String>> DataArray(String ExcelSheet) {
        boolean debug = true;

        ArrayList<ArrayList<String>> OUT = new ArrayList<ArrayList<String>>();
        File myFile = new File(Constants.INPUT_FILE);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = null;
        try {
            myWorkBook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet mySheet = null;

        switch (ExcelSheet) {
            case "TestConfig":
                // Return Consumer Spreadsheet
                mySheet = myWorkBook.getSheetAt(0);
                break;

            case "GoCompareMotorAggregator":
                // Return Consumer Spreadsheet
                mySheet = myWorkBook.getSheetAt(1);
                break;

            case "ConfusedHomeAggregator":
                // Return Consumer Spreadsheet
                mySheet = myWorkBook.getSheetAt(2);
                break;

            case "CardDetails":
                // Return Consumer Spreadsheet
                mySheet = myWorkBook.getSheetAt(3);
                break;
        }

        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();

        // Traversing over each row of XLSX file
        int count = 1;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            ArrayList<String> InnerArray = new ArrayList<String>();
            if (debug) System.out.print(count + ". \t");

            for (int cn = 0; cn < row.getLastCellNum(); cn++) {
                // If the cell is missing from the file, generate a blank one
                // (Works by specifying a MissingCellPolicy)
                Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        String c = cell.getStringCellValue();
                        if (debug) System.out.print(c + "\t");
                        InnerArray.add(c);
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        int n = (int) cell.getNumericCellValue();
                        if (debug) System.out.print(n + "\t");
                        InnerArray.add(String.valueOf(n));
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        boolean b = cell.getBooleanCellValue();
                        if (debug) System.out.print(b + "\t");
                        InnerArray.add(String.valueOf(b));
                    case Cell.CELL_TYPE_BLANK:
                        String z = "";
                        if (debug) System.out.print(z + "\t");
                        InnerArray.add(String.valueOf(z));
                        break;
                    case Cell.CELL_TYPE_ERROR:
                        String er = "ERROR";
                        if (debug) System.out.print(er + "\t");
                        InnerArray.add(String.valueOf(er));
                        break;
                    default:
                }

            }

            //Print out the row information once populated
            if (debug) System.out.println("");
            OUT.add(InnerArray);
            //Add a row count
            count++;
        }

        return OUT;
    }

}
