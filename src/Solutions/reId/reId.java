package Solutions.reId;

public class reId { 
    public static String solution(int i) {
        int count, checkNum = 2;
        String prime = "";
        //max case + 5 digits
        while (prime.length() < 10000 + 5) {
            count = 0;
            for (int idx = 1; idx <= checkNum; idx++) {
                if (checkNum % idx == 0) {
                    count++;
                }
            }
            if (count == 2) {
                prime += checkNum;
            }
            checkNum++;
        }
        String newMinionId = "";
        for (int j = i; j < i + 5; j++) {
            newMinionId += prime.charAt(j);
        }
        return newMinionId;
    }
}
