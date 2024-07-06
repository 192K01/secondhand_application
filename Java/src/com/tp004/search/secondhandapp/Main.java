package com.tp004.search.secondhandapp;//43.200.162.19
import com.tp004.search.secondhandapp.WordPreprocessing;

public class Main {
  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    String words = sc.nextLine()
    WordPreprocessing wp = new WordPreprocessing();
    String test = "아이폰 14 프로"; // 아이폰+14+프로 ???ㅐㅇ>
    String str = wp.removeWhitespace(test);
    System.out.println(str);

    String test_low = wp.toLowerCase(str);
    System.out.println(test_low);

  }
}
