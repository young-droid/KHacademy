# KHacademy
--------
<details>
<summary>
2024-10-16
</summary>
eclipse 설치 (파일로 설치) 


* 웹 패키지 이름은 3레벨 이상으로 지을 것
예) edu.kh.basic
edu 하위의 kh 하위의 basic 이라는 패키지. 
배포한 뒤엔 주소가 뒤집어져 나온다. 
예) edu.kh.basic -배포 후-> basic.kh.edu
</details>

--------

<details>
<summary>
2024-10-17
</summary>
* '{' 가 시작되는 줄 맨 앞에 맞춰 '}' 넣기 
* '{' 열고 다음 줄 부터 작성 시 들여쓰기 하고 작성 (보통 자동 들여쓰기 됨) 

## 변수 
- 변하는 수. 메모리(RAM)에 값을 기록하기 위한 공간

  ![image](https://github.com/user-attachments/assets/d632892c-b528-46ce-9688-88bae775300c)

### 기본 자료형 8가지

|자료형|크기|범위| 
|------|-----|-----|
|boolean|1| true, false |
|char|2| 0~65,535(유니코드문자) |
|byte|1| -128 ~ 127 |
|short|2| -32,768 ~ 32,767 |
|int|4| -2,147,483,648 ~ 2,147,483,647 |
|long|8| -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 |
|float|4| ±1.4E-45 ~ 3.4E38 |
|double|8| ±4.9E-324 ~ 1.8E308 |


### 변수 이름 지정 규칙
- 변수 이름 지정 시, 두 단어를 합쳐 사용할 때 두번째 단어는 대문자로 시작
- -> 카멜(Camel) 표기법 : 연결되는 두 단어 중 후속 단어의 첫 문자를 대문자로 표기

![image](https://github.com/user-attachments/assets/9dacc846-97a9-4976-97e2-e73b1622fd12)


#### 자료형, 변수명, 리터럴 예시
```java
		short shortNumber = 32767; 
	  // 자료형    변수명     = 리터럴 값(Data) 
		// ** 리터럴 : 변수에 대입되거나 작성되어지는 값 자체
```

선언 후 초기화
```
int age;
age = 10
```
선언과 동시에 초기화
```
int age = 10;
```

## 형변환 (casting)
- 두 종류 : 자동 형변환, 강제 형변환

### 자동 형변환


### 강제 형변환
몇가지 단점이 있음
- 실수 -> 정수형 변환 시 소수점 버림 처리 (데이터 소실)
``` java
    double dNum = 3.14;
		int iNum = (int)dNum;
		System.out.println(dNum); // 3.14
		System.out.println(iNum); // 3
```
</details>

--------
<details>
<summary>
2024-10-18
</summary>

## 출력메소드
### System.out.print()
- () 안의 변수, 문자, 숫자, 논리 값을 모니터에 출력해주는 메소드
- 줄바꿈 없음
### System.out.println() 
- print문과 동일하게 출력은 해주지만 출력 후 자동으로 출력창에 줄바꿈을 해주는 메소드
- 출력 후 줄바꿈 


### System.out.printf()

#### 줄바꿈 \n 
를 넣어주면 줄바꿈 가능
```java
	// 줄바꿈 (\n)
	int iNum3 = 21;
	System.out.printf("%d\n", iNum3); // 21 -> 출력 후 줄바꿈 (\n)
	System.out.printf("%6d\n", iNum3); // '----21' -> 총 6칸을 확보하고, 오른쪽 정렬 후 줄바꿈
	System.out.printf("%-6d", iNum3); 
	System.out.printf("%d\n", iNum3); // '21----21' -> 먼저 총 6칸을 확보하고, 왼쪽 정렬 후 줄바꿈 없이 다음 라인 출력 
```	

#### 




## escape 문자


## Scanner 
- 사용자로부터 입력되는 정수, 실수, 문자열을 처리하는 클라스
- 프로그램 실행 중 키보드 입력을 받을 수 있게 하는 역할

- 스캐너는 생성 후 사용 


#### 애플리케이션 Application (응용)
입력받은 값에 따라서 결과가 달라지는 것 


</details>

```
package edu.kh.variable;

public class PrintExample {

	public static void main(String[] args) {
		
		// System.out.print() : 단순 출력 (출력 후 줄바꿈 X)
		// System.out.println() : 한 줄 출력 (출력 후 줄바꿈 O)
		// System.out.printf() : 한 줄 출력 (출력 후 줄바꿈 O)
		
		System.out.print("테스트0");
		System.out.println("테스트1");
		System.out.println("테스트2");
		System.out.print("테스트3");
		System.out.println(); // 내용 없는 println -> 줄바꿈 
		System.out.println("테스트4");
		
		System.out.println();
		
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10 + 20 = 30
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1+iNum2));
		

		// 20 + 10 * 10 / 2 = 70
		System.out.println(iNum2 + " + " + iNum1 + " * " + iNum1 + " / 2 = " + (iNum2 + iNum1 * iNum1 / 2));
		
		// System.out.printf("패턴", 패턴에 들어갈 값);
		System.out.printf("%d + %d * %d / %d = %d\n", iNum2, iNum1, iNum1, 2, (iNum2 + iNum1 * iNum1 / 2));
		
		
		// 줄바꿈 (\n)
		int iNum3 = 21;
		System.out.printf("%d\n", iNum3); // 21 -> 출력 후 줄바꿈 (\n)
		System.out.printf("%6d\n", iNum3); // '----21' -> 총 6칸을 확보하고, 오른쪽 정렬 후 줄바꿈
		System.out.printf("%-6d", iNum3); 
		System.out.printf("%d\n", iNum3); // '21----21' -> 먼저 총 6칸을 확보하고, 왼쪽 정렬 후 줄바꿈 없이 다음 라인 출력 
		
		
		// 소수점 자리 제어
		System.out.printf("%f\n", 10 / 3.0); // 3.333333
		System.out.printf("%.2f\n", 10 / 3.0); // 3.33
		System.out.printf("%.0f\n", 10 / 3.0); // 3
		System.out.printf("%.0f\n", 10 / 4.0); // 3 -> 2.5 에서 반올림 처리 됨
	
		
		// 문자, 문자열, boolean
		char ch = 'A';
		String str = "점메추"; // String은 참조형 (기본 자료형을 뺀 나머지)
		boolean isTrue = false; 
		
		System.out.printf("%c / %s / %b \n", ch, str, isTrue);
		
				
		// escape 문자 : 일반 문자가 아닌 특수 문자 표현 시 사용
		// 탈출 문자
		System.out.println("abcd");
		System.out.println("a\tb\tc\td"); // tab 출력
//		System.out.println("\"),("""),("'"); // 오류 
		System.out.println("\\"); // 백슬래시 단순 문자 출력
		System.out.println("\""); // 쌍따옴표 단순 문자 출력
		System.out.println("\' "); // 홑따옴표 단순 문자 출력
		System.out.println('\''); // 홑따옴표 단순 문자 출력
		System.out.println("\u0041"); // 유니코드(16진수)번호로 문자 출력 // A
		
		
		
	}
	
}
```

