package FileIO;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/7/27
 * @description 使用easypoi包对excel进行导入导出
 */
public class ExcelImExport {
    public void excelImport(String fileName) throws EncryptedDocumentException,IOException {
        if (fileName == null) {
            System.out.println("文件名有误或文件不存在！");
        }
        File excelFile = new File(fileName);
        if (!excelFile.exists()) {
            System.out.println("文件名有误或文件不存在");
        }
        //工作表
        Workbook workbook = WorkbookFactory.create(excelFile);
        //sheet数目
        int numOfSheets = workbook.getNumberOfSheets();
        if (numOfSheets <= 0) {
            System.out.println("没有sheet");
        }
        System.out.println("sheet number:\t" + numOfSheets);

        Sheet sheet = workbook.getSheetAt(0);
        // 行数
        int rowNumbers = sheet.getLastRowNum() + 1;
        System.out.println(rowNumbers);
        // 读数据，第二行开始读取
        for (int row = 1; row < rowNumbers; row++) {
            Row r = sheet.getRow(row);
            System.out.println(r.getPhysicalNumberOfCells());
            //我们只需要前两列
            if (r.getPhysicalNumberOfCells() >= 6) {
                System.out.println(r.getCell(0).toString());

            }
        }

    }

    private Workbook getReadWorkBookType(String filePath) throws IOException {
        //xls-2003, xlsx-2007
        FileInputStream is = null;

        try {
            is = new FileInputStream(filePath);
            if (filePath.toLowerCase().endsWith("xlsx")) {
                return new XSSFWorkbook(is);
            } else if (filePath.toLowerCase().endsWith("xls")) {
                return new HSSFWorkbook(is);
            } else {
                throw new IOException("excel格式文件错误");
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }


    public void testPrint(String fileName){
        System.out.println(fileName);
    }


    public static void main(String[] args) throws IOException {
        ExcelImExport excel = new ExcelImExport();
        String fileName="/Users/magicjaychen/Downloads/monthpay.xls";
//        excel.testPrint(fileName);
        excel.excelImport(fileName);
//        Workbook workbook=excel.getReadWorkBookType(fileName);
//        System.out.println("as the reds go marching on on on");
    }

}
