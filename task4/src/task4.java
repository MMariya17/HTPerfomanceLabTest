import java.io.*;
import java.util.ArrayList;

public class task4 {
    private static ArrayList<Integer> mass = new ArrayList<>();

    public static void main(String [] args) throws IOException {
        File file = new File(args[0]);
        initializeMassive(file);

        int min = (getMinFromMass());
        int max = (getMaxFromMass());
        int minRes = Integer.MAX_VALUE;
        for (int i = min;i<=max; i++) {
            int res = (convertMass(i));
            if (res<minRes) {minRes = res;}
        }
        System.out.println(minRes);
    }

    private static void initializeMassive(File file) throws IOException {
        mass = new ArrayList<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while ((line=br.readLine())!=null) {
            try {
                mass.add(Integer.parseInt(line));
            }catch (Exception e) {
                System.out.println("\""+line+"\" is not integer!");
            }
        }
        br.close();
    }

    private static int getMinFromMass() {
        int min=Integer.MAX_VALUE;
        for (int k:mass) {
            if (k<min) {min = k;}
        }
        return min;
    }
    private static int getMaxFromMass() {
        int max=Integer.MIN_VALUE;
        for (int k:mass) {
            if (k>max) {max = k;}
        }
        return max;
    }

    private static double getMiddleFromMass() {
        double res = 0;
        int sum = 0;
        for (int k:mass) {
            sum+=k;
        }
        res = (double)sum/(double)mass.size();
        return res;
    }

    private static int convertMass(int target) {
        int result = 0;
        for (int i=0; i<mass.size();i++) {
            int val = mass.get(i);
            while (val!=target) {
                if (val<target) {
                    val = val+1;
                }else {
                    val = val-1;
                }
                result++;
            }
        }
        return result;
    }
}
