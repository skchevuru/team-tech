package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CharStream {
    public static void main(String args[]){
        String input = "aabbbzzzzzcccabcaaaaaccbbxxxxx";
        LocalDateTime localDateTime = LocalDateTime.now();
        new CharStream().repeatedCharStringChars(input);
        System.out.println("Time Taken for char array =  "+ localDateTime.until(LocalDateTime.now(), ChronoUnit.MILLIS));


    }


    //Using char array logic
    private void repeatedCharStringChars(String input){
        char[] charInput = input.toCharArray();
        char compare = charInput[0];
        char[] stringBuffer = new char[input.length()];
        int highest = 0;
        List<RepeatedChar> repeatedCharList = null;
        int started = 0;
        int counter = 0;
        for(int i=0; i<charInput.length; i++){
            if(compare == charInput[i]) {
                stringBuffer[counter] = charInput[i];
                counter++;
                if(i == (charInput.length - 1)){
                    if(highest < counter){
                        repeatedCharList = new ArrayList<>();
                        repeatedCharList.add(new RepeatedChar(started+1, stringBuffer));
                    }else if(highest == counter){
                        repeatedCharList.add(new RepeatedChar(started+1, stringBuffer));
                    }
                }

            }else{
                compare = charInput[i];
                char[] previouString = stringBuffer;
                if(highest < counter){
                    repeatedCharList = new ArrayList<>();
                    repeatedCharList.add(new RepeatedChar(started+1, previouString));
                    highest = counter;
                }else if(highest == counter){
                    repeatedCharList.add(new RepeatedChar(started+1, previouString));
                }
                stringBuffer = new char[input.length()];
                counter = 0;
                started=i;
                stringBuffer[counter]=compare;
                counter++;
            }
        }

        System.out.println("Final String = "+repeatedCharList);
       // System.out.println("Final String Location = "+(finalLocation+1));

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

    class RepeatedChar{
        int location;
        char[] repeatedCharArray;

        public RepeatedChar(int location, char[] repeatedCharArray){
            this.location = location;
            this.repeatedCharArray = repeatedCharArray;
        }
        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public char[] getRepeatedCharArray() {
            return repeatedCharArray;
        }

        public void setRepeatedCharArray(char[] repeatedCharArray) {
            this.repeatedCharArray = repeatedCharArray;
        }

        public String toString(){
            return "Char Array = " + new String(repeatedCharArray).trim() + " Location= "+ location;
        }
    }

}