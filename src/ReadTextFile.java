import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadTextFile {

	public static final String FILENAME = "C:/Users/aditya.kumar/Desktop/workitems_test.txt";

	public static void main(String[] args) {

		BufferedReader br = null;
		FileReader fr = null;
		int counter = (int) (Math.random() * 10000000);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sheet1");
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				String after = currentLine.trim().replaceAll(" ", "#");
				String str2 = after.trim().replaceAll("\\s+"," ");
				Create obj = new Create();
				obj.createXLS(str2, counter, sheet, workbook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
