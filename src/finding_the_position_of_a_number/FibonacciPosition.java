package finding_the_position_of_a_number;

public class FibonacciPosition {
    public static int findPosition(int target) {
        int fib1 = 0, fib2 = 1, fibNext = 1;
        int position = 1;

        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        }

        while (fibNext <= target) {
            if (fibNext == target) {
                return position;
            }
            fib1 = fib2;
            fib2 = fibNext;
            fibNext = fib1 + fib2;
            position++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int target = 55;
        int position = findPosition(target);

        if (position != -1) {
            System.out.println("The position of " + target + " in the Fibonacci sequence is: " + position);
        } else {
            System.out.println(target + " is not a Fibonacci number.");
        }
    }
}
