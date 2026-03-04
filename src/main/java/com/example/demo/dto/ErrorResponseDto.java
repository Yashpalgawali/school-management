package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@Builder @NoArgsConstructor
public class ErrorResponseDto {

	String apiPath;
	String errorCode;
	String errorMessage;
	LocalDateTime errorTime;
}
