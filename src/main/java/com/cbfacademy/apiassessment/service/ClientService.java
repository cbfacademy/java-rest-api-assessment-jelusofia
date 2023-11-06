package com.cbfacademy.apiassessment.service;

import com.cbfacademy.apiassessment.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.dao.ClientDao;

@Service
public class ClientService {
    private final ClientDao clientDao;

    @Autowired
    public ClientService(@Qualifier("Dao") ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public int addClient(Client client){
        return  clientDao.insertClient(client);
        //id double check 21:00 timestamp
    }
}
