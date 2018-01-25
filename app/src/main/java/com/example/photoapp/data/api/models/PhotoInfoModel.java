package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PhotoInfoModel{

	@SerializedName("stat")
	private String stat;

	@SerializedName("photo")
	private Photo photo;

	public void setStat(String stat){
		this.stat = stat;
	}

	public String getStat(){
		return stat;
	}

	public void setPhoto(Photo photo){
		this.photo = photo;
	}

	public Photo getPhoto(){
		return photo;
	}

	@Override
 	public String toString(){
		return 
			"PhotoInfoModel{" + 
			"stat = '" + stat + '\'' + 
			",photo = '" + photo + '\'' + 
			"}";
		}
}