package com.example.photoapp.data.api.models;

public class Comments{
	private int content;

	public void setContent(int content){
		this.content = content;
	}

	public int getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"Comments{" + 
			"_content = '" + content + '\'' + 
			"}";
		}
}
