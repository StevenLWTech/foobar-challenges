package Solutions.GearingUpForDestruction;


public class test {
    public static void main(String[] args) {
        // The list pegs will be given sorted in ascending order and will contain at
        // least 2 and no more than 20 distinct positive integers, all between 1 and
        // 10000 inclusive.
        printTest(gearingUpForDestruction.solution(new int[] { 4, 30, 50 })); // (12, 1) base case
        printTest(gearingUpForDestruction.solution(new int[] { 4, 17, 50 })); // (-1, -1) impossible case
        printTest(gearingUpForDestruction.solution(new int[] { 1, 10000 })); // (6666, 1) min & max case 2 pegs
        printTest(gearingUpForDestruction.solution(new int[] { 4, 30, 50, 60 })); // (32, 3) even pegs
        printTest(gearingUpForDestruction.solution(new int[] { 4, 30, 50, 60, 70 })); // (12, 1) odd pegs
    }

    public static void printTest(int[] arr) {
        System.out.println("The first gear's radius is " + arr[0] + " / " + arr[1] + " in fraction form");
    }
}
