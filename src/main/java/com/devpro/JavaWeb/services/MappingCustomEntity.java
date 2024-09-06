package com.devpro.JavaWeb.services;

import com.devpro.JavaWeb.model.BaseEntity;

public interface MappingCustomEntity<E extends BaseEntity> {
	public E convert(Object[] data);
}
