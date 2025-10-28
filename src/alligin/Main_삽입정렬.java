package alligin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자  : lbs
 * 날짜    : 2025-10-28
 * 삽입 정렬 구현
 * 인덱스를 1 부터 n-1까지 진행하면서 현재 인덱스 이하의 수들과 비교하면서 작으면 왼쪽과 오른쪽 스위칭하여 정렬하는 방식
 **/

public class Main_삽입정렬{
    public static void main(String[] args) {



        Integer[] number = {3,4,2,1};


        // 삽입 정렬
        //현재 인덱스에서 작은 인덱스로 가면서
        for(int i = 1 ; i < number.length; i++){

            int targetNuM = number[i];
            int j  = i-1;

            while(j >=0 && number[j] > targetNuM){
                number[j+1] = number[j];
                j--;
            }
            number[j+1] = targetNuM;

        }

        Arrays.stream(number).forEach(System.out::println);


    }
}
