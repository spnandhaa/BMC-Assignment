package com.Data_Driven;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readerclass {

	static String value;

	public static String particulardata(String sheet, int row, int cell) throws Throwable {

		File f = new File(
				"C:\\Users\\Mobile Programming\\eclipse-workspace\\Assignment\\Datadriven\\ama MP.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi); // upcasting
		Sheet s = w.getSheet(sheet); // getsheetat(1) for index method
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		CellType ce = c.getCellType();
		if (ce.equals(CellType.STRING)) {
			// String se = c.getStringCellValue();
			// System.out.print(se);
			value = c.getStringCellValue();

		} else if (ce.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int n = (int) d;
			value = Integer.toString(n);

			System.out.print(n);
		}

		System.out.println("***************");
		return sheet;
	

	}

	public static void main(String[] args) throws Throwable {
		particulardata("Sheet 1", 1, 0);
	}

}