package com.example.springbootdocker.service;

import com.example.springbootdocker.entity.UserEntity;
import com.example.springbootdocker.repository.UserRepository;
import com.opencsv.CSVReader;


import javax.annotation.PostConstruct;

import io.swagger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class CsvImportService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void importCsvData() {
        System.out.println("I am definitely running");
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/users.csv"))) {
            List<String[]> rows = reader.readAll();
            for (String[] row : rows) {
                UserEntity user = new UserEntity();
                user.setName(row[0]);
                user.setEmail(row[1]);
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
