package com.linkomanija.backend.database;


import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataPopulation {
  @EventListener
  public void onApplicationEvent(ContextRefreshedEvent event) {

  }
}
