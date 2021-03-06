package com.example.photoapp.data.api.models;

public class Owner{
	private String nsid;
	private int iconfarm;
	private String pathAlias;
	private String iconserver;
	private String location;
	private String username;
	private String realname;

	public void setNsid(String nsid){
		this.nsid = nsid;
	}

	public String getNsid(){
		return nsid;
	}

	public void setIconfarm(int iconfarm){
		this.iconfarm = iconfarm;
	}

	public int getIconfarm(){
		return iconfarm;
	}

	public void setPathAlias(String pathAlias){
		this.pathAlias = pathAlias;
	}

	public String getPathAlias(){
		return pathAlias;
	}

	public void setIconserver(String iconserver){
		this.iconserver = iconserver;
	}

	public String getIconserver(){
		return iconserver;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setRealname(String realname){
		this.realname = realname;
	}

	public String getRealname(){
		return realname;
	}

	@Override
 	public String toString(){
		return 
			"Owner{" + 
			"nsid = '" + nsid + '\'' + 
			",iconfarm = '" + iconfarm + '\'' + 
			",path_alias = '" + pathAlias + '\'' + 
			",iconserver = '" + iconserver + '\'' + 
			",location = '" + location + '\'' + 
			",username = '" + username + '\'' + 
			",realname = '" + realname + '\'' + 
			"}";
		}
}
