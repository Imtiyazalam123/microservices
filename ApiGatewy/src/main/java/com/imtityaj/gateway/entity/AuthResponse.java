package com.imtityaj.gateway.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {

    private String userName;

    private String accessToken;

    private String refreshToken;

    private Long expireAt;

    private List<String> authories;
}

