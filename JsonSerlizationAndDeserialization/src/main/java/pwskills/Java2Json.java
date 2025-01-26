package pwskills;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import pwskills.beans.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class Java2Json {

    public static void main(String[] args) throws  Exception{
        {
            Order ord1 = new Order(1234, "laptop", true, "good");
            Order ord2 = new Order(null, "mobile", false, "good");
            Order ord3 = new Order(2323, "", true, "good");

            List<Order> orderList = new ArrayList<>();
            orderList.add(ord1);
            orderList.add(ord2);
            orderList.add(ord2);

            Account account = new Account("123452435", "HDFC", new BigDecimal(12234));

            Person person = new Person("sachin", "tendulkar", "sachin@gmail.com", new Date(), orderList,
                    account);

            ObjectMapper mapper = new ObjectMapper();

            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

            //to remove not Null
            mapper.setSerializationInclusion(Include.NON_NULL);
            mapper.setSerializationInclusion(Include.NON_EMPTY);

            // To Write it as string
            String personAsString = mapper.writeValueAsString(person);
            System.out.println(personAsString);

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/person.json"), person);
            System.out.println("Serialization is completed...");
        }
    }
}
