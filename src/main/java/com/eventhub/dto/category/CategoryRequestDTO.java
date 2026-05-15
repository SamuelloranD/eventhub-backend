package com.eventhub.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequestDTO(
        @NotBlank @Size(max = 100) String name,
        @Size(max = 255) String description
) {}
