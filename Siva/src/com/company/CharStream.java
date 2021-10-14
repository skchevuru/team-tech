package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CharStream {
    public static void main(String args[]){
        LocalDateTime localDateTime = LocalDateTime.now();
        String input = "aabbbcccabcaaaaaccbb";
        repeatedCharStrings(input);
        System.out.println("Time Taken "+ localDateTime.until(LocalDateTime.now(), ChronoUnit.MILLIS));
    }


    private static void repeatedCharStrings(String input){
        char[] charInput = input.toCharArray();
        char compare = charInput[0];
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(compare);
        int highest = 0;
        int location = 0;
        int finalLocation = 0;
        String finalString = new String();
        for(int i=1; i<charInput.length; i++){
            if(compare == charInput[i]){
                stringBuffer.append(charInput[i]);
            }else{
                compare = charInput[i];
                if(highest < stringBuffer.toString().length()){
                    finalString = stringBuffer.toString();
                    highest = finalString.length();
                    finalLocation = location;
                }
                location = i;
                stringBuffer = new StringBuffer();
                stringBuffer.append(compare);
            }
        }

        System.out.println("Final String = "+finalString);
        System.out.println("Final String Location = "+(finalLocation+1));

    }
}