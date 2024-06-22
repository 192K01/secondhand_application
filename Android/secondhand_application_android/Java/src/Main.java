//43.200.162.19
import java.util.*;

public class Main {
  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    String words = sc.nextLine()
    WordPreprocessing wp = new WordPreprocessing();

    String str = wp.removeWhitespace("hello world    33331");
    System.out.println(str);


  }
}
