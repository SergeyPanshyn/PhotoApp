package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class UrlItem{

	@SerializedName("type")
	private String type;

	@SerializedName("_content")
	private String content;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"UrlItem{" + 
			"type = '" + type + '\'' + 
			",_content = '" + content + '\'' + 
			"}";
		}
}