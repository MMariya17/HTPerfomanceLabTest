import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class dtest {
    public int id;
    public String title;
    public String value;
    public dtest[]values;

    @JsonCreator
    public dtest(@JsonProperty("id")int id, @JsonProperty("title")String title, @JsonProperty("value")String value, @JsonProperty("values")dtest[]values) {
        this.id = id;
        this.title = title;
        this.value = value;
        this.values = values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public dtest[] getValues() {
        return values;
    }

    public void setValues(dtest[] values) {
        this.values = values;
    }

    @JsonIgnore
    public void show() {
        System.out.println("id:"+id);
        System.out.println("title:"+title);
        System.out.println("value:"+value);
        System.out.println("values:"+values);
    }

    @JsonIgnore
    public dtest findTestById(int id) {
        dtest test = null;
        if (this.id == id) {return this;}
        if (values!=null) {
            for (dtest t: values) {
                test = t.findTestById(id);
                if (test!=null) {return test;}
            }
        }
        return test;
    }
}
