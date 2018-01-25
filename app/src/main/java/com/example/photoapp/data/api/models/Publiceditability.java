package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Publiceditability{

	@SerializedName("cancomment")
	private int cancomment;

	@SerializedName("canaddmeta")
	private int canaddmeta;

	public void setCancomment(int cancomment){
		this.cancomment = cancomment;
	}

	public int getCancomment(){
		return cancomment;
	}

	public void setCanaddmeta(int canaddmeta){
		this.canaddmeta = canaddmeta;
	}

	public int getCanaddmeta(){
		return canaddmeta;
	}

	@Override
 	public String toString(){
		return 
			"Publiceditability{" + 
			"cancomment = '" + cancomment + '\'' + 
			",canaddmeta = '" + canaddmeta + '\'' + 
			"}";
		}
}