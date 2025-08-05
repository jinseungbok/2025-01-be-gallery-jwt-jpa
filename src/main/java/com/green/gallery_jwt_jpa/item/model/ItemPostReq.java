package com.green.gallery_jwt_jpa.item.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemPostReq {
  //private int id; mapper에서 pk 가져오기 위해 사용
    private String name;
  //private String imgPath; mapper에서 사진 경로 저장 위해 사용
    private int price;
    private int discountPer;
}