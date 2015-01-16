package com.java.dao.core;

import java.io.Serializable;

public interface IEntity<PK extends Serializable> extends Serializable
{
	PK getId();
}
