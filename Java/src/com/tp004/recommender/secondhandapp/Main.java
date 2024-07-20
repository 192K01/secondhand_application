package com.tp004.recommender.secondhandapp;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // 예시
    List<User> users = Arrays.asList(
        new User(1, "Alice", Arrays.asList(1, 2, 3)),
        new User(2, "Bob", Arrays.asList(2, 3, 4)),
        new User(3, "Charlie", Arrays.asList(4, 5, 6))
    );

    List<Post> posts = Arrays.asList(
        new Post(1, "Bicycle for sale", "Sports"),
        new Post(2, "Used laptop", "Electronics"),
        new Post(3, "Coffee table", "Furniture"),
        new Post(4, "Smartphone", "Electronics"),
        new Post(5, "Running shoes", "Sports"),
        new Post(6, "Bookshelf", "Furniture")
    );
    // 예시 끝

    Recommender recommendationSystem = new Recommender(users, posts);
    int userid = 2;
    List<Post> recommendations = recommendationSystem.recommendPosts(userid);

    System.out.println(String.format("Recommended posts for user %d:", userid));
    for (Post post : recommendations) {
      System.out.println(post.category);
    }
  }
}
// 게시물 추