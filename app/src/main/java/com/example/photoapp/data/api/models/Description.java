package com.example.photoapp.data.api.models;

public class Description{
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
			"Description{" + 
			"_content = '" + content + '\'' + 
			"}";
		}
}
