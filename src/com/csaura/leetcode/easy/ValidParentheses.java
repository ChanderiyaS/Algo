package com.csaura.leetcode.easy;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {


    static boolean  isValidParentheses(String s){
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        int iterator = 0;
        while(iterator<length){

            if(s.charAt(iterator) == '{' || s.charAt(iterator) == '[' || s.charAt(iterator) == '(' ){
                stack.push(s.charAt(iterator));
            }else if(stack.empty()) {
                return false;
            }else{
                    switch (s.charAt(iterator)){
                        case '}': if(stack.pop() != '{') return false; break;
                        case ']' : if(stack.pop() != '[') return false; break;
                        case ')' : if(stack.pop() != '(') return false; break;
                        default: return false ;
                    }


            }
            iterator++;
        }

        return true && stack.empty();
    }



    public static void main(String[] arg){

        System.out.println(isValidParentheses(""));

    }
}
