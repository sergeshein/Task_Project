package org.example.Lukin;

import java.util.HashSet;
import java.util.Set;

public class Expensive_task {
//    public int[] twoSum(int[]nums, int k){
//        for (int i = 0; i < nums.length ; i++) {
//            for (int j = i + 1; j < nums.length ; j++) {
//                if (nums[i] + nums[j] == k)  {
//                    return new int []{nums[i], nums[j]};
//                }
//            }
//
//        }
//        return new int[0];
//    }


/////////////////////////

public int[] twoSum(int[]nums, int k){
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
        int numToFind = k - nums[i];
        if (set.contains(numToFind)){
            return new int[]{numToFind, nums[i]};
        }
        set.add(nums[i]);

    }
    return new int[0];
}

}
