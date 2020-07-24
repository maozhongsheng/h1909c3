package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "p_person")
public class Person implements Serializable {
    @Id
    private Integer id;

    @Column(name = "p_name")
    private String pName;

    private String gender;

    @Column(name = "company_id")
    private Integer companyId;
@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date joindate;
@Transient
	private Company company;
	@Transient
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String start;
	@Transient
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String end;

	
	
    public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return p_name
     */
    public String getpName() {
        return pName;
    }

    /**
     * @param pName
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return company_id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return joindate
     */
    public Date getJoindate() {
        return joindate;
    }

    /**
     * @param joindate
     */
    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    @Override
	public String toString() {
		return "Person [id=" + id + ", pName=" + pName + ", gender=" + gender + ", companyId=" + companyId
				+ ", joindate=" + joindate + ", company=" + company + ", start=" + start + ", end=" + end + "]";
	}
}