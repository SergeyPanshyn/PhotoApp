package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Visibility{

	@SerializedName("ispublic")
	private int ispublic;

	@SerializedName("isfriend")
	private int isfriend;

	@SerializedName("isfamily")
	private int isfamily;

	public void setIspublic(int ispublic){
		this.ispublic = ispublic;
	}

	public int getIspublic(){
		return ispublic;
	}

	public void setIsfriend(int isfriend){
		this.isfriend = isfriend;
	}

	public int getIsfriend(){
		return isfriend;
	}

	public void setIsfamily(int isfamily){
		this.isfamily = isfamily;
	}

	public int getIsfamily(){
		return isfamily;
	}

	@Override
 	public String toString(){
		return 
			"Visibility{" + 
			"ispublic = '" + ispublic + '\'' + 
			",isfriend = '" + isfriend + '\'' + 
			",isfamily = '" + isfamily + '\'' + 
			"}";
		}
}