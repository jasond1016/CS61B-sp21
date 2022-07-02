package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int n = 1000;
        int x = 1;
        int ops = 10000;
        while (x <= 8) {
            Ns.addLast(n);
            opCounts.addLast(ops);

            int m = n;
            SLList<Integer> testObj = new SLList<>();
            while (m > 0) {
                testObj.addLast(m--);
            }

            m = ops;
            Stopwatch sw = new Stopwatch();
            while (m > 0) {
                testObj.getLast();
                m--;
            }
            times.addLast(sw.elapsedTime());

            n = n * 2;
            x++;
        }
        printTimingTable(Ns, times, opCounts);
    }

}
