package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Tags{

	@SerializedName("tag")
	private List<TagItem> tag;

	public void setTag(List<TagItem> tag){
		this.tag = tag;
	}

	public List<TagItem> getTag(){
		return tag;
	}

	@Override
 	public String toString(){
		return 
			"Tags{" + 
			"tag = '" + tag + '\'' + 
			"}";
		}
}