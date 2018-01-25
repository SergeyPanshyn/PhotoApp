package com.example.photoapp.data.api.models;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class TagItem{

	@SerializedName("author")
	private String author;

	@SerializedName("machine_tag")
	private boolean machineTag;

	@SerializedName("authorname")
	private String authorname;

	@SerializedName("raw")
	private String raw;

	@SerializedName("id")
	private String id;

	@SerializedName("_content")
	private String content;

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setMachineTag(boolean machineTag){
		this.machineTag = machineTag;
	}

	public boolean isMachineTag(){
		return machineTag;
	}

	public void setAuthorname(String authorname){
		this.authorname = authorname;
	}

	public String getAuthorname(){
		return authorname;
	}

	public void setRaw(String raw){
		this.raw = raw;
	}

	public String getRaw(){
		return raw;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"TagItem{" + 
			"author = '" + author + '\'' + 
			",machine_tag = '" + machineTag + '\'' + 
			",authorname = '" + authorname + '\'' + 
			",raw = '" + raw + '\'' + 
			",id = '" + id + '\'' + 
			",_content = '" + content + '\'' + 
			"}";
		}
}