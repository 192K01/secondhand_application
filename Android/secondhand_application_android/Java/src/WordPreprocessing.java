public class WordPreprocessing{ // 문자전처리 클래스
  String removeWhitespace(String word){ // 공백제거 메소드
    StringBuilder result = new StringBuilder();

    for(int i = 0; i < word.length(); i++) {
      //if문 조건을 활용해, 문자열의 공백문자 제거
      //변수 역시 객체와 동일한 사용방식임을 알 수 있음
      //str.charAt(i) : str은 변수이면서 문자열 객체이고, charAt(i) : 문자열 관련 메소드이다
      //str.charAt(num) : 문자열 str의 num-1 번째 문자를 획득
      //문자열 변수는 배열과 같이 주소값처럼 되어있음을 알 수 있음
      if(word.charAt(i) != ' ')
        result.append(word.charAt(i));
    }
    return result.toString();
  }
  String processSpecialCharacters(String word){ // 특수문자 처리 메소드
    String result = null; 
    return result;
  }
  String toLowerCase(String word){ // 대소문자 구별(대문자 -> 소문자)
    String result = null;
    return result;
  }
  String[] morphologicalAnalysis(String word){ // 형태소분석
    String[] result = null;
    return result;
  }
}
