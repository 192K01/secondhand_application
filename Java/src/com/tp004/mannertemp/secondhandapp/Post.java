package com.tp004.mannertemp.secondhandapp;

class Post {
  int id; // id
  User userA;
  User userB;

  Post(int id, User userA, User userB) {
    this.id = id;
    this.userA = userA;
    this.userB = userB;
  }

//  @Override
//  public String toString() {
//    return String.format("id : %d / title : %s / category : %s", id, title, category);
//  }
}