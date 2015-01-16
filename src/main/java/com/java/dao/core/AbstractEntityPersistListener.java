package com.java.dao.core;

import java.lang.reflect.ParameterizedType;

@SuppressWarnings("rawtypes")
public class AbstractEntityPersistListener<E extends IEntity> implements
		IEntityPersistListener<E>
{

	@Override
	public void beforeInsert(E e)
	{
		System.out.println("***********before************");

		// TODO Auto-generated method stub
	}

	@Override
	public void afterInsert(E e)
	{
		System.out.println("***********after************");

		// TODO Auto-generated method stub
	}

	@Override
	public void beforeDelete(E e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void afterDelete(E e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void beforeUpdate(E e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void afterUpdate(E e)
	{
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<E> forEntityClass()
	{
		return (Class<E>) ((ParameterizedType) (this.getClass()
				.getGenericSuperclass())).getActualTypeArguments()[0];
	}

}
