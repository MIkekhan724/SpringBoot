package pwskills;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import pwskills.beans.Person;

import java.io.File;

public class Json2Java {
    public static void main(String[] args) throws  Exception {

        ObjectMapper mapper= new ObjectMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);

        Person person = mapper.readValue(new File("src/main/resources/person.json"), Person.class);
        System.out.println(person);
        System.out.println("Deserialization completed");

    }
}
