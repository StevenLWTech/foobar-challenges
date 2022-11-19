package Solutions.GearingUpForDestruction;

import javax.print.event.PrintEvent;

public class test {
    public static void main(String[] args) {

        printTest(gearingUpForDestruction.solution(new int[] { 4, 30, 50 })); //(12, 1) base case
        printTest(gearingUpForDestruction.solution(new int[] { 4, 17, 50 })); // (-1, -1) impossible case
        printTest(gearingUpForDestruction.solution(new int[] { 1, 10000 })); // (6666, 1) min & max case 2 pegs
        printTest(gearingUpForDestruction.solution(new int[] { 4, 30, 50, 60 })); // (32, 3) even pegs
        printTest(gearingUpForDestruction.solution(new int[] { 4, 30, 50, 60, 70 })); //(12, 1) odd pegs
    }
    public static void printTest(int[] arr) {
        System.out.println(arr[0] + ", " + arr[1]);
    }
}
