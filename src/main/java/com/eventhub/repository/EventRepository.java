package com.eventhub.repository;

import com.eventhub.entity.Event;
import com.eventhub.entity.enums.EventStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("""
            select e from Event e
            where (:title is null or lower(e.title) like lower(concat('%', :title, '%')))
              and (:category is null or lower(e.category.name) = lower(:category))
              and (:status is null or e.status = :status)
              and (:location is null or lower(e.location) like lower(concat('%', :location, '%')))
            """)
    Page<Event> search(
            @Param("title") String title,
            @Param("category") String category,
            @Param("status") EventStatus status,
            @Param("location") String location,
            Pageable pageable
    );
}
