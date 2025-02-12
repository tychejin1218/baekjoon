package fastcampus.part1.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 나이순 정렬
 * <p/>
 * https://www.acmicpc.net/problem/10814
 */
public class Problem10814 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    List<User> userList = new ArrayList<>();

    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String[] userArr = br.readLine().split(" ");
      userList.add(new User(Integer.parseInt(userArr[0]), userArr[1]));
    }

    userList.sort(Comparator.comparingInt(User::getAge));

    for (User user : userList) {
      bw.write(user.getAge() + " " + user.getName() + "\n");
    }
    bw.flush();
  }

  public static class User {

    private int age;
    private String name;

    public User(int age, String name) {
      this.age = age;
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public String getName() {
      return name;
    }
  }
}

/*
import java.io.*;
import java.util.*;

public class Problem10814 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    List<User> userList = new ArrayList<>();

    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String[] userArr = br.readLine().split(" ");
      userList.add(new User(Integer.parseInt(userArr[0]), userArr[1]));
    }

    userList.sort(Comparator.comparingInt(User::getAge));

    for (User user : userList) {
      bw.write(user.getAge() + " " + user.getName() + "\n");
    }
    bw.flush();
  }

  public static class User {

    private int age;
    private String name;

    public User(int age, String name) {
      this.age = age;
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public String getName() {
      return name;
    }
  }
}
*/
