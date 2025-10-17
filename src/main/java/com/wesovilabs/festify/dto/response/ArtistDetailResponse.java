package com.wesovilabs.festify.dto.response;

import java.util.List;

public record ArtistDetailResponse(
        String id, String name,List<String> genres,String country,Integer listeners,String status,String biography
) {}
