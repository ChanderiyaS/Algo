package com.csaura.leetcode.medium;

import java.util.*;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public static List<List<Integer>> getAllUniqueTriplet(int[] nums){

        Arrays.sort(nums);
        //HashSet nums2 = Arrays.asList(nums);
        List<List<Integer>> answer = new ArrayList<>();

        for(int i=0;i<nums.length;i++){

            int last = nums.length -1;
            int start = i+1;
            if(i>0 && nums[i] == nums[i-1]) continue;

            while(start<last) {
                int sum = nums[i] + nums[start] + nums[last];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[last]);
                    answer.add(list);

                    start++;
                    while(start<last && nums[start] == nums[start-1])
                        start++;
                    last--;
                    while(start<last && nums[last] == nums[last+1])
                        last--;
                } else if (sum < 0) {
                    start++;
                } else
                    last--;

            }

        }

        return answer;

    }

    public static void main(String args[]){
        int nums[][] = {{1,2,3,4,5,6,-1,1,-2,-3,-5},{1},{1,1,1},{1,0,-1},{},{-2,0,0,2,2},{0,0,0}};

        /*
        List<List<Integer>> list = Arrays.asList(
                                                 Arrays.asList(1,2,3)
                                                    Arrays.asList(1,2,-1));*/
       for(int k = 0; k<nums.length;k++) {
           System.out.println("\nSet being processed");

           List<List<Integer>> list = getAllUniqueTriplet(nums[k]);
           for (List<Integer> arr : list) {
               for (int arrListElement : arr) {
                   System.out.print(arrListElement + " ");
               }
               System.out.println();
           }


       }

    }
}
