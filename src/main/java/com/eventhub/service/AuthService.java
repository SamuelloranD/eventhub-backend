package com.eventhub.service;

import com.eventhub.dto.auth.*;

public interface AuthService {
    UserMeResponseDTO register(RegisterRequestDTO request);
    AuthResponseDTO login(LoginRequestDTO request);
    UserMeResponseDTO me();
}
