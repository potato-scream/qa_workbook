import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;

import java.util.zip.ZipEntry;

import java.util.zip.ZipInputStream;

public class FilesParsingTest {
    private final ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void zipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("sampleZip.zip"))) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }

    @Test
    void FileParsingFromZipTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("sampleZip.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("sampleZip/XlsFile.xls")) {
                    XLS xls = new XLS(zis);
                    String actualValue = xls.excel.getSheetAt(0).getRow(0).getCell(2).getStringCellValue();
                    Assertions.assertTrue(actualValue.contains("Last Name"));
                }

                if (entry.getName().equals("sampleZip/PdfFile.pdf")) {
                    PDF pdf = new PDF(zis);
                    Assertions.assertEquals("Philip Hutchison", pdf.author);
                }

                if (entry.getName().equals("sampleZip/CsvFile.csv")) {
                    try (CSVReader csvReader = new CSVReader(new InputStreamReader(zis))) {
                        List<String[]> data = csvReader.readAll();
                        Assertions.assertEquals(6, data.size());
                        Assertions.assertArrayEquals(new String[]{"Identifier", "First name", "Last name"}, data.get(0)[0].split(";"));
                        Assertions.assertArrayEquals(new String[]{"901242", "Rachel", "Booker"}, data.get(1)[0].split(";"));
                    }
                    return;
                }
            }
        }
    }
}