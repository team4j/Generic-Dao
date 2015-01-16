package com.java.dao.impl;

import org.springframework.stereotype.Repository;

import com.java.dao.ICompanyDao;
import com.java.dao.core.AbstractDao;
import com.java.domain.Company;

@Repository
public class CompanyDaoImpl extends AbstractDao<Company, String> implements
		ICompanyDao
{

}
