public class task1 {
    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        cycle cyc = new cycle(n, m);

        do {
            cyc.getStep();
        }while(!cyc.isOnTheStart());
        System.out.println(cyc.getResult());
    }
}
