package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;



public class TestArray {

	
	private static long h;

	public static  void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("������Ҫ���ܵ��ı���ַ");
		String path = scan.nextLine();
		
		Reader file = new FileReader(path);
	
		/*Scanner myin=new Scanner(System.in);
		System.out.println("������Ҫ���ܵ�����");
		String password=myin.nextLine();
		*/
		String filecontent = readFileContent(file);
		
		char[] array=filecontent.toCharArray();
		for(int i=0;i<array.length;i++){
			array[i]=(char)(array[i]^1);
			}
		String s = new String(array);
		FileWriter fw = new FileWriter(path);
		
		fw.write(s,0,s.length());
		fw.flush();
		System.out.println("��Ϣ���ܺ���ʾ���£�");
		System.out.println(s);
		
		for(int i=0;i<array.length;i++){
			array[i]=(char)(array[i]^1);
			}
		System.out.println("���ܺ���ʾ���£�");
        System.out.println(new String(array)); 

	}
	
	

	public static String readFileContent(Reader file) throws IOException {
	
		BufferedReader buf = new BufferedReader(file);
		StringBuilder sb = new StringBuilder();
		
		String s;
		while((s=buf.readLine())!=null) {
			sb.append(s);
			System.out.println(s);
		}
		return sb.toString();
	}
	

}
