package com.tp004.recommender.secondhandapp;

class Post {
  int id; // id
  String title; // 상품이름
  String category; // 카테고리

  Post(int id, String title, String category) {
    this.id = id;
    this.title = title;
    this.category = category;
  }

  @Override
  public String toString() {
    return String.format("id : %d\ntitle : %s\n category : %s", id, title, category);
  }
}
