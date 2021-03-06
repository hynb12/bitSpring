package com.bitcamp.op.member.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {

	private int idx;
	private String userId;
	private String password;
	private String userName;
	private String userPhoto; // DB에 저장할 파일 이름
	private MultipartFile photoFile; // form 이름과 일치

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", userId=" + userId + ", password=" + password + ", userName=" + userName
				+ ", userPhoto=" + userPhoto + ", photoFile=" + photoFile + "]";
	}

	public MemberInfo(int idx, String userId, String password, String userName, String userPhoto,
			MultipartFile photoFile) {
		super();
		this.idx = idx;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.photoFile = photoFile;
	}

	public MemberInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}