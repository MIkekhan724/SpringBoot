package pwskills.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pwskills.deserialize.CustomDateDeSerialization;
import pwskills.serialize.CustomDateSerialization;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = { "orders", "firstName", "emailId" })
@JsonRootName("person")
@JsonIgnoreProperties(value = "emailId")
public class Person {


    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private String emailId;

    @JsonSerialize(using= CustomDateSerialization.class)
    @JsonDeserialize(using = CustomDateDeSerialization.class)
    private Date dob;

    private List<Order> orders;

    private Account acoount;
}
