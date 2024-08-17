package com.tp004.recommender.secondhandapp;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    // 사용자 예시
    List<User> users = Arrays.asList(
      new User(1, "Alice", 25, "F", "Seoul", Arrays.asList(1, 2, 3, 12)),
      new User(2, "Bob", 30, "M", "Busan", Arrays.asList(2, 3, 4, 34)),
      new User(3, "Charlie", 28, "M", "Seoul", Arrays.asList(4, 5, 6, 12)),
      new User(4, "Daisy", 22, "F", "Seoul", Arrays.asList(1, 5, 6, 8)),
      new User(5, "Eve", 35, "F", "Busan", Arrays.asList(3, 4, 20, 21))
    );

    // 게시물 예시 (50개)
    List<Post> posts = Arrays.asList(
      new Post(1, "Bicycle for sale", "Sports"),
      new Post(2, "Used laptop", "Electronics"),
      new Post(3, "Coffee table", "Furniture"),
      new Post(4, "Smartphone", "Electronics"),
      new Post(5, "Running shoes", "Sports"),
      new Post(6, "Bookshelf", "Furniture"),
      new Post(7, "Treadmill", "Sports"),
      new Post(8, "Headphones", "Electronics"),
      new Post(9, "Dining table", "Furniture"),
      new Post(10, "Camping gear", "Sports"),
      new Post(11, "Smartwatch", "Electronics"),
      new Post(12, "Office chair", "Furniture"),
      new Post(13, "Golf clubs", "Sports"),
      new Post(14, "Digital camera", "Electronics"),
      new Post(15, "Sofa set", "Furniture"),
      new Post(16, "Exercise bike", "Sports"),
      new Post(17, "Bluetooth speaker", "Electronics"),
      new Post(18, "Wardrobe", "Furniture"),
      new Post(19, "Yoga mat", "Sports"),
      new Post(20, "Tablet", "Electronics"),
      new Post(21, "TV stand", "Furniture"),
      new Post(22, "Dumbbells", "Sports"),
      new Post(23, "Laptop bag", "Electronics"),
      new Post(24, "Shoe rack", "Furniture"),
      new Post(25, "Basketball", "Sports"),
      new Post(26, "Camera tripod", "Electronics"),
      new Post(27, "Armchair", "Furniture"),
      new Post(28, "Barbecue grill", "Sports"),
      new Post(29, "Gaming console", "Electronics"),
      new Post(30, "Recliner chair", "Furniture"),
      new Post(31, "Skateboard", "Sports"),
      new Post(32, "Wireless charger", "Electronics"),
      new Post(33, "Bed frame", "Furniture"),
      new Post(34, "Tennis racket", "Sports"),
      new Post(35, "Kitchen blender", "Electronics"),
      new Post(36, "Bookshelf", "Furniture"),
      new Post(37, "Soccer ball", "Sports"),
      new Post(38, "Smart TV", "Electronics"),
      new Post(39, "Dining chairs", "Furniture"),
      new Post(40, "Rowing machine", "Sports"),
      new Post(41, "Camera lens", "Electronics"),
      new Post(42, "Nightstand", "Furniture"),
      new Post(43, "Baseball bat", "Sports"),
      new Post(44, "Portable projector", "Electronics"),
      new Post(45, "Shoe cabinet", "Furniture"),
      new Post(46, "Punching bag", "Sports"),
      new Post(47, "Smart home device", "Electronics"),
      new Post(48, "Glass dining table", "Furniture"),
      new Post(49, "Hiking backpack", "Sports"),
      new Post(50, "Digital photo frame", "Electronics")
    );
    // 예시 끝

    // 추천 시스템 초기화
    Recommender recommender = new Recommender(users, posts);

    // 사용자 ID를 기반으로 추천 받기
    int userId = 1; // Alice의 추천 결과를 보고 싶다면
    List<Post> recommendations = recommender.recommendPosts(userId);

    // 추천 결과 출력
    System.out.printf("추천 게시물 (사용자 ID: %d):%n", userId);
    for (Post post : recommendations) {
      System.out.println(post);
    }
  }
}
