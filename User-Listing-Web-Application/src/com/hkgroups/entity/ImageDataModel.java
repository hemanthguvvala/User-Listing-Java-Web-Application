package com.hkgroups.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="imagedata")
@Table(name = "imagedata")
public class ImageDataModel {
	@Id
	@Column(name="image_id")
	int imageid;
	
	@Column(name="image_name")
	String imagename;
	
	@Column(name="lable")
	String imagelable;
	
	@Column(name="description")
	String imagedescription;
	
	public ImageDataModel() {}
	
	
	
	public ImageDataModel(String imagename) {
		super();
		this.imagename = imagename;
	}



//	public ImageDataModel(String imagename, String imagelable, String imagedescription) {
//		super();
//		this.imagename = imagename;
//		this.imagelable = imagelable;
//		this.imagedescription = imagedescription;
//	}

	public int getImageid() {
		return imageid;
	}

	public void setImageid(int imageid) {
		this.imageid = imageid;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getImagelable() {
		return imagelable;
	}

	public void setImagelable(String imagelable) {
		this.imagelable = imagelable;
	}

	public String getImagedescription() {
		return imagedescription;
	}

	public void setImagedescription(String imagedescription) {
		this.imagedescription = imagedescription;
	}



	@Override
	public String toString() {
		return "ImageDataModel [imageid=" + imageid + ", imagename=" + imagename + ", imagelable=" + imagelable
				+ ", imagedescription=" + imagedescription + "]";
	}
	
	
	
}
