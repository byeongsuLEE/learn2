package alligin;

import java.util.Arrays;

/**
 * 작성자  : lbs
 * 날짜    : 2025-10-29
 * 풀이방법
 **/


public class Main_선택정렬 {
    public static void main(String[] args) {

        Integer[] number = {3,4,5,2,3,1};

        for(int i = 0 ; i < number.length-1 ; i++){

            int smallValue = number[i];

            int index  =i;
            for(int j = i ; j < number.length ; j++){

                if(smallValue  > number[j]){
                    smallValue = number[j];
                    index = j;
                }
            }
            int temp = number[i];
            number[i] = number[index];
            number[index]= temp;
        }
        Arrays.stream(number).forEach(System.out::println);


    }
}
