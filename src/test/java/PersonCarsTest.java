import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class PersonCarsTest {

    @Test
    public void testPersonCarsDeserialization() throws Exception {
        File jsonFile = new File(getClass().getClassLoader().getResource("PersonCars.json").getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(jsonFile, Person.class);
        assertEquals("John", person.getName());
        assertEquals(30, person.getAge());
        assertEquals(2, person.getCars().length);
        assertEquals("Ford", person.getCars()[0].getBrand());
        assertEquals("Q5", person.getCars()[1].getModel());
    }
}
