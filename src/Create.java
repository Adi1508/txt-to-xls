import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class Create {

	static int flag = 0;

	public void createXLS(String str, int counter, HSSFSheet sheet, HSSFWorkbook workbook) {

		String strArray[] = str.split(" ");
		System.out.println(strArray.length);
		
		for(int k=0;k<strArray.length;k++){
			strArray[k] = strArray[k].trim().replaceAll("#"," ");
		}

		try {
			String fileName = "D:/aditya_kumar/GeneratedExcelFiles/File"
					+ counter + ".xls";
			HSSFRow row = sheet.createRow(flag);

			for (int i = 0; i < strArray.length; i++) {
				row.createCell(i).setCellValue(strArray[i]);
				sheet.autoSizeColumn(i);
				FileOutputStream fout = new FileOutputStream(fileName);
				workbook.write(fout);
			}
			System.out.println("Excel file generated at the following path: "
					+ fileName);

		} catch (Exception e) {
			e.printStackTrace();
		}

		flag++;
	}
	
}
