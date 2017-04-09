package com.theironyard.novauc.services;

import com.theironyard.novauc.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jerieshasmith on 3/22/17.
 */
public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findAllByOrderByDateTimeDesc();

}
