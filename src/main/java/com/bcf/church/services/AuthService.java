package com.bcf.church.services;

import com.bcf.church.payloads.LoginDto;
import com.bcf.church.payloads.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}