package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Usage{

	@SerializedName("canshare")
	private int canshare;

	@SerializedName("canprint")
	private int canprint;

	@SerializedName("canblog")
	private int canblog;

	@SerializedName("candownload")
	private int candownload;

	public void setCanshare(int canshare){
		this.canshare = canshare;
	}

	public int getCanshare(){
		return canshare;
	}

	public void setCanprint(int canprint){
		this.canprint = canprint;
	}

	public int getCanprint(){
		return canprint;
	}

	public void setCanblog(int canblog){
		this.canblog = canblog;
	}

	public int getCanblog(){
		return canblog;
	}

	public void setCandownload(int candownload){
		this.candownload = candownload;
	}

	public int getCandownload(){
		return candownload;
	}

	@Override
 	public String toString(){
		return 
			"Usage{" + 
			"canshare = '" + canshare + '\'' + 
			",canprint = '" + canprint + '\'' + 
			",canblog = '" + canblog + '\'' + 
			",candownload = '" + candownload + '\'' + 
			"}";
		}
}