package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Notes{

	@SerializedName("note")
	private List<Object> note;

	public void setNote(List<Object> note){
		this.note = note;
	}

	public List<Object> getNote(){
		return note;
	}

	@Override
 	public String toString(){
		return 
			"Notes{" + 
			"note = '" + note + '\'' + 
			"}";
		}
}