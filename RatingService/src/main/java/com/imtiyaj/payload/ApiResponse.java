package com.imtiyaj.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {

	private String message;
	private Boolean success;
	private HttpStatus status;
}
