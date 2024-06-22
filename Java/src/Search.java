public interface Search {
  String[] searchWordPreprocessing(String word); // 검색어 전처리
}

class Searching extends WordPreprocessing implements Search {
  @Override
  public String[] searchWordPreprocessing(String words) { // 검색어 전처리
    String word = removeWhitespace(words);
    word = processSpecialCharacters(word);
    word = toLowerCase(word);
    String[] result = morphologicalAnalysis(word);
    return result;
  }

}