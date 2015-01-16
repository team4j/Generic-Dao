package com.java.service.core;

import java.io.Serializable;
import java.util.List;

import com.java.dao.core.IDao;
import com.java.dao.core.IEntity;

/**
 * 
 * @author QUAN
 * @date 2015年1月16日
 * @time 下午10:39:16
 * @param <E>
 * @param <PK>
 */
public abstract class AbstractService<E extends IEntity<PK>, PK extends Serializable> implements IService<E, PK>
{
	protected abstract IDao<E, PK> getDao();

	@Override
	public void insert(E e)
	{
		this.getDao().insert(e);
	}

	@Override
	public void delete(E e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(PK pk)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void update(E e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public E get(PK pk)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
