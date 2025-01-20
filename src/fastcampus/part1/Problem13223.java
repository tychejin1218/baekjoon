package fastcampus.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소금 폭탁
 * <p/>
 * https://www.acmicpc.net/problem/13223
 */
public class Problem13223 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] current = br.readLine().split(":");
    String[] target = br.readLine().split(":");

    int currentHour = Integer.parseInt(current[0]);
    int currentMinute = Integer.parseInt(current[1]);
    int currentSecond = Integer.parseInt(current[2]);

    int targetHour = Integer.parseInt(target[0]);
    int targetMinute = Integer.parseInt(target[1]);
    int targetSecond = Integer.parseInt(target[2]);

    int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;
    int targetSecondAmount = targetHour * 3600 + targetMinute * 60 + targetSecond;

    int NeedSecondAmount = targetSecondAmount - currentSecondAmount;
    if (NeedSecondAmount <= 0) NeedSecondAmount += 24 * 3600;

    int needHour = NeedSecondAmount / 3600;
    int needMinute = (NeedSecondAmount % 3600) / 60;
    int needSecond = NeedSecondAmount % 60;

    System.out.println(String.format("%02d:%02d:%02d", needHour, needMinute, needSecond));
  }
}

/*
import java.io.*;

public class Main {

   public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] current = br.readLine().split(":");
    String[] target = br.readLine().split(":");

    int currentHour = Integer.parseInt(current[0]);
    int currentMinute = Integer.parseInt(current[1]);
    int currentSecond = Integer.parseInt(current[2]);

    int targetHour = Integer.parseInt(target[0]);
    int targetMinute = Integer.parseInt(target[1]);
    int targetSecond = Integer.parseInt(target[2]);

    int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;
    int targetSecondAmount = targetHour * 3600 + targetMinute * 60 + targetSecond;

    int NeedSecondAmount = targetSecondAmount - currentSecondAmount;
    if (NeedSecondAmount <= 0) NeedSecondAmount += 24 * 3600;

    int needHour = NeedSecondAmount / 3600;
    int needMinute = (NeedSecondAmount % 3600) / 60;
    int needSecond = NeedSecondAmount % 60;

    System.out.println(String.format("%02d:%02d:%02d", needHour, needMinute, needSecond));
  }
}
*/