import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> testArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correctArrayDeque = new ArrayDequeSolution<>();
        String log = "";

        for (int i = 0; i < 1000; i++) {
            if (testArrayDeque.size() == 0) {
                int addNum = StdRandom.uniform(1000);
                double half = StdRandom.uniform();

                if (half < 0.5) {
                    testArrayDeque.addFirst(addNum);
                    correctArrayDeque.addFirst(addNum);
                    log = log + "addFirst(" + addNum + ")\n";
                } else {
                    testArrayDeque.addLast(addNum);
                    correctArrayDeque.addLast(addNum);
                    log = log + "addLast(" + addNum + ")\n";
                }
            } else {
                int dice = StdRandom.uniform(4);
                int addNum = StdRandom.uniform(1000);
                Integer testRemove;
                Integer correctRemove;
                Integer num1 = 1;
                Integer num2 = 1;

                switch (dice) {
                    case 0:
                        testArrayDeque.addFirst(addNum);
                        correctArrayDeque.addFirst(addNum);
                        log = log + "addFirst(" + addNum + ")\n";
                        break;
                    case 1:
                        testArrayDeque.addLast(addNum);
                        correctArrayDeque.addLast(addNum);
                        log = log + "addLast(" + addNum + ")\n";
                        break;
                    case 2:
                        num1 = testArrayDeque.removeFirst();
                        num2 = correctArrayDeque.removeFirst();
                        log = log + "removeFirst(" + num1 + ")\n";
                        break;
                    case 3:
                        num1 = testArrayDeque.removeLast();
                        num2 = correctArrayDeque.removeLast();
                        log = log + "removeLast(" + num1 + ")\n";
                }

                assertEquals(log, num1, num2);
            }
        }
    }
}
