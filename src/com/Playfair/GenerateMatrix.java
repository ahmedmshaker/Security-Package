package com.Playfair;

public class GenerateMatrix {

	String key;
	char [] [] matrix= new char[5][5];
	public static String alpha="abcdefghiklmnopqrstuvwxyz";
	int index=0,alpha_index=0;
	
	public GenerateMatrix(String key){
		this.key = key;
	}
	
	public char [][] keyMatrix(){
		String str=replacestr();
		//System.out.println(str);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(index<key.length()){
				matrix[i][j]=key.charAt(index);
				index++;
				}
				else{
						matrix[i][j]=str.charAt(alpha_index);
						alpha_index++;
				}
			}
			
		}
		return matrix;
	}
	public String replacestr (){
		index=0;
		String new_string="";
		for (int i = 0; i < alpha.length(); i++) {
			if(!key.contains(alpha.charAt(i)+"")){
				new_string=new_string+alpha.charAt(i);
				new_string.replace('j', 'i');
			}
		}
		return new_string;
	}
}
