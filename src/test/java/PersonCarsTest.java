import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;
import org.junit.jupiter.api.Test;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class PersonCarsTest {

    @Test
    public void testPersonCarsDeserialization() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("PersonCars.json");
        assertNotNull(inputStream, "Не удалось найти файл PersonCars.json в classpath");
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(inputStream, Person.class);
        assertEquals("John", person.getName());
        assertEquals(30, person.getAge());
        assertEquals(2, person.getCars().length);
        assertEquals("Ford", person.getCars()[0].getBrand());
        assertEquals("Q5", person.getCars()[1].getModel());
    }
}
