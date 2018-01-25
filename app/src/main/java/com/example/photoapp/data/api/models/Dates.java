package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Dates{

	@SerializedName("taken")
	private String taken;

	@SerializedName("takengranularity")
	private int takengranularity;

	@SerializedName("lastupdate")
	private String lastupdate;

	@SerializedName("takenunknown")
	private String takenunknown;

	@SerializedName("posted")
	private String posted;

	public void setTaken(String taken){
		this.taken = taken;
	}

	public String getTaken(){
		return taken;
	}

	public void setTakengranularity(int takengranularity){
		this.takengranularity = takengranularity;
	}

	public int getTakengranularity(){
		return takengranularity;
	}

	public void setLastupdate(String lastupdate){
		this.lastupdate = lastupdate;
	}

	public String getLastupdate(){
		return lastupdate;
	}

	public void setTakenunknown(String takenunknown){
		this.takenunknown = takenunknown;
	}

	public String getTakenunknown(){
		return takenunknown;
	}

	public void setPosted(String posted){
		this.posted = posted;
	}

	public String getPosted(){
		return posted;
	}

	@Override
 	public String toString(){
		return 
			"Dates{" + 
			"taken = '" + taken + '\'' + 
			",takengranularity = '" + takengranularity + '\'' + 
			",lastupdate = '" + lastupdate + '\'' + 
			",takenunknown = '" + takenunknown + '\'' + 
			",posted = '" + posted + '\'' + 
			"}";
		}
}