import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class valuesmanage {
    public value[]values;

    @JsonCreator
    public valuesmanage(@JsonProperty("values")value[] values) {
        this.values = values;
    }


    public value[] getValues() {
        return values;
    }

    public void setValues(value[] values) {
        this.values = values;
    }

    @JsonIgnore
    public void show() {
        for (int i=0;i<values.length;i++) {
            value v = values[i];
            System.out.println("Value N "+i);
            v.show();
        }
    }
}
