package com.wesovilabs.festify.dto.response;

import java.util.List;

public record ArtistResumeResponse(String  id, String name, String country, String status, List<String> genres, Integer listeners) {
}
