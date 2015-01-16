package com.java.dao.impl;

import org.springframework.stereotype.Repository;

import com.java.dao.IDeptDao;
import com.java.dao.core.AbstractDao;
import com.java.domain.Dept;

@Repository
public class DeptDaoImpl extends AbstractDao<Dept, String> implements IDeptDao
{

}
