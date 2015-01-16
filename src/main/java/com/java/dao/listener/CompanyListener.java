package com.java.dao.listener;

import org.springframework.stereotype.Repository;

import com.java.dao.core.AbstractEntityPersistListener;
import com.java.domain.Company;

@Repository
public class CompanyListener extends AbstractEntityPersistListener<Company>
{

}
