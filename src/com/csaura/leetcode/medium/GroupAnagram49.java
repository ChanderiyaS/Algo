package com.csaura.leetcode.medium;

import com.csaura.utilities.StringLinkedList;

import java.util.*;

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note: All inputs will be in lower-case.
 */
public class GroupAnagram49 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        String [] strsCopy = strs;
        HashMap<String,List<String>> mapAnagram = new HashMap<>();
        int index = 0;
        for(String s:strs){
            char [] charS = s.toCharArray();
           Arrays.sort(charS);
           s = String.valueOf(charS);
           if(!mapAnagram.containsKey(s)){
               List<String> list = new ArrayList<>();
               list.add(strs[index]);
               mapAnagram.put(s, list);
           }else{
               mapAnagram.get(s).add(strs[index]);
           }
           index++;
        }

        List<List<String>> answer = new ArrayList(mapAnagram.values());


        return answer;
    }


    public static void main (String [] args){
        String [][] strs = {{"test","estt"},{"ate","eat","test"},{""}};

        for(int i =0; i<strs.length;i++){
            System.out.println("Test Case : "+ i);
            List<List<String>> list = groupAnagrams(strs[i]);

            for(List l:list){
                System.out.println(l.toString());
            }
        }

    }
}
