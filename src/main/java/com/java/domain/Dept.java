package com.java.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.java.dao.core.StringIdEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_DEPT")
public class Dept extends StringIdEntity
{
	@Column
	private String name;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "comId")
	private Company com;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Company getCom()
	{
		return com;
	}

	public void setCom(Company com)
	{
		this.com = com;
	}

}
