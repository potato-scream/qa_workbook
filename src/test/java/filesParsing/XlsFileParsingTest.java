package filesParsing;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class XlsFileParsingTest {
    @Test
    void xlsFileParsingTest() throws Exception {
        final ClassLoader cl = XlsFileParsingTest.class.getClassLoader();
        boolean fileFound = false;
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("sampleZip.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("sampleZip/XlsFile.xls")) {
                    fileFound = true;
                    HSSFWorkbook xls = new HSSFWorkbook(zis);
                    HSSFSheet sheet = xls.getSheetAt(0);
                    HSSFRow row = sheet.getRow(0);
                    HSSFCell cell = row.getCell(2);
                    String actualValue = cell.getStringCellValue();
                    Assertions.assertTrue(actualValue.contains("Last Name"));
                    break;
                }
            }
        }
        if (!fileFound) {
            Assertions.fail("File sampleZip/XlsFile.xls not found in the zip archive.");
        }
    }
}

