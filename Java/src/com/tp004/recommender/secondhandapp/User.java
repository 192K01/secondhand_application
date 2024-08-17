package com.tp004.recommender.secondhandapp;

import java.util.List;

class User {
  int id;
  String name;
  List<Integer> likedPosts;
  int age; // 나이
  String gender; // 성별 ("M" 또는 "F"로 표기)
  String location; // 거주지

  User(int id, String name, int age, String gender, String location, List<Integer> likedPosts) {
    this.id = id;
    this.name = name;
    this.likedPosts = likedPosts;
    this.age = age;
    this.gender = gender;
    this.location = location;
  }
}
