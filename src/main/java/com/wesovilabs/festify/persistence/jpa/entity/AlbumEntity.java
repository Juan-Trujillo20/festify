package com.wesovilabs.festify.persistence.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="albums")
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_id", nullable = false)
    private Long artistId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "tracks_count")
    private Integer tracksCount;

    @Column(name = "duration_seconds")
    private Integer durationSeconds;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public AlbumEntity() {}
    public AlbumEntity(Long id,Long artistId,LocalDateTime createdAt,
                       Integer durationSeconds,LocalDate releaseDate,
                       String title,Integer tracksCount,LocalDateTime updatedAt) {
        this.id = id;
        this.artistId = artistId;
        this.createdAt = createdAt;
        this.durationSeconds = durationSeconds;
        this.releaseDate = releaseDate;
        this.title = title;
        this.tracksCount = tracksCount;
        this.updatedAt = updatedAt;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getArtistId() {
        return artistId;
    }
    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Integer getTracksCount() {
        return tracksCount;
    }
    public void setTracksCount(Integer tracksCount) {
        this.tracksCount = tracksCount;
    }
    public Integer getDurationSeconds() {
        return durationSeconds;
    }
    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;

    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}
