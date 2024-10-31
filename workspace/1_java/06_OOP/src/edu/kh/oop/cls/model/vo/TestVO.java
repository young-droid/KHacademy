package edu.kh.oop.cls.model.vo;

/*public*/ class TestVO {
// 접근 제한자 (default) : 같은 패키지 내에서만 import가 가능	
	
	public void ex() {
		System.out.println("같은 패키지");
		
		Student std = new Student();
		System.out.println(std.t1);
		System.out.println(std.t2);
		System.out.println(std.t3);
//		System.out.println(std.t4);
		
		
		
	}
	
	
}
