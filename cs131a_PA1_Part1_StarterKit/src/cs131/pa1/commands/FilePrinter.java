package cs131.pa1.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import cs131.pa1.filter.sequential.SequentialFilter;
import cs131.pa1.filter.sequential.SequentialREPL;

public class FilePrinter extends SequentialFilter {
	
	
		private PrintStream printWriter;
		
		public FilePrinter(String outputFileName){
			try {
				String cwd = SequentialREPL.getCurrentDir();
				
				File f = new File(cwd + "/" + outputFileName);
				printWriter = new PrintStream(f);
			} catch (FileNotFoundException e) {
	 			// We should never get to this point, as we are creating a
	 			// new file for the purposes of printing, worst case we 
	 			// overwrite.
	 		}	
	 	}
	 	
	 	@Override
	 	protected String processLine(String line) {
	 		printWriter.println(line);
	 		isDone();
	 		return null;
	 	}
	 	
	 	public boolean isDone(){
	 		if (input.isEmpty()){
	 			printWriter.close();
	 			return true;
	 		}
	 		return false;
	 	}
	}