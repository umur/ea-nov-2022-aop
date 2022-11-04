package com.example.eanov2022springdataI.service;

import com.example.eanov2022springdataI.entity.Identifiable;
import com.example.eanov2022springdataI.repository.CrudRepository;
import com.example.eanov2022springdataI.repository.CrudRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
public class CrudService<T extends Identifiable, R extends CrudRepositoryInterface<T>> implements CrudServiceInterface<T> {

    final R repository;

    public ArrayList<T> getAll(){
        return repository.getAll();
    }

    public Optional<T> get(String id){
        return repository.get(id);
    }

    public Boolean delete(String id){
        return repository.delete(id);
    }

    public Boolean update(T data){
        return repository.update(data);
    }

    public Boolean create(T data){
        return repository.create(data);
    }




}
