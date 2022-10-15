package com.example.pablex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pablex.models.Consumer;
import com.example.pablex.service.ConsumerService;

@RestController
public class ConsumerController {
    
    @Autowired
    private ConsumerService consumerService;

    @PostMapping(value = "/consumer/")
    public ResponseEntity<Boolean>save(@RequestBody Consumer consumer) {
        try {
            return new ResponseEntity<>(this.consumerService.save(consumer),HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR ConsumerController save :" + e);
            return new ResponseEntity<>(Boolean.FALSE,HttpStatus.EXPECTATION_FAILED);
        }
    }
   
    @PostMapping(value = "/consumers/")
    public ResponseEntity<Boolean> saveAll(@RequestBody List<Consumer> consumers) {
        try {
            return new ResponseEntity<>(this.consumerService.saveAll(consumers),HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR ConsumerController saveAll :" + e);
            return new ResponseEntity<>(Boolean.FALSE,HttpStatus.EXPECTATION_FAILED);
        }
    }
   

    @GetMapping(value="/consumer/{consumerID}/")
    public ResponseEntity<Consumer> findById(@PathVariable("consumerID") int consumerID) {
       try {
            return new ResponseEntity<>(this.consumerService.findById(consumerID),HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR ConsumerController findById :" + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
   
    @GetMapping(value="/consumer/")
    public ResponseEntity<Consumer> findByKey(@RequestParam("consumerKey") String consumerKey) {
       try {
            return new ResponseEntity<>(this.consumerService.findByKey(consumerKey),HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR ConsumerController checkKey :" + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(value="/consumers/")
    public ResponseEntity<List<Consumer>> findAll() {
        try {
            return new ResponseEntity<>(this.consumerService.findAll(),HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR ConsumerController findAll :" + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
   
    @PutMapping(value = "/consumer/")
    public ResponseEntity<Boolean> update(@RequestBody Consumer consumer) {
        try {
            return new ResponseEntity<>(this.consumerService.update(consumer),HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR ConsumerController update :" + e);
            return new ResponseEntity<>(Boolean.FALSE,HttpStatus.EXPECTATION_FAILED);
        }
    }
   
    @PutMapping(value = "/consumer/{consumerID}/")
    public ResponseEntity<Boolean> updateCheckByID(@PathVariable("consumerID") int consumerID,@RequestParam("isCheck") boolean isCheck) {
        try {
            return new ResponseEntity<>(this.consumerService.updateCheckByID(consumerID,isCheck),HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR ConsumerController updateCheckByID :" + e);
            return new ResponseEntity<>(Boolean.FALSE,HttpStatus.EXPECTATION_FAILED);
        }
    }


    @DeleteMapping(value="/consumer/{consumerID}/")
    public ResponseEntity<Boolean> deleteByID(@PathVariable("consumerID") int consumerID) {
        try {
            return new ResponseEntity<>(this.consumerService.deleteByID(consumerID),HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR ConsumerController deleteByID :" + e);
            return new ResponseEntity<>(Boolean.FALSE,HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping(value="/consumers/")
    public ResponseEntity<Boolean> deleteAll() {
        try {
            return new ResponseEntity<>(this.consumerService.deleteAll(),HttpStatus.OK);
        } catch(Exception e) {
            System.out.println("ERROR ConsumerController deleteAll :" + e);
            return new ResponseEntity<>(Boolean.FALSE,HttpStatus.EXPECTATION_FAILED);
        }
    }
   
}