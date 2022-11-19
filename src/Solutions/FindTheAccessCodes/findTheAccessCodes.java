package Solutions.FindTheAccessCodes;

public class findTheAccessCodes {

    public static int solution(int[] l) {
        int numberOfTuple = 0;
        int numberOfDouble[] = new int[l.length];
        
        for (int i = 1; i < l.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                //if they are divisable by each increase element in array by 1
                if (l[i] % l[j] == 0) {
                    numberOfDouble[i] += 1;
                }
            }
        }
        for (int i = 2; i < l.length; i++) {
            for (int j = 1; j < i; j++) {
                if (l[i] % l[j] == 0) {
                    // if they are divisable by each other and already in numberOfDouble
                    numberOfTuple += numberOfDouble[j];
                }
            }
        }
        return numberOfTuple;
    }
}
