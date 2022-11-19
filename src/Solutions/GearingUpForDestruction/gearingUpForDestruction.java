package Solutions.GearingUpForDestruction;

public class gearingUpForDestruction {
    public static int[] solution(int[] pegs) {
        // Gear trains teeth much touch each other so the radius of
        // gear0 + gear1 = b/t gear0+gear1 (distance0)
        // gear1 = distance0 - gear0

        // gear1 + gear2 = b/t gear1+gear2 (distance1)
        // gear2 = distance1 - gear1 which is (distance0-gear0)
        // gear2 = distance1 - distance0 + gear0

        // gear2 + gear3 = distance2
        // gear3 = distance2 - distance1 + distance0 - gear0

        // the prompt says last gear runs twice as fast as the first gear
        // so the last gear is half the size of the first gear
        
        // gear3 = gear0 / 2

        // if gear3 = 3
        // (gear3 = distance2 - distance1 + distance0 - gear0)
        // (gear0 / 2) = d2 - d1 + d0 - gear0
        // (gear0 / 2) + gear0 = d2 - d1 + d0
        // gear0 + gear0 = 2(d2 - d1 + d0)
        // gear0 = (d2 - d1 + d0)
        // gear0 = 2(d2 - d1 + d0) / 3
        // gear0 = 2/3 (d2-d1+d0)

        // if lastGear = 4
        // (gear4 = distance3 - distance2 + distance1 - distance0 + gear0)
        // g0/2 - g0 = (d3 - d2 + d1 - d0)
        // g0 - g0 = 2 (d3 - d2 + d1 - d0)
        // g0 = 2
        
        // therefore even numbered pegs has a ratio of n/1 and odd has a ratio fo n/3
        // raising -1 to odd pegs gives (-1*2)+1 = 1
        // raising 1 to even pegs gives (1*2)+1 =  3

        int denominatorGear = Math.abs((int) Math.pow(-1, pegs.length) * 2 + 1);
        int numeratorGear = 0;
    
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
