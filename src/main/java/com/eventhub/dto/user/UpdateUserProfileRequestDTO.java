package com.eventhub.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserProfileRequestDTO(
        @NotBlank @Size(max = 120) String name
) {}
