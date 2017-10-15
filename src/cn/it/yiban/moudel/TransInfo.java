package cn.it.yiban.moudel;

import java.util.Date;

public class TransInfo {
	
	private Integer id;
	private String name;
	private Integer sex;
	private String nature;
	private String home_place;
	private Long birthday;
	private Long schoolday;
	private String department;
	private String clazz;
	private Integer xuezhi;
	private String stuid;
	private String phone;
	private String addr;
	private String train;
	private String reason;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getHome_place() {
		return home_place;
	}
	public void setHome_place(String home_place) {
		this.home_place = home_place;
	}
	public Long getBirthday() {
		return birthday;
	}
	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}
	public Long getSchoolday() {
		return schoolday;
	}
	public void setSchoolday(Long schoolday) {
		this.schoolday = schoolday;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public Integer getXuezhi() {
		return xuezhi;
	}
	public void setXuezhi(Integer xuezhi) {
		this.xuezhi = xuezhi;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTrain() {
		return train;
	}
	public void setTrain(String train) {
		this.train = train;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public TransInfo(String name, Integer sex, String nature, String home_place, Long birthday, Long schoolday,
			String department, String clazz, Integer xuezhi, String stuid, String phone, String addr, String train,
			String reason) {
		super();
		this.name = name;
		this.sex = sex;
		this.nature = nature;
		this.home_place = home_place;
		this.birthday = birthday;
		this.schoolday = schoolday;
		this.department = department;
		this.clazz = clazz;
		this.xuezhi = xuezhi;
		this.stuid = stuid;
		this.phone = phone;
		this.addr = addr;
		this.train = train;
		this.reason = reason;
	}
	
	
}
