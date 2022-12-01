import java.util.*;

public class Main {
  public static void main(String[] args) {
    int N;
    int[][] floor;
    int[][] matrix;

    Scanner s = new Scanner(System.in);

    N = s.nextInt();
    floor = new int[N + 1][4];
    s.nextLine();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        floor[i][j] = s.nextInt();
      }
      s.nextLine();
    }

    matrix = new int[N + 1][4];
    int goSouth;
    int goUp;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 0 && j == 0) {
          matrix[i][j] = floor[i][j];
          continue;
        }

        if (j > 0) {
          goSouth = floor[i][j - 1];
        } else
          goSouth = 0;

        if (i > 0) {
          goUp = floor[i - 1][j];
        } else
          goUp = 0;

        matrix[i][j] = Math.max(goSouth, goUp) + floor[i][j];
      }
    }

    System.out.println();
    for (int i = 0; i < N; i++) {
      for (int j = 1; j < 4; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println(matrix[N - 1][3]);
    s.close();
  }
}