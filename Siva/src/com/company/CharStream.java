package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CharStream {
    public static void main(String args[]){
        LocalDateTime localDateTime = LocalDateTime.now();
        String input = "aabbbcccabcaaaaaccbb";
        List<String>  findSameCharList = repeatedCharStrings(input);
        System.out.println(findSameCharList);
        int highest = 0;
        int location = 0;
        int finalLocation = 0;
        String longestRepeated = new String();
        for(String repeated: findSameCharList){
            if(highest < repeated.length()){
                highest = repeated.length();
                longestRepeated = repeated;
                finalLocation = location;
            }
            location = location + repeated.length();
        }

        System.out.println("Longest Repeated = "+longestRepeated);
        System.out.println("Location ="+ (finalLocation+1));
        System.out.println("Time Taken "+ localDateTime.until(LocalDateTime.now(), ChronoUnit.MILLIS));
    }

    private static List<String> repeatedCharStrings(String input){
        char[] charInput = input.toCharArray();
        char character = charInput[0];
        List<String> findSameCharList = new ArrayList<>();
        char compare = charInput[0];
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(compare);
        for(int i=1; i<charInput.length; i++){
            if(compare == charInput[i]){
                stringBuffer.append(charInput[i]);
            }else{
                compare = charInput[i];
                findSameCharList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
                stringBuffer.append(compare);
            }
        }
        findSameCharList.add(stringBuffer.toString());
        return findSameCharList;
    }
}