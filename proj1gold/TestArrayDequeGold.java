import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> testArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correctArrayDeque = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i++) {
            double numBetweenZeroToOne = StdRandom.uniform();

            if (numBetweenZeroToOne < 0.5) {
                testArrayDeque.addFirst(i);
                correctArrayDeque.addFirst(i);
            } else {
                testArrayDeque.addLast(i);
                correctArrayDeque.addLast(i);
            }
        }

        for (int i = 0; i < 50; i++) {
            int intBetweenZeroTo = StdRandom.uniform(100);
            assertEquals("addFirst() or addLast(): "
                            + testArrayDeque.get(intBetweenZeroTo),
                            correctArrayDeque.get(intBetweenZeroTo),
                            testArrayDeque.get(intBetweenZeroTo));
        }

        for (int i = 0; i < 100; i++) {
            double numBetweenZeroToOne = StdRandom.uniform();

            if (numBetweenZeroToOne < 0.5) {
                Integer correctRes = correctArrayDeque.removeFirst();
                Integer testRes = testArrayDeque.removeFirst();
                assertEquals("removeFirst(): "+ testRes, correctRes, testRes);
            } else {
                Integer correctRes = correctArrayDeque.removeLast();
                Integer testRes = testArrayDeque.removeLast();
                assertEquals("removeLast(): " + testRes, correctRes, testRes);
            }
        }

    }
}
