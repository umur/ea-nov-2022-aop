package com.example.eanov2022springdataI.repository;

import com.example.eanov2022springdataI.entity.Identifiable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;
import java.util.Optional;

@NoRepositoryBean
public interface CrudRepositoryInterface<T extends Identifiable> extends Repository<T, String> {

    public ArrayList<T> getAll();
    public Optional<T> get(String id);
    public Boolean create(T course);
    public Boolean delete(String id);
    public Boolean update(T course);
}
