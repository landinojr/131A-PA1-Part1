package cs131.pa1.commands;

import cs131.pa1.filter.sequential.SequentialFilter;

public class OutPrinter extends SequentialFilter{

	private boolean standardError = false;
	private String errorMessage;
 	
 	public OutPrinter() {
 		super();
 	}
 	
 	public OutPrinter(String errorMessage) {
 		standardError = true;
 		this.errorMessage = errorMessage;	
 	}
 	
 	@Override
 	public void process() {
 		if (standardError) {
 			System.out.println(errorMessage);
 		} else {
 			super.process();
 		}
 	}
 	
 	public boolean isStandardError() {
 		return standardError;
 	}
 	
 	
 	@Override
 	protected String processLine(String line) {
 		System.out.println(line);
 		return null;
 	}	
 }

