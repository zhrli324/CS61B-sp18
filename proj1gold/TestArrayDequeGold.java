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
                        log = log + "removeFirst(): " + num1 + "\n";
                        break;
                    case 3:
                        num1 = testArrayDeque.removeLast();
                        num2 = correctArrayDeque.removeLast();
                        log = log + "removeLast(): " + num1 + "\n";
                }

                assertEquals(log, num1, num2);
            }
        }

/*        for (int i = 0; i < 30; i++) {
            double numBetweenZeroToOne = StdRandom.uniform();

            if (numBetweenZeroToOne < 0.5) {
                int ran = StdRandom.uniform(1000);
                testArrayDeque.addFirst(ran);
                correctArrayDeque.addFirst(ran);
                log = log + "addFirst(" + ran + ")\n";
            } else {
                int ran = StdRandom.uniform(1000);
                testArrayDeque.addLast(ran);
                correctArrayDeque.addLast(ran);
                log = log + "addLast(" + ran + ")\n";
            }
        }

        for (int i = 0; i < 30; i++) {
            double numBetweenZeroToOne = StdRandom.uniform();

            if (numBetweenZeroToOne < 0.5) {
                Integer correctRes = correctArrayDeque.removeFirst();
                Integer testRes = testArrayDeque.removeFirst();
                log = log + "removeFirst(" + testRes + ")\n";
                assertEquals(log, correctRes, testRes);
            } else {
                Integer correctRes = correctArrayDeque.removeLast();
                Integer testRes = testArrayDeque.removeLast();
                log = log + "removeLast(" + testRes + ")\n";
                assertEquals(log, correctRes, testRes);
            }
        }
*/
    }
}
/*
import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> stdArray = new ArrayDequeSolution<>();
        String log = "";
        for (int i = 0; i < 1000; i++) {
            if (stdArray.size() == 0) {
                int addNumber = StdRandom.uniform(1000);
                int headOrBack = StdRandom.uniform(2);
                if (headOrBack == 0) {
                    log = log + "addFirst(" + addNumber + ")\n";
                    testArray.addFirst(addNumber);
                    stdArray.addFirst(addNumber);
                } else {
                    log = log + "addLast(" + addNumber + ")\n";
                    testArray.addLast(addNumber);
                    stdArray.addLast(addNumber);
                }
            } else {
                int x = StdRandom.uniform(4);
                int addNumber = StdRandom.uniform(1000);
                Integer testremoveNumber = 1;
                Integer stdremoveNumber = 1;
                switch (x) {
                    case 0:
                        log = log + "addFirst(" + addNumber + ")\n";
                        testArray.addFirst(addNumber);
                        stdArray.addFirst(addNumber);
                        break;
                    case 1:
                        log = log + "addLast(" + addNumber + ")\n";
                        testArray.addLast(addNumber);
                        stdArray.addLast(addNumber);
                        break;
                    case 2:
                        log = log + "removeFirst()\n";
                        testremoveNumber = testArray.removeFirst();
                        stdremoveNumber = stdArray.removeFirst();
                        break;
                    case 3:
                        log = log + "removeLast()\n";
                        testremoveNumber = testArray.removeLast();
                        stdremoveNumber = stdArray.removeLast();
                        break;
                    default:
                }
                assertEquals(log, stdremoveNumber, testremoveNumber);
            }
        }

    }
}
*/