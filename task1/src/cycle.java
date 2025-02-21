public class cycle {
    private int m;
    private int [] mass;

    private int cur;

    private String result = "";

    public cycle(int n, int m) {
        this.m = m;
        mass = new int[n];
        for (int i=1; i<=n; i++) {
            mass[i-1]=i;
        }
        cur = mass[0];;
    }
    //moves to the next num in cycle
    public int getNext() {
        if (cur==mass.length) {
            cur = mass[0];
            return cur;
        }else {
            cur = mass[cur];
            return cur;
        }
    }
    //return current num
    public int getCurrent() {
        return cur;
    }
    //do m moves
    public int getStep() {
        result +=cur;
        //System.out.print(cur);
        for (int i=1;i<m;i++) {
            int next = getNext();
            //System.out.print(next);
        }
        //System.out.println();
        return cur;
    }
    public String getResult() {
        return result;
    }
    public boolean isOnTheStart() {
        return (getCurrent()==mass[0]);
    }
}

