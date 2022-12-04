package Utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil {
	Workbook wb;
	//constructor
	public ExcelFileUtil(String excelpath) throws Throwable {
		FileInputStream fi=new FileInputStream(excelpath);
		wb=WorkbookFactory.create(fi);
	}
	public int rowCount(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum();
	}
	public String getCellData(String sheetName,int row,int column) {
	String data=" ";
	if(wb.getSheet(sheetName).getRow(row).getCell(column).getCellType()==CellType.NUMERIC) {
		int celldata=(int)wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		data=String.valueOf(celldata);	
	}
	else {
		data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	return data;
	}
	public void setCellData(String sheetName,int row,int column,String status,String writeexcel) throws Throwable {
	Sheet ws=wb.getSheet(sheetName);//get sheet	
	Row rownum=ws.getRow(row);//get row from excel
	Cell cell=rownum.createCell(column);//creating cell in row
	cell.setCellValue(status);//writing the status in the cell
	if(status.equalsIgnoreCase("pass")) {
		CellStyle style=wb.createCellStyle();
		Font font=wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());//set green color
		font.setBold(true);
		//font.setBoldWeight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);
	
	}
	else if(status.equalsIgnoreCase("Fail")) {
		CellStyle style=wb.createCellStyle();
		Font font=wb.createFont();
		font.setColor(IndexedColors.RED.getIndex());//set green color
		font.setBold(true);
		//font.setBoldWeight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);
		
	}
	else if(status.equalsIgnoreCase("Blocked")){
		CellStyle style=wb.createCellStyle();
		Font font=wb.createFont();
		font.setColor(IndexedColors.BLUE.getIndex());//set green color
		font.setBold(true);
		//font.setBoldWeight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);
	}
	FileOutputStream fo =new FileOutputStream(writeexcel);
	wb.write(fo);
	
	}
}
