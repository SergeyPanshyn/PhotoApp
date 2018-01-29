package com.example.photoapp.data.api.models;

import java.util.List;

public class Tags{
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