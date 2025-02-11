package fastcampus.part1.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 단어 정렬
 * <p/>
 * https://www.acmicpc.net/problem/1181
 */
public class Problem1181 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Set<String> strSet = new HashSet<>();
    while (N-- > 0) {
      String str = br.readLine();
      strSet.add(str);
    }

    List<String> strList = new ArrayList<>(strSet);
    strList.sort(
        Comparator.comparing(String::length)
            .thenComparing(Comparator.naturalOrder())
    );

    for (String str : strList) {
      System.out.println(str);
    }
  }
}

/*
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Set<String> strSet = new HashSet<>();
    while (N-- > 0) {
      String str = br.readLine();
      strSet.add(str);
    }

    List<String> strList = new ArrayList<>(strSet);
    strList.sort(
        Comparator.comparing(String::length)
            .thenComparing(Comparator.naturalOrder())
    );

    for (String str : strList) {
      System.out.println(str);
    }
  }
}
*/
 */