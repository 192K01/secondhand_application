package com.tp004.mannertemp.secondhandapp;

import java.util.*;

public class UserReview {
  int reviewID;
  User userA; // 구매한 사람(리뷰작성자)
  User userB; // 판매한 사람
  Post post; // 판매글
  Map<Integer,Boolean> reviews = new HashMap<Integer,Boolean>();

  UserReview(int reviewID, User userA, User userB, Post post, Map<Integer,Boolean> reviews) {
    this.reviewID = reviewID;
    this.userA= userA;
    this.userB = userB;
    this.post = post;
    this.reviews = reviews;
  }

}
/*
reviews
id : 내용
1 : 물건을 저렴하게 판매해요
2 : 제품의 상태가 설명과 같아요
3 : 과도한 네고를 하지 않아요
4 : 응답이 빨라요
5 : 약속을 잘 지켜요
6 : 케어를 사용해요
 */