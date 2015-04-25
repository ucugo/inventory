package com.ugo.uchegbu.repository;

import com.ugo.uchegbu.model.BaseModel;

import java.util.List;

/**
 * Created by Ugo on 12/04/2015.
 */
public abstract class BaseRepository<T extends BaseModel> {

    public abstract T save(T t);

    public abstract List<T> findAll();

    public abstract T update(T t);
}
