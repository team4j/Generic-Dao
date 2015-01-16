package com.java.dao.core;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({ "serial", "rawtypes" })
public class EntityPersistListenerAdapter<L extends IEntityPersistListener<E>, E extends IEntity>
		extends HashSet<L> implements IEntityPersistListener<E>, Set<L>
{

	@Override
	public void beforeInsert(E e)
	{
		if (size() > 0)
		{
			for (L l : this)
			{
				l.beforeInsert(e);
			}
		}

	}

	@Override
	public void afterInsert(E e)
	{
		if (size() > 0)
		{
			for (L l : this)
			{
				l.afterInsert(e);
			}
		}
	}

	@Override
	public void beforeDelete(E e)
	{
		if (size() > 0)
		{
			for (L l : this)
			{
				l.beforeDelete(e);
			}
		}
	}

	@Override
	public void afterDelete(E e)
	{
		if (size() > 0)
		{
			for (L l : this)
			{
				l.afterDelete(e);
			}
		}

	}

	@Override
	public void beforeUpdate(E e)
	{
		if (size() > 0)
		{
			for (L l : this)
			{
				l.beforeUpdate(e);
			}
		}

	}

	@Override
	public void afterUpdate(E e)
	{
		if (size() > 0)
		{
			for (L l : this)
			{
				l.afterUpdate(e);
			}
		}

	}

	@Override
	public Class<E> forEntityClass()
	{
		throw new UnsupportedOperationException();
	}

}
