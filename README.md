# KHacademy

#### 2024-10-16
eclipse 설치 (파일로 설치) 


* 웹 패키지 이름은 3레벨 이상으로 지을 것
예) edu.kh.basic
edu 하위의 kh 하위의 basic 이라는 패키지. 
배포한 뒤엔 주소가 뒤집어져 나온다. 
예) edu.kh.basic -배포 후-> basic.kh.edu

#### 2024-10-17

* '{' 가 시작되는 줄 맨 앞에 맞춰 '}' 넣기 
* '{' 열고 다음 줄 부터 작성 시 들여쓰기 하고 작성 (보통 자동 들여쓰기 됨) 

## 변수 
- 변하는 수. 메모리(RAM)에 값을 기록하기 위한 공간

  ![image](https://github.com/user-attachments/assets/d632892c-b528-46ce-9688-88bae775300c)

### 기본 자료형 8가지

|자료형|크기|범위| 
|------|---|---|
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
- 실수 -> 정수형 변환 시 소수점 버림 처리 (데이터 소실)
``` java
    double dNum = 3.14;
		int iNum = (int)dNum;
		System.out.println(dNum); // 3.14
		System.out.println(iNum); // 3
```




