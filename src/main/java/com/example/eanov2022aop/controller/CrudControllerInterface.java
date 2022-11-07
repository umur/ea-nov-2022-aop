package com.example.eanov2022aop.controller;


import com.example.eanov2022aop.entity.Identifiable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface CrudControllerInterface<T extends Identifiable> {


    public ResponseEntity<List<T>> getAll();
    public ResponseEntity<T> get(@PathVariable String id);
    public ResponseEntity<Boolean> create(@RequestBody T data);
    public ResponseEntity<Boolean> delete(@PathVariable String id);
    public ResponseEntity<Boolean> update(@RequestBody T data);
}
