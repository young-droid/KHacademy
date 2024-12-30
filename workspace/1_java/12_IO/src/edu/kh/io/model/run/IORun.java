package edu.kh.io.model.run;

import edu.kh.io.model.service.IOService;
import edu.kh.io.model.service.IOService_practice;

public class IORun {
	public static void main(String[] args) {
		
		IOService service = new IOService();
		
//		service.byteOutput();
//		service.charOutput();
//		service.byteInput();
//		service.charInput();
//		service.fileCopy();
//		service.objectOutput();
		service.objectInput();
		
//		service.listOutput();
//		service.listInput();
		
		
		IOService_practice service_p = new IOService_practice();

//		service_p.byteOutput();
		
		
	}
	
}
