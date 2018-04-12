import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroTripleSums {

  public static void main(String[] args) {
//    Set<int[]> result = zeroSumTriples(new int[] { 7, 10, 2, -4, -7, 9, -6, -8, 8, 6, -10, -9, 5, 4, -2, -1, -5, 3});
    Set<int[]> result = zeroSumTriples(new int[] {2, 9, -1, 4, -4, -2, 6, 0, -1, 6, 6, 7, -6, 10, 4, -1, -7, 3, -3, -10, -7, -5, 10, 2, -1});
    for ( int[] arr: result) {
      System.out.println(Arrays.toString(arr));
    }
  }

  private static Set<int[]> zeroSumTriples(int[] data) {
    Set<int[]> result = new HashSet<>();
    for (int i = 0; i < data.length; i++) {
      for (int j = i + 1; j < data.length; j++) {
        third:
        for (int k = j + 1; k < data.length; k++) {
          int[] test = new int[3];
          test[0] = data[i];
          test[1] = data[j];
          test[2] = data[k];
          if ((test[0] + test[1] + test[2]) == 0) {
            Arrays.sort(test);
            for (int[] arr : result) {
              if (Arrays.toString(arr).equals(Arrays.toString(test))) {
                continue third;
              }
            }
            result.add(test);
          }
        }
      }
    }
    return result;
  }

}
