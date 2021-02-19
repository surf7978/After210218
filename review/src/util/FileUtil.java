package util;

import java.io.File;

public class FileUtil {
	public static void main(String[] args) {
		//폴더 생성
		File file = new File("d:/doc/word");
		file.mkdir();
		
		//폴더목록
		File dir =  new File("c:/Dev/eclipse");
		File[] list = dir.listFiles();
		for(File f : list) {
			System.out.println(f.getName()+" : "+f.isFile());
		}
		
		//파일복사
		
	}
}
