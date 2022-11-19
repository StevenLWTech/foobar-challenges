package Solutions.powerHungry;

public class test {
    public static void main(String[] args) {

        System.out.println(powerHungry.solution(new int[] { 0 })); // (0) single panel 0
        System.out.println(powerHungry.solution(new int[] { -5 })); // (-5) single panel negative
        System.out.println(powerHungry.solution(new int[] { 5 })); // (5) single panel positive
        System.out.println(powerHungry.solution(new int[] { 2, 0, 2, 2, 0 })); // (8) base case
        System.out.println(powerHungry.solution(new int[] { -2, -3, 4, -5 })); // (60) odd negative panels
        System.out.println(powerHungry.solution(new int[] { -2, 3, 4, -5 })); // (120) even negative panels

    }

}
