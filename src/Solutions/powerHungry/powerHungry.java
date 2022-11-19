package Solutions.PowerHungry;

import java.math.BigInteger; 
import java.util.ArrayList;

public class powerHungry {

    public static String solution(int[] xs) {
        ArrayList<Integer> negativePanels = new ArrayList<>();
        ArrayList<Integer> positivePanels = new ArrayList<>();
        BigInteger maxProduct = new BigInteger("1");

        if (xs.length == 1)
            return Integer.toString(xs[0]);
        // split positive and negative panels
        for (int x : xs) {
            // if panel energy is 0 do nothing
            if (x == 0) {
            } else if (x < 0) {
                negativePanels.add(x);
            } else {
                positivePanels.add(x);
            }
        }
        if (negativePanels.size() != 0) {
            Integer maxNegativePanel = negativePanels.get(0);
            int toBeRemoveD = 0;

            // if negative panels is an odd number find and remove the highest negative
            // panel
            if (negativePanels.size() % 2 != 0) {
                for (int i = 0; i < negativePanels.size(); i++) {
                    if (negativePanels.get(i) > maxNegativePanel) {
                        maxNegativePanel = negativePanels.get(i);
                        toBeRemoveD = i;
                    }
                }
                negativePanels.remove(toBeRemoveD);
            }
        }
        // combine postitive panels and even numbered negative panels
        positivePanels.addAll(negativePanels);

        for (int x : positivePanels) {
            BigInteger resultInteger = new BigInteger(Integer.toString(x));
            maxProduct = maxProduct.multiply(resultInteger);
        }

        return String.valueOf(maxProduct);
    }
}
