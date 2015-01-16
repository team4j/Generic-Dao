package com.java.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.java.dao.ICompanyDao;
import com.java.dao.IDeptDao;
import com.java.domain.Company;
import com.java.domain.Dept;
import com.java.service.ICompanyService;

@Transactional
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = false)
public class AllTestCase
{
	@Autowired
	ICompanyDao comDao;

	@Autowired
	IDeptDao deptDao;

	@Autowired
	ICompanyService comService;

	@Test
	public void testDao()
	{
		Company com = new Company();
		com.setName("Google");
		comDao.insert(com);

		Dept dept = new Dept();
		dept.setName("PDU");
		dept.setCom(com);
		deptDao.insert(dept);

		Company com1 = new Company();
		com1.setName("Oracle");
		comDao.insert(com1);

		Dept dept1 = new Dept();
		dept1.setName("SDU");
		dept1.setCom(com1);
		deptDao.insert(dept1);

		Assert.notNull(comDao.getAll());

	}

	@Test
	public void testService()
	{
		Company com = new Company();
		com.setName("HUAWEI");

		comService.insert(com);
	}

}
