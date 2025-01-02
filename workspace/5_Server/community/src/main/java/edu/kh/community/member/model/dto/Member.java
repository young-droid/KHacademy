package edu.kh.community.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok 라이브러리
// - VO(Value Object) 또는 DTO(Data Transfer Object)에
//   작성되는 공통 코드(getter/setter/생성자)를 자동으로 추가해주는 라이브러리
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    	
	private int memberNo;
   	private String memberEmail;
   	private String memberPw;
   	private String memberNickname;
   	private String memberTel;
   	private String memberAddress;
   	private String profileImage;
   	private String enrollDate;
   	private String secessionFlag;
   
}
