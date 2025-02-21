import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class task3 {
    public static File tests;
    public static File values;


    public static void main(String [] args) throws IOException {
        //System.out.println(args[0]);
        //System.out.println(args[1]);
        tests = new File(args[0]);
        values = new File(args[1]);
        //System.out.println(tests.getAbsolutePath());

        ObjectMapper mapper = new ObjectMapper();
        valuesmanage vm = mapper.readValue(new FileInputStream(values), valuesmanage.class);
        testsmanage tm = mapper.readValue(new FileInputStream(tests), testsmanage.class);

        for (value v:vm.getValues()) {
            try {
                int id = v.getId();
                dtest t = tm.findTestById(id);
                t.setValue(v.getvalue());
            }catch (Exception e) {
                e.printStackTrace();
                v.show();
            }
        }
        String result = mapper.writeValueAsString(tm);
        //System.out.println(result);
        File report = new File("report.json");
        if (!report.exists()) {
            try {
                report.createNewFile();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileWriter fr = null;
        try {
            fr = new FileWriter(report);
            fr.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
