package com.jun.pojo;

import java.util.Date;

public class Document {
	private Integer id;
    private String title;
    private String filename;
    private String filetype;
    private Long fileytes;
    private String remark;
    private Date createDate;
    private Integer user_id;
    private User user;

	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public Long getFileytes() {
		return fileytes;
	}
	public void setFileytes(Long fileytes) {
		this.fileytes = fileytes;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", filename=" + filename + ", filetype=" + filetype
				+ ", fileytes=" + fileytes + ", remark=" + remark + ", createDate=" + createDate + ", user_id="
				+ user_id + ", user=" + user + "]";
	}
	
}
