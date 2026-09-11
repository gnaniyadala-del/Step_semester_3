package programming_performance.assignment_problems;


    import java.util.HashMap;

    public class SubarraySumEqualsK {
        public static int subarraySum(int[] nums, int k) {
            int count = 0;
            int runningSum = 0;
            HashMap<Integer, Integer> prefixSumMap = new HashMap<>();


            prefixSumMap.put(0, 1);

            for (int num : nums) {
                runningSum += num;


                if (prefixSumMap.containsKey(runningSum - k)) {
                    count += prefixSumMap.get(runningSum - k);
                }


                prefixSumMap.put(runningSum, prefixSumMap.getOrDefault(runningSum, 0) + 1);
            }

            return count;
        }

        public static void main(String[] args) {
            int[] nums = {1, -1, 0};
            int k = 0;
            System.out.println(subarraySum(nums, k)); // Output: 3
        }
    }


