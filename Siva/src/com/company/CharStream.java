package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class CharStream {
    public static void main(String args[]){
        String input = "aabbbcccabcaaaaaccbb";
        LocalDateTime localDateTime = LocalDateTime.now();

        repeatedCharStringChar(input);
        System.out.println("Time Taken for char array = "+ localDateTime.until(LocalDateTime.now(), ChronoUnit.MILLIS));

        localDateTime = LocalDateTime.now();
        repeatedCharStrings(input);
        System.out.println("Time Taken for bufferstring =  "+ localDateTime.until(LocalDateTime.now(), ChronoUnit.MILLIS));
    }

    //Using Buffer String
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
                String previouString = stringBuffer.toString();
                if(highest < previouString.length()){
                    finalString = previouString;
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
    //Using char array logic
    private static void repeatedCharStringChar(String input){
        char[] charInput = input.toCharArray();
        char compare = charInput[0];
        char[] stringBuffer = new char[input.length()];
        stringBuffer[0] = compare;
        int highest = 0;
        int location = 0;
        int finalLocation = 0;
        char[] finalString = new char[input.length()];;
        int finalStringLength = 0;
        int counter = 1;
        for(int i=1; i<charInput.length; i++){
            if(compare == charInput[i]){
                stringBuffer[counter] = charInput[i];
                counter++;

            }else{
                compare = charInput[i];
                char[] previouString = stringBuffer;
                finalStringLength = findLength(previouString);
                if(highest < finalStringLength){
                    finalString = previouString;
                    highest = finalStringLength;
                    finalLocation = location;
                }
                location = i;
                stringBuffer = new char[input.length()];
                counter = 0;
                stringBuffer[counter]=compare;
            }
        }

        System.out.println("Final String = "+new String(finalString).trim());
        System.out.println("Final String Location = "+(finalLocation+1));

    }

    private static int findLength(char[] charArray){
        for(int i=0;i<charArray.length;i++){
            if(charArray[i] == 0){
                return i;
            }
        }
        return charArray.length;
    }

    //private static String convertString(char[] charArray)


}