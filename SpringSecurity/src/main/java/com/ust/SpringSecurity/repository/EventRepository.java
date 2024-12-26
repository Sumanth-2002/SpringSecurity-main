package com.ust.SpringSecurity.repository;

import com.ust.SpringSecurity.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
