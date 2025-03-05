package filesParsing;

import com.codeborne.pdftest.PDF;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class PdfFileParsingTest {
    @Test
    void pdfFileParsingTest() throws Exception {
        final ClassLoader cl = PdfFileParsingTest.class.getClassLoader();
        boolean fileFound = false;
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("sampleZip.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if  (entry.getName().equals("sampleZip/PdfFile.pdf")) {
                    fileFound = true;
                    PDF pdf = new PDF(zis);
                    Assertions.assertEquals("Philip Hutchison", pdf.author);
                    break;
                }
            }
        }
        if (!fileFound) {
            Assertions.fail("File sampleZip/PdfFile.pdf not found in the zip archive.");
        }
    }
}

