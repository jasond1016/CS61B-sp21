package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int n = 1000;
        int x = 1;
        while (x <= 15) {
            Ns.addLast(n);
            opCounts.addLast(n);

            int m = n;
            AList<Integer> testObj = new AList<>();

            Stopwatch sw = new Stopwatch();
            while (m > 0) {
                testObj.addLast(m--);
            }
            times.addLast(sw.elapsedTime());

            n = n * 2;
            x++;
        }
        printTimingTable(Ns, times, opCounts);
    }
}
