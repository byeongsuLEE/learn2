package alligin;

import java.util.Arrays;

/**
 * 작성자  : lbs
 * 날짜    : 2025-10-29
 * 버블 정렬이란?
 * 연속된 두 인덱스를 정렬 시키면서 값을 뒤로 넘겨 정렬 시키는 방법
 *
 **/

//25418
public class Main_버블정렬 {
    public static void main(String[] args) {

        Integer [] number = {3,4,1,4,5};
        int n = number.length ;


        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n-i-1 ; j++){

                if(number[j] > number[j+1]){
                    int temp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = temp;

                }
            }

        }

        Arrays.stream(number).forEach(System.out::println);
    }
}
