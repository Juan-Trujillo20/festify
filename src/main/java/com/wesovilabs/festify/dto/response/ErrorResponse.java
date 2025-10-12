package com.wesovilabs.festify.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(String message, List<String> errors, LocalDateTime timestamp) {
}
