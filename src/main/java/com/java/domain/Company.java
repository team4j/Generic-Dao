package com.java.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.java.dao.core.StringIdEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_COMPANY")
public class Company extends StringIdEntity
{
	@Column
	private String name;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "com")
	private List<Dept> depts = new ArrayList<Dept>();

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Dept> getDepts()
	{
		return depts;
	}

	public void setDepts(List<Dept> depts)
	{
		this.depts = depts;
	}

}
