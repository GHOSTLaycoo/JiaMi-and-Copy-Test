package unit1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class CopyDemo2 {


	private static long h;

	public static void main(String[] args) throws IOException {
		 Scanner sc = new Scanner(System.in);
	        System.out.println("请输入源目录：");
	        String sourcePath = sc.nextLine();
	        System.out.println("请输入新目录：");
	        String path = sc.nextLine();
	        
	        //String sourcePath = "D://aa";
	        //String path = "D://bb";
	        
	        copyDir(sourcePath, path);
	        
	     
	        System.out.println("总耗时："+h+"ms");
	        
	}
	
	public static void copyDir(String oldPath, String newPath) throws IOException {
        File file = new File(oldPath);
        String[] filePath = file.list();
        
        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }
        
        for (int i = 0; i < filePath.length; i++) {
			if ((new File(oldPath + file.separator + filePath[i])).isDirectory()) {
                copyDir(oldPath  + file.separator  + filePath[i], newPath  + file.separator + filePath[i]);
            }
            
            if (new File(oldPath  + file.separator + filePath[i]).isFile()) {
                copyFile(oldPath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }
            
        }
    }
	
	public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        RandomAccessFile src = new RandomAccessFile(oldFile,"r");
		RandomAccessFile desc = new RandomAccessFile(file,"rw");
        
        byte[] buf = new byte[1024*100];
		int len = -1;
		long start = System.currentTimeMillis();
		while((len = src.read(buf))!=-1) {
			desc.write(buf,0,len);
		}
		long end = System.currentTimeMillis();
		
		long s = (end-start);
		System.out.println("耗时："+s+"ms");
		
		
		src.close();
		desc.close();
		
	       h+=s;
	   }

}
