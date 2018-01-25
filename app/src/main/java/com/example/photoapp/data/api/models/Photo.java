package com.example.photoapp.data.api.models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Photo{

	@SerializedName("server")
	private String server;

	@SerializedName("dateuploaded")
	private String dateuploaded;

	@SerializedName("notes")
	private Notes notes;

	@SerializedName("safety_level")
	private String safetyLevel;

	@SerializedName("usage")
	private Usage usage;

	@SerializedName("description")
	private Description description;

	@SerializedName("secret")
	private String secret;

	@SerializedName("media")
	private String media;

	@SerializedName("title")
	private Title title;

	@SerializedName("urls")
	private Urls urls;

	@SerializedName("editability")
	private Editability editability;

	@SerializedName("originalsecret")
	private String originalsecret;

	@SerializedName("farm")
	private int farm;

	@SerializedName("id")
	private String id;

	@SerializedName("views")
	private String views;

	@SerializedName("owner")
	private Owner owner;

	@SerializedName("comments")
	private Comments comments;

	@SerializedName("visibility")
	private Visibility visibility;

	@SerializedName("publiceditability")
	private Publiceditability publiceditability;

	@SerializedName("rotation")
	private int rotation;

	@SerializedName("dates")
	private Dates dates;

	@SerializedName("people")
	private People people;

	@SerializedName("tags")
	private Tags tags;

	@SerializedName("license")
	private String license;

	@SerializedName("originalformat")
	private String originalformat;

	@SerializedName("isfavorite")
	private int isfavorite;

	public void setServer(String server){
		this.server = server;
	}

	public String getServer(){
		return server;
	}

	public void setDateuploaded(String dateuploaded){
		this.dateuploaded = dateuploaded;
	}

	public String getDateuploaded(){
		return dateuploaded;
	}

	public void setNotes(Notes notes){
		this.notes = notes;
	}

	public Notes getNotes(){
		return notes;
	}

	public void setSafetyLevel(String safetyLevel){
		this.safetyLevel = safetyLevel;
	}

	public String getSafetyLevel(){
		return safetyLevel;
	}

	public void setUsage(Usage usage){
		this.usage = usage;
	}

	public Usage getUsage(){
		return usage;
	}

	public void setDescription(Description description){
		this.description = description;
	}

	public Description getDescription(){
		return description;
	}

	public void setSecret(String secret){
		this.secret = secret;
	}

	public String getSecret(){
		return secret;
	}

	public void setMedia(String media){
		this.media = media;
	}

	public String getMedia(){
		return media;
	}

	public void setTitle(Title title){
		this.title = title;
	}

	public Title getTitle(){
		return title;
	}

	public void setUrls(Urls urls){
		this.urls = urls;
	}

	public Urls getUrls(){
		return urls;
	}

	public void setEditability(Editability editability){
		this.editability = editability;
	}

	public Editability getEditability(){
		return editability;
	}

	public void setOriginalsecret(String originalsecret){
		this.originalsecret = originalsecret;
	}

	public String getOriginalsecret(){
		return originalsecret;
	}

	public void setFarm(int farm){
		this.farm = farm;
	}

	public int getFarm(){
		return farm;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setViews(String views){
		this.views = views;
	}

	public String getViews(){
		return views;
	}

	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
	}

	public void setComments(Comments comments){
		this.comments = comments;
	}

	public Comments getComments(){
		return comments;
	}

	public void setVisibility(Visibility visibility){
		this.visibility = visibility;
	}

	public Visibility getVisibility(){
		return visibility;
	}

	public void setPubliceditability(Publiceditability publiceditability){
		this.publiceditability = publiceditability;
	}

	public Publiceditability getPubliceditability(){
		return publiceditability;
	}

	public void setRotation(int rotation){
		this.rotation = rotation;
	}

	public int getRotation(){
		return rotation;
	}

	public void setDates(Dates dates){
		this.dates = dates;
	}

	public Dates getDates(){
		return dates;
	}

	public void setPeople(People people){
		this.people = people;
	}

	public People getPeople(){
		return people;
	}

	public void setTags(Tags tags){
		this.tags = tags;
	}

	public Tags getTags(){
		return tags;
	}

	public void setLicense(String license){
		this.license = license;
	}

	public String getLicense(){
		return license;
	}

	public void setOriginalformat(String originalformat){
		this.originalformat = originalformat;
	}

	public String getOriginalformat(){
		return originalformat;
	}

	public void setIsfavorite(int isfavorite){
		this.isfavorite = isfavorite;
	}

	public int getIsfavorite(){
		return isfavorite;
	}

	@Override
 	public String toString(){
		return 
			"Photo{" + 
			"server = '" + server + '\'' + 
			",dateuploaded = '" + dateuploaded + '\'' + 
			",notes = '" + notes + '\'' + 
			",safety_level = '" + safetyLevel + '\'' + 
			",usage = '" + usage + '\'' + 
			",description = '" + description + '\'' + 
			",secret = '" + secret + '\'' + 
			",media = '" + media + '\'' + 
			",title = '" + title + '\'' + 
			",urls = '" + urls + '\'' + 
			",editability = '" + editability + '\'' + 
			",originalsecret = '" + originalsecret + '\'' + 
			",farm = '" + farm + '\'' + 
			",id = '" + id + '\'' + 
			",views = '" + views + '\'' + 
			",owner = '" + owner + '\'' + 
			",comments = '" + comments + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",publiceditability = '" + publiceditability + '\'' + 
			",rotation = '" + rotation + '\'' + 
			",dates = '" + dates + '\'' + 
			",people = '" + people + '\'' + 
			",tags = '" + tags + '\'' + 
			",license = '" + license + '\'' + 
			",originalformat = '" + originalformat + '\'' + 
			",isfavorite = '" + isfavorite + '\'' + 
			"}";
		}
}