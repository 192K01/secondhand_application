package com.tp004.recommender.secondhandapp;

import java.util.*;
import java.util.stream.Collectors;

public class Recommender {
  List<User> users;
  List<Post> posts;

  Recommender(List<User> users, List<Post> posts) {
    this.users = users;
    this.posts = posts;
  }

  // 사용자의 유사도를 계산 (나이, 성별, 거주지를 포함)
  private double calculateSimilarity(User u1, User u2) {
    Set<Integer> commonLikes = new HashSet<>(u1.likedPosts);
    commonLikes.retainAll(u2.likedPosts);

    // 나이 차이에 따른 유사도 (나이 차이가 적을수록 유사도가 높음)
    double ageSimilarity = 1.0 / (1 + Math.abs(u1.age - u2.age));

    // 성별 유사도 (같으면 1, 다르면 0)
    double genderSimilarity = u1.gender.equals(u2.gender) ? 1.0 : 0.0;

    // 거주지 유사도 (같으면 1, 다르면 0)
    double locationSimilarity = u1.location.equals(u2.location) ? 1.0 : 0.0;

    // 기본 좋아요 게시물 유사도
    double postSimilarity = (double) commonLikes.size() / Math.sqrt(u1.likedPosts.size() * u2.likedPosts.size());

    // 나이, 성별, 거주지를 포함한 전체 유사도 계산
    return (0.5 * postSimilarity) + (0.2 * ageSimilarity) + (0.2 * genderSimilarity) + (0.1 * locationSimilarity);
  }

  // 추천 게시물 반환
  public List<Post> recommendPosts(int userId) {
    User currentUser = users.stream().filter(u -> u.id == userId).findFirst().orElse(null);
    if (currentUser == null) return Collections.emptyList();

    // 다른 사용자와의 유사도 계산
    Map<User, Double> similarityMap = new HashMap<>();
    for (User user : users) {
      if (user.id != userId) {
        double similarity = calculateSimilarity(currentUser, user);
        similarityMap.put(user, similarity);
      }
    }

    // 유사한 사용자가 좋아한 게시물 추천
    List<Integer> recommendedPostIds = similarityMap.entrySet().stream()
        .sorted(Map.Entry.<User, Double>comparingByValue().reversed())
        .limit(5) // 가장 유사한 5명의 사용자 선택
        .flatMap(entry -> entry.getKey().likedPosts.stream())
        .distinct()
        .toList();

    return posts.stream().filter(p -> recommendedPostIds.contains(p.id)).collect(Collectors.toList());
  }
}
