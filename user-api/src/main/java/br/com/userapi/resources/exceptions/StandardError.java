package br.com.userapi.resources.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StandardError {

	private LocalDateTime timestamp;
	private String error;
	private Integer status;
	private String path;
}
