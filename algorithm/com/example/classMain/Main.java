package algorithm.com.example.classMain;

import algorithm.com.example.day1302_2025.P92334;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;
        int[] answer = P92334.solution(id_list, report, k);

        System.out.println();

        System.out.println(Arrays.toString(answer));

        System.out.println();

    }
}