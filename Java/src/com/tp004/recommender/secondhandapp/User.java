package com.tp004.recommender.secondhandapp;

import java.util.List;

class User {
  int id;
  String name;
  List<Integer> likedPosts; // 사용자가 좋아한 게시물 ID 목록

  User(int id, String name, List<Integer> likedPosts) {
    this.id = id;
    this.name = name;
    this.likedPosts = likedPosts;
  }
}
