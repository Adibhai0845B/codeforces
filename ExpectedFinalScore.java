import java.io.*;
import java.util.*;
public class ExpectedFinalScore {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
       
   ");
        }
        
        System.out.println(result.toString().trim());
    }

    private static int countInversions(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}