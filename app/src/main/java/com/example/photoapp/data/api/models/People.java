package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class People{

	@SerializedName("haspeople")
	private int haspeople;

	public void setHaspeople(int haspeople){
		this.haspeople = haspeople;
	}

	public int getHaspeople(){
		return haspeople;
	}

	@Override
 	public String toString(){
		return 
			"People{" + 
			"haspeople = '" + haspeople + '\'' + 
			"}";
		}
}