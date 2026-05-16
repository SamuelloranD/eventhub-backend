package com.eventhub.service;

import com.eventhub.dto.event.EventRequestDTO;
import com.eventhub.dto.event.EventResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {
    Page<EventResponseDTO> findAll(String title, String category, String status, String location, Pageable pageable);
    EventResponseDTO findById(Long id);
    EventResponseDTO create(EventRequestDTO request);
    EventResponseDTO update(Long id, EventRequestDTO request);
    void delete(Long id);
}
