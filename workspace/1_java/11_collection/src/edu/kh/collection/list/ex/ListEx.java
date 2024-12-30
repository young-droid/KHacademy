package edu.kh.collection.list.ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx {

	// 컬렉션 특징
	// 1) 크기 제한 X
	// 2) 추가, 수정, 삭제 등의 코드가 구현되어 있다. 
	// 3) 객체만 저장 가능

	// List : 자료를 순차적으로 나열한 자료구조 (배열과 비슷)
	// - 특징 1 : 인덱스를 이용해서 순서를 구분
	// - 특징 2 : 순서가 구분되기 때문에 중복 데이터 저장 가능
	
	public void ex1() {
		List list = new ArrayList(3); // 3칸 짜리 생성
		// List list = new ArrayList(); // 빈칸 : 10칸 짜리 생성
		
		// 1. boolean add(E e) : 마지막 요소로 추가
		// E(Element) : 요소를 뜻하는 상징적인 글자 (자료형 X)
		// -> Object를 생각하면 편함
		list.add("아무거나"); // String은 객체
		
		list.add(123);
		list.add(3.14);
		
		// 왜 기본 자료형이 저장될까? 
		// -> Wrapper Class : 기본 자료형 -> 객체로 포장하는 클래스
		System.out.println(list);
		
		// list의 크기 3 초과해서 추가해도
		// 자동으로 크기가 늘어나기 때문에 에러 발생 X
		list.add("크기 3 초과");
		System.out.println(list);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		System.out.println("------------------------");
		
		// 진짜 자동 포장(Auto Boxing) 되었는가 확인
		System.out.println(list.get(1) instanceof Integer); // true
		System.out.println(list.get(2) instanceof Double); // true
		
		// List + for문 + if + instanceof + 다운캐스팅
		
		// int list.size() : 저장된 객체의 개수를 반환
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i) instanceof String) {
				String str = (String)list.get(i);
				System.out.println("첫 글자 : " + str.charAt(0));
			}
			
			// Auto Unboxing
			if(list.get(i) instanceof Integer) {
				int num = (Integer)list.get(i);
				System.out.println(num + 200);
			}
			
			if(list.get(i) instanceof Double) {
				Double d = (Double)list.get(i); // 다운캐스팅만 진행
				System.out.println(Double.BYTES + "바이트");
									// static 메소드 호출 방법 : 클라스명.변수명
			}
		}
	}
	
	
	public void ex2() {
		// 컬렉션의 장점 중 "여러 타입 저장 가능" 때문에
		// instanceof 로 타입 검사를 해야하는 코드가 추가되어
		// 코드의 길이가 늘어나는 문제점이 발생
		// -> 타입을 하나로 제한하자! 
		// --> Generics(제네릭)을 이용
		
		// String으로 저장되는 타입이 제한된 List
		
		List<String> list = new ArrayList<String>();
		
		list.add("파닭");
		list.add("마파두부");
		list.add("불고기");
		list.add("라멘");
		list.add("서브웨이");
		
		System.out.println(list);
		
		// 중간에 삽입하기: 
		// list.add(int index, E e)
		list.add(0, "짜장면");
		list.add(3, "탕수육");
		
		System.out.println(list);
		
		// 지정된 index의 요소를 바꿈(수정)
		// E list.set(int index, E e) 
		
		String before = list.set(1, "닭갈비");
		System.out.println("before : " + before);
		
		System.out.println(list);
		
		// index 번째 요소를 List에서 제거
		// E lsit.remove(int index);
		// 반환되는 값은 제거된 요소
		String target = list.remove(6);
		System.out.println(target + "제거");
		
		// list에 요소가 포함되어 있는지 확인(true/false)
		// boolean list.contains(E e);
		System.out.println(list.contains("닭갈비"));
		System.out.println(list.contains("파닭"));
		
		// list에 요소가 존재하면 해당 index 반환
		// int list indexOf(E e); 
		// 없으면 -1 반환
		System.out.println( list.indexOf("닭갈비"));
		System.out.println( list.indexOf("파닭"));
		
		System.out.println(list);
		for(int i=0 ; i<list.size(); i++) {
			System.out.printf("[%d] : %s \n", i, list.get(i));
		}
		
		
		
		// 요소 모두 삭제
		// void list.clear();
		list.clear();

		// list가 비어있는지 확인
		// boolean list.isEmpty()
		
		System.out.println(list.isEmpty());
		
	}
}

