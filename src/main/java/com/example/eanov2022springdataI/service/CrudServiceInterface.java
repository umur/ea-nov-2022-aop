package com.example.eanov2022springdataI.service;

import com.example.eanov2022springdataI.entity.Identifiable;

import java.util.ArrayList;
import java.util.Optional;

public interface CrudServiceInterface<T extends Identifiable> {

    public ArrayList<T> getAll();
    public Optional<T> get(String id);
    public Boolean delete(String id);
    public Boolean update(T data);
    public Boolean create(T data);
}
