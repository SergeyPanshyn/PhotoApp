package com.example.photoapp.data.api.models;

import java.util.List;

public class Urls{
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