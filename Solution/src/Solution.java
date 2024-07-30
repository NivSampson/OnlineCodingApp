mport java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static int[] freqSort(int[] listEle) {
        // Step 1: Count frequencies
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : listEle) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list of elements to sort with custom comparator
        List<Integer> elements = new ArrayList<>();
        for (int num : listEle) {
            elements.add(num);
        }

        // Step 3: Sort the list based on frequency and original order
        elements.sort((a, b) -> {
            int freqCompare = freqMap.get(b).compareTo(freqMap.get(a));
            if (freqCompare == 0) {
                return Integer.compare(Arrays.asList(listEle).indexOf(a), Arrays.asList(listEle).indexOf(b));
            }
            return freqCompare;
        });

        // Convert the sorted list back to an array
        int[] answer = new int[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            answer[i] = elements.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // input for listEle
        int listEle_size = in.nextInt();
        int listEle[] = new int[listEle_size];
        for (int idx = 0; idx < listEle_size; idx++) {
            listEle[idx] = in.nextInt();
        }

        int[] result = freqSort(listEle);
        for (int idx = 0; idx < result.length - 1; idx++) {
            System.out.print(result[idx] + " ");
        }
        System.out.print(result[result.length - 1]);
    }
}