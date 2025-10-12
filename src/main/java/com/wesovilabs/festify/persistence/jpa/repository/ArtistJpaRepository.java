package com.wesovilabs.festify.persistence.jpa.repository;

import com.wesovilabs.festify.persistence.jpa.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistJpaRepository extends JpaRepository<ArtistEntity, Long> {
}
