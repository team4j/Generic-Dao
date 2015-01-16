package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.ICompanyDao;
import com.java.dao.core.IDao;
import com.java.domain.Company;
import com.java.service.ICompanyService;
import com.java.service.core.AbstractService;

@Transactional
@Service
public class CompanyServiceImpl extends AbstractService<Company, String> implements ICompanyService
{

	@Autowired
	private ICompanyDao comDao;

	@Override
	protected IDao<Company, String> getDao()
	{
		return this.comDao;
	}

}
