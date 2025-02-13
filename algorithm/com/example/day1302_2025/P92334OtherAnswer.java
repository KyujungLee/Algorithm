package algorithm.com.example.day1302_2025;

//https://school.programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;

public class P92334 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Set<String> real = new HashSet<>();
        for(String a : report){
            real.add(a);
        }
        
        int[] repNum = new int[id_list.length];
        String[] temp = new String[2];
        for(String a : real){
            temp = a.split(" ");
            for(int i = 0 ; i < id_list.length ; i++){
                if(id_list[i].equals(temp[1])){
                    repNum[i] ++;
                    break;
                }
            }
        }
        
        
        for(int i = 0 ; i < id_list.length ; i++){
            String tempId = "";
            if(repNum[i] >= k){
                tempId = id_list[i];
            } else {
                continue;
            }
            
            for(String a : real){
                temp = a.split(" ");
                if(temp[1].equals(tempId)){
                    for(int j = 0 ; j < id_list.length ; j++){
                        if(id_list[j].equals(temp[0])){
                            answer[j] ++;
                            break;
                        }
                    }
                }
            }
            
        }
        return answer;
    }
}