/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rabbitmqApp.rabbitmq.Controller;

import com.rabbitmqApp.rabbitmq.Producer.Producer;
import com.rabbitmqApp.rabbitmq.consumer.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq/")
public class Controller {

   @Autowired
   private Producer producer;

   @Autowired
   private Consumer consumer;

  @PostMapping(value ="/producer/{message}")
  public ResponseEntity<String> sendMessage(@PathVariable(value = "message") String message) throws Exception {
       producer.sendMsg(message);
       return new ResponseEntity<>("send message successfuly ",HttpStatus.OK);
  }


  @GetMapping(value = "/consumer/{message}", produces ="application/json")
  public String getMessage(@PathVariable(value = "message") String message) throws Exception {  
    return consumer.receiveMsg(message);
  }
    
}
