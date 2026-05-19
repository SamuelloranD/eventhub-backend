package com.eventhub.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request para login")
public record LoginRequestDTO(
        @Schema(example = "john.doe@email.com")
        @NotBlank @Email String email,
        @Schema(example = "StrongPass@123")
        @NotBlank String password
) {}
