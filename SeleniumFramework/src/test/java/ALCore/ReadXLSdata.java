package ALCore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

	@DataProvider(name = "fcData")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String excelSheetName = m.getName();
		File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Test_Data.xlsx");

		// ****** Read/Write Text File ************//

		src.createNewFile(); // --->Create a new file 
		FileWriter fw = new FileWriter(src);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Test");
		bw.newLine();
		bw.write("test1");
		bw.close();
		FileReader fr = new FileReader(src);
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String content = "";
		if ((content = br.readLine()) != null) {
			System.out.println("Content::" + content);
		}
        //  ***********     end    ***********//
		System.out.println("SRC::" + src);
		FileInputStream in = new FileInputStream(src);
		Workbook book = WorkbookFactory.create(in);
		Sheet sheet = book.getSheet(excelSheetName);
		// Random rand= new Random();
		int totalRow = sheet.getLastRowNum();
		System.out.println("lastRow::" + totalRow);
		Row row = sheet.getRow(totalRow);
		int totalColums = row.getLastCellNum();
		System.out.println("totalColums::" + totalColums);
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRow][totalColums];
		for (int i = 1; i <= totalRow; i++) {
			for (int j = 0; j < totalColums; j++) {
				testData[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.println("testData[i - 1][j]::" + testData[i - 1][j]);

			}
		}
		return testData;

	}

}
