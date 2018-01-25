package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Urls{

	@SerializedName("url")
	private List<UrlItem> url;

	public void setUrl(List<UrlItem> url){
		this.url = url;
	}

	public List<UrlItem> getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Urls{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}