package com.example.photoapp.data.api.models;

public class Title{
	private String content;

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"Title{" + 
			"_content = '" + content + '\'' + 
			"}";
		}
}
