package com.smartcity.smartcityguide.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcity.smartcityguide.entity.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

    List<Event> findByCity(String city);

    List<Event> findByCategory(String category);

    List<Event> findByCityAndCategory(String city, String category);

}