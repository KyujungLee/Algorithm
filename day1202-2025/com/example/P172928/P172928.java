// https://school.programmers.co.kr/learn/courses/30/lessons/172928

import java.util.Arrays;

public class P172928 {
    public static void main(String[] args) {
        String[] park = { "SOO", "OOO", "OOO" };
        String[] routes = { "E 2", "S 2", "W 1" };
        int[] solution = solution(park, routes);

        System.out.println();

        System.out.println(Arrays.toString(solution));

        System.out.println();
        
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};

        int garo = park[0].length();
        int sero = park.length;
        int[] map = new int[garo * sero];

        for (int i = 0; i < map.length; i++) {
            if (park[i / garo].charAt(i % garo) == 'S') {
                answer[0] = i / garo;
                answer[1] = i % garo;
            }
            char tempChar = park[i / garo].charAt(i % garo);
            map[i] = tempChar == 'S' ? 1 : (tempChar == 'X' ? -1 : 0);
        }

        char[] direct = new char[routes.length];
        int[] distance = new int[routes.length];
        for (int i = 0; i < routes.length; i++) {
            String[] temp = routes[i].split(" ");
            direct[i] = temp[0].charAt(0);
            distance[i] = Integer.parseInt(temp[1]);
        }

        for (int i = 0; i < direct.length; i++) {
            int tempInt = distance[i];
            int now = answer[0] * garo + answer[1];
            int move = 0;

            switch (direct[i]) {
                case 'N':
                    if (answer[0] - tempInt < 0) break;
                    for (int j = 1; j <= tempInt; j++) {
                        if (map[now - garo * j] < 0) {
                            move = 0;
                            break;
                        }
                        move--;
                    }
                    answer[0] += move;
                    break;
                case 'S':
                    if (answer[0] + tempInt >= sero) break;
                    for (int j = 1; j <= tempInt; j++) {
                        if (map[now + garo * j] < 0) {
                            move = 0;
                            break;
                        }
                        move++;
                    }
                    answer[0] += move;
                    break;
                case 'W':
                    if (answer[1] - tempInt < 0) break;
                    for (int j = 1; j <= tempInt; j++) {
                        if (map[now - j] < 0) {
                            move = 0;
                            break;
                        }
                        move--;
                    }
                    answer[1] += move;
                    break;
                case 'E':
                    if (answer[1] + tempInt >= garo) break;
                    for (int j = 1; j <= tempInt; j++) {
                        if (map[now + j] < 0) {
                            move = 0;
                            break;
                        }
                        move++;
                    }
                    answer[1] += move;
                    break;
            }
        }
        return answer;
    }

}

