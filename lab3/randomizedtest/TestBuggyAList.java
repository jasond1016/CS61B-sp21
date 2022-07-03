package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> alist = new AListNoResizing<>();
      BuggyAList<Integer> buggyAList = new BuggyAList<>();

      alist.addLast(4);
      buggyAList.addLast(4);

      alist.addLast(4);
      buggyAList.addLast(4);

      alist.addLast(4);
      buggyAList.addLast(4);

      assertEquals(alist.size(), buggyAList.size());
      assertEquals(alist.removeLast(), buggyAList.removeLast());
      assertEquals(alist.removeLast(), buggyAList.removeLast());
      assertEquals(alist.removeLast(), buggyAList.removeLast());
    }

    @Test
    public void randomizedTest() {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> M = new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
        int operationNumber = StdRandom.uniform(0, 4);
        if (operationNumber == 0) {
          // addLast
          int randVal = StdRandom.uniform(0, 100);
          L.addLast(randVal);
          M.addLast(randVal);
        } else if (operationNumber == 1) {
          // size
          int sizeL = L.size();
          int sizeM = M.size();
          assertEquals(sizeL, sizeM);
        } else if (operationNumber == 2) {
          if (L.size() <= 0) {
            continue;
          }
          // getLast
          int lastL = L.getLast();
          int lastM = M.getLast();
          assertEquals(lastL, lastM);
        } else if (operationNumber == 3) {
          if (L.size() <= 0) {
            continue;
          }
          // removeLast
          int lastL = L.removeLast();
          int lastM = M.removeLast();
          assertEquals(lastL, lastM);
        }
      }
    }
}
