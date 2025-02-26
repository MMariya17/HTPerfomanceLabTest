import java.io.*;

public class cyrcle {
    private point centre;
    private float radius;
    private File file1;

    public cyrcle(File file1) {
        this.file1 = file1;
        try {readfromfile();} catch (IOException e) {e.printStackTrace();}
    }

    public void readfromfile() throws IOException {
        InputStream is = new FileInputStream(file1);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        int sep = line.indexOf(32);
        Float x = Float.parseFloat(line.substring(0, sep));
        Float y = Float.parseFloat(line.substring(sep+1));
        centre = new point(x, y);
        line = br.readLine();
        radius = Float.parseFloat(line);
        br.close();
    }

    public point getCentre() {
        return this.centre;
    }
    public float getRadius() {
        return this.radius;
    }
}
