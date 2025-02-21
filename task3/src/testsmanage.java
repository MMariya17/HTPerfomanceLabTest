import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class testsmanage {
    public dtest[]tests;

    @JsonCreator
    public testsmanage(@JsonProperty("tests")dtest[]tests) {
        this.tests = tests;
    }

    public dtest[] getTests() {
        return tests;
    }

    public void setTests(dtest[] tests) {
        this.tests = tests;
    }

    @JsonIgnore
    public dtest findTestById(int id) {
        dtest test = null;
        for (dtest t: tests) {
            //System.out.println(t.getId());
            if (t.getId()==id) {return t;} else {
                test = t.findTestById(id);
                if (test!=null) {
                    return test;
                }
            }
        }
        return test;
    }

    @JsonIgnore
    public void show() {
        for (int i = 0; i<tests.length; i++) {
            dtest t = tests[i];
            System.out.println("===== "+i+"=========");
            t.show();
        }
    }
}
