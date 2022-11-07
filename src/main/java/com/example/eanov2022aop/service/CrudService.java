package com.example.eanov2022aop.service;

import com.example.eanov2022aop.annotation.ExecutionTime;
import com.example.eanov2022aop.entity.Identifiable;
import com.example.eanov2022aop.repository.CrudRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
public class CrudService<T extends Identifiable, R extends CrudRepositoryInterface<T>> implements CrudServiceInterface<T> {

    final R repository;

    @ExecutionTime
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
