package stream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class WriteExample {

	public static void main(String[] args) throws IOException {

		Reader reader = new FileReader("C:\\java_se\\streamTest\\stream.txt");
		
		char[] buffer = new char[100];
		
		while(true) {
			int readCharNum = reader.read(buffer);
			if(readCharNum == -1)break;
			for(int i = 0; i < readCharNum; i++) {
				System.out.print(buffer[i]);
			}
		}
		
		reader.close();
		
		
		
		
	}
}
