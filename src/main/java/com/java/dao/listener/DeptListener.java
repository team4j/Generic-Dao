package com.java.dao.listener;

import org.springframework.stereotype.Repository;

import com.java.dao.core.AbstractEntityPersistListener;
import com.java.domain.Dept;

@Repository
public class DeptListener extends AbstractEntityPersistListener<Dept>
{

}
