package Solutions.GearingUpForDestruction;

public class gearingUpForDestruction {
    public static int[] solution(int[] pegs) {
        int numeratorGear = 0;
        int denominatorGear = Math.abs((int) Math.pow(-1, pegs.length) * 2 + 1);
    
        for (int i = 1; i < pegs.length; i++) {
          numeratorGear = pegs[i] - pegs[i - 1] - numeratorGear;
        }
        numeratorGear = Math.abs(numeratorGear * 2);
    
        double currentGearRadius = numeratorGear / denominatorGear;
        for (int i = 1; i < pegs.length; i++) {
          double distance = pegs[i] - pegs[i - 1];
          currentGearRadius = distance - currentGearRadius;
          if (currentGearRadius < 2) {
            return new int[] { -1, -1 };
          }
        }
        if (numeratorGear % 3 == 0 && denominatorGear % 3 == 0) {
          numeratorGear = numeratorGear / 3;
          denominatorGear = denominatorGear / 3;
        }
        return new int[] { numeratorGear, denominatorGear };
      }
}
