package edu.kh.inheritance.practice.model.service;

import java.util.Scanner;
import edu.kh.inheritance.practice.model.vo.Employee;
import edu.kh.inheritance.practice.model.vo.Student;

public class PracticeService {

    Scanner sc = new Scanner(System.in);
    
    public void homework() {

        // 1. 학생 정보 기록
        Student[] std = new Student[3];
        std[0] = new Student("카리나", 20, 168.2, 70.0, 1, "정보시스템공학과");
        std[1] = new Student("정해인", 21, 187.3, 80.0, 2, "경영학과");
        std[2] = new Student("박서준", 23, 179.0, 45.0, 4, "정보통신공학과");

        System.out.println("===============================================");
        for (Student s : std) {
            System.out.println(s.toString());
        }

        // 2. 사원 정보 기록
        Employee[] emp = new Employee[10];
        int count = 0;

        while (count < emp.length) {
            System.out.println("\n===== 사원 정보 추가 =====");
            
            System.out.print("이름 : ");
            String name = sc.next();
            System.out.print("나이 : ");
            int age = sc.nextInt();
            System.out.print("신장 : ");
            double height = sc.nextDouble();
            System.out.print("몸무게 : ");
            double weight = sc.nextDouble();
            System.out.print("급여 : ");
            int salary = sc.nextInt();
            System.out.print("부서 : ");
            String dept = sc.next();

            emp[count] = new Employee(name, age, height, weight, salary, dept);
            count++;

            char confirm;
            while (true) {
                System.out.print("계속 추가하시겠습니까? (Y / N) : ");
                confirm = sc.next().toUpperCase().charAt(0);
                
                if (confirm == 'Y' || confirm == 'N') {
                    break; // Y나 N 입력 시 반복 종료
                } else {
                    System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
                }
            }
            
            if (confirm == 'N') {
                break; // N 입력 시 전체 입력 종료
            }
        }

        System.out.println("===========================================");
        // 현재 기록된 사원 정보 출력
        for (Employee e : emp) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }
}