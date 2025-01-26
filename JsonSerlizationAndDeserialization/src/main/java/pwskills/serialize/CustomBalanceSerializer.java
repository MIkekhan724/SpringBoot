package pwskills.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CustomBalanceSerializer extends JsonSerializer<BigDecimal> {

    @Override
    public  void serialize(BigDecimal balance, JsonGenerator gen, SerializerProvider serializer) throws IOException
    {
        DecimalFormat formatter= new DecimalFormat("#0.00");
        gen.writeString(formatter.format(balance));
    }
}
