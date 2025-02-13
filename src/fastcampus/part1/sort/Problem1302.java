package fastcampus.part1.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 베스트셀러
 * <p/>
 * https://www.acmicpc.net/problem/1302
 */
public class Problem1302 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Map<String, Integer> bookMap = new HashMap<>();

    int N = Integer.parseInt(br.readLine());
    while (N-- > 0) {
      String bookName = br.readLine();
      bookMap.put(bookName, bookMap.getOrDefault(bookName, 0) + 1);
    }

    int bookMaxCount = 0;
    for (Entry<String, Integer> entry : bookMap.entrySet()) {
      bookMaxCount = Math.max(bookMaxCount, entry.getValue());
    }

    List<String> bookList = new ArrayList<>();
    for (Entry<String, Integer> entry : bookMap.entrySet()) {
      if (bookMaxCount == entry.getValue()) {
        bookList.add(entry.getKey());
      }
    }
    bookList.sort(String::compareTo);

    bw.write(bookList.get(0));
    bw.flush();
  }
}
