package pwskills.beans;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pwskills.serialize.CustomBalanceSerializer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String accountNumber;
    private String bankName;

    @JsonSerialize(using = CustomBalanceSerializer.class)
    private BigDecimal balance;
}
