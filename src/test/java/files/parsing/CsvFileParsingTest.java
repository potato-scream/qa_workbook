package files.parsing;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CsvFileParsingTest {
    @Test
    void csvFileParsingTest() throws Exception {
        final ClassLoader cl = CsvFileParsingTest.class.getClassLoader();
        boolean fileFound = false;
        try (ZipInputStream zis = new ZipInputStream(cl.getResourceAsStream("sampleZip.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if(entry.getName().equals("sampleZip/CsvFile.csv")) {
                    fileFound = true;
                    try (CSVReader csvReader = new CSVReader(new InputStreamReader(zis))) {
                        List<String[]> data = csvReader.readAll();
                        Assertions.assertEquals(6, data.size());
                        Assertions.assertArrayEquals(new String[]{"Identifier", "First name", "Last name"}, data.get(0)[0].split(";"));
                        Assertions.assertArrayEquals(new String[]{"901242", "Rachel", "Booker"}, data.get(1)[0].split(";"));
                    }
                    break;
                }
            }
        }
        if (!fileFound) {
            Assertions.fail("File sampleZip/CsvFile.csv not found in the zip archive.");
        }
    }
}

