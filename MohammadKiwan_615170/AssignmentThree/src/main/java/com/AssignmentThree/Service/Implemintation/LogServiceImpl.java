package com.AssignmentThree.Service.Implemintation;

import com.AssignmentThree.Entities.Log;
import com.AssignmentThree.Reposotory.LogRepo;
import com.AssignmentThree.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogRepo logrepo;

    @Override
    public void save(Log log){
        logrepo.save(log);
    }
}
