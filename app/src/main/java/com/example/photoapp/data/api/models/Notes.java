package com.example.photoapp.data.api.models;

import java.util.List;

public class Notes{
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