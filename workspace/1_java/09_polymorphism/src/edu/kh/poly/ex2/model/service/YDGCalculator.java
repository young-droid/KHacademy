package edu.kh.poly.ex2.model.service;

public class YDGCalculator implements Calculator{

   // extends : 확장하다 / implements : 구현하다
   
   // (부)클래스 - (자)클래스 상속 시 extends(추상 클래스도 포함)
   
   // (부)인터페이스 - (자)클래스 상속시 implements
   
   @Override
   public int plus(int num1, int num2) {
      return num1 + num2;
   }

   @Override
   public int minus(int num1, int num2) {
      return num1 - num2;
   }

   @Override
   public int multiple(int num1, int num2) {
      return num1 * num2;
   }

   @Override
   public int divide(int num1, int num2) {
      return num1 / num2;
   }
   
}