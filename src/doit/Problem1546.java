package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 평균
 * <p/>
 * https://www.acmicpc.net/problem/1546
 */
public class Problem1546 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String inputN = br.readLine();
    String inputScore = br.readLine();

    String[] iScoreArr = inputScore.split(" ");
    double maxScore = Arrays.stream(iScoreArr)
        .mapToDouble(Double::parseDouble)
        .max()
        .getAsDouble();

    double average = Arrays.stream(iScoreArr)
        .mapToDouble(Double::parseDouble)
        .map(score -> (score * 100) / maxScore)
        .average()
        .getAsDouble();

    System.out.println(average);
  }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String inputN = br.readLine();
    String inputScore = br.readLine();

    String[] iScoreArr = inputScore.split(" ");
    double maxScore = Arrays.stream(iScoreArr)
        .mapToDouble(Double::parseDouble)
        .max()
        .getAsDouble();

    double average = Arrays.stream(iScoreArr)
        .mapToDouble(Double::parseDouble)
        .map(score -> (score * 100) / maxScore)
        .average()
        .getAsDouble();

    System.out.println(average);
  }
}
*/
