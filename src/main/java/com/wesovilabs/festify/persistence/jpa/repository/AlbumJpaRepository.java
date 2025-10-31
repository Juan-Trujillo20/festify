package com.wesovilabs.festify.persistence.jpa.repository;

import com.wesovilabs.festify.persistence.jpa.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumJpaRepository extends JpaRepository<AlbumEntity,Long> {
}
