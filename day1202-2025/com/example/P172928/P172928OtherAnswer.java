import java.util.*;

public class P172928OtherAnswer {
    
    public static void main(String[] args) {
        String[] park = { "SOO", "OOO", "OOO" };
        String[] routes = { "E 2", "S 2", "W 1" };
        int[] solution = solution(park, routes);

        System.out.println();

        System.out.println(Arrays.toString(solution));

        System.out.println();
        
    }


    public static int[] solution(String[] park, String[] routes) {
        int rows = park.length;
        int cols = park[0].length();
        int startRow = 0, startCol = 0;
        
        // 시작 위치 'S' 찾기
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (park[r].charAt(c) == 'S') {
                    startRow = r;
                    startCol = c;
                    break;
                }
            }
        }
        
        // 방향 벡터 설정
        Map<Character, int[]> directions = new HashMap<>();
        directions.put('N', new int[]{-1, 0});
        directions.put('S', new int[]{1, 0});
        directions.put('W', new int[]{0, -1});
        directions.put('E', new int[]{0, 1});
        
        // 현재 위치 초기화
        int curRow = startRow;
        int curCol = startCol;
        
        // 명령어 처리
        for (String route : routes) {
            String[] parts = route.split(" ");
            char dir = parts[0].charAt(0);
            int dist = Integer.parseInt(parts[1]);
            
            int[] delta = directions.get(dir);
            boolean canMove = true;
            int newRow = curRow;
            int newCol = curCol;
            
            // 주어진 거리만큼 이동할 수 있는지 확인
            for (int i = 1; i <= dist; i++) {
                newRow += delta[0];
                newCol += delta[1];
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols 
                        || park[newRow].charAt(newCol) == 'X') {
                    canMove = false;
                    break;
                }
            }
            
            if (canMove) {
                curRow = newRow;
                curCol = newCol;
            }
        }
        
        return new int[]{curRow, curCol};
    }
}

