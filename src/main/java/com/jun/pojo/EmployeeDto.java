package com.jun.pojo;

public class EmployeeDto {
	// 页码
    private Integer pageIndex;
    // 名称
    private String name;
    // 职位id
    private Integer jobId;
    // 部门id
    private Integer deptId;
    // 身份证
    private String cardId;
    // 性别
    private Integer sex;
    // 电话号
    private String phone;
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "EmployeeDto [pageIndex=" + pageIndex + ", name=" + name + ", jobId=" + jobId + ", deptId=" + deptId
				+ ", cardId=" + cardId + ", sex=" + sex + ", phone=" + phone + "]";
	}
    
}
