package edu.kh.collection.list.run;

import edu.kh.collection.list.model.service.StudentService;
import edu.kh.collection.list.view.StudentView;

public class StudentRun {

	public static void main(String[] args) {

		StudentService service = new StudentService();

		StudentView view = new StudentView();

		view.displayMenu();

	}

}
