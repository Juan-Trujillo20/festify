-- Secuencia para albums
CREATE SEQUENCE IF NOT EXISTS albums_id_seq;

-- Función genérica para updated_at (idempotente)
CREATE OR REPLACE FUNCTION set_updated_at_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_at = NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Tabla de álbumes (simplificada)
CREATE TABLE IF NOT EXISTS albums (
                                      id               BIGINT PRIMARY KEY DEFAULT nextval('albums_id_seq'),
    artist_id        BIGINT       NOT NULL,
    title            VARCHAR(255) NOT NULL,
    release_date     DATE,
    tracks_count     INTEGER      CHECK (tracks_count IS NULL OR tracks_count >= 0),
    duration_seconds INTEGER      CHECK (duration_seconds IS NULL OR duration_seconds >= 0),
    created_at       TIMESTAMP    NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMP    NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_albums_artist
    FOREIGN KEY (artist_id) REFERENCES artists(id) ON DELETE CASCADE,
    -- Evita duplicados: mismo artista + mismo título en misma fecha
    CONSTRAINT uq_album_artist_title_date UNIQUE (artist_id, title, release_date)
    );

-- Índices
CREATE INDEX IF NOT EXISTS idx_albums_artist_id ON albums (artist_id);
CREATE INDEX IF NOT EXISTS idx_albums_title ON albums (title);

-- Triggers updated_at para artists y albums (idempotentes)
DROP TRIGGER IF EXISTS trg_artists_set_updated_at ON artists;
CREATE TRIGGER trg_artists_set_updated_at
    BEFORE UPDATE ON artists
    FOR EACH ROW
    EXECUTE FUNCTION set_updated_at_timestamp();

DROP TRIGGER IF EXISTS trg_albums_set_updated_at ON albums;
CREATE TRIGGER trg_albums_set_updated_at
    BEFORE UPDATE ON albums
    FOR EACH ROW
    EXECUTE FUNCTION set_updated_at_timestamp();

-- Datos de ejemplo (resolviendo artist_id por nombre)
INSERT INTO albums (artist_id, title, release_date, tracks_count, duration_seconds) VALUES
-- Taylor Swift
((SELECT id FROM artists WHERE name='Taylor Swift'), 'Midnight Stories', '2018-05-18', 13, 2730),
((SELECT id FROM artists WHERE name='Taylor Swift'), 'Starlit Roads',   '2021-11-12', 15, 3150),
((SELECT id FROM artists WHERE name='Taylor Swift'), 'Golden Ink',       '2024-06-07', 12, 2520),

-- Ed Sheeran
((SELECT id FROM artists WHERE name='Ed Sheeran'), 'Map of Hearts',  '2019-09-20', 14, 2940),
((SELECT id FROM artists WHERE name='Ed Sheeran'), 'Acoustic Lines', '2022-03-04', 11, 2310),
((SELECT id FROM artists WHERE name='Ed Sheeran'), 'Home Sessions',  '2016-05-06', 10, 2100),

-- Bad Bunny
((SELECT id FROM artists WHERE name='Bad Bunny'), 'Isla Neon',       '2020-08-14', 16, 3360),
((SELECT id FROM artists WHERE name='Bad Bunny'), 'Playa y Noche',   '2023-02-10', 18, 3780),
((SELECT id FROM artists WHERE name='Bad Bunny'), 'Cactus Drive',    '2018-12-07', 13, 2730),

-- Drake
((SELECT id FROM artists WHERE name='Drake'), 'Northbound',  '2015-10-23', 17, 3570),
((SELECT id FROM artists WHERE name='Drake'), 'No Signal',   '2019-06-14', 14, 2940),
((SELECT id FROM artists WHERE name='Drake'), 'Late Lane',   '2022-09-30', 12, 2520),

-- The Weeknd
((SELECT id FROM artists WHERE name='The Weeknd'), 'Velvet Skies', '2016-11-11', 14, 2940),
((SELECT id FROM artists WHERE name='The Weeknd'), 'Echo Mirage',  '2021-02-19', 12, 2520),
((SELECT id FROM artists WHERE name='The Weeknd'), 'Neon Chapel',  '2024-04-19', 11, 2310),

-- Billie Eilish
((SELECT id FROM artists WHERE name='Billie Eilish'), 'Room 19',       '2019-08-30', 13, 2730),
((SELECT id FROM artists WHERE name='Billie Eilish'), 'Static Dreams', '2022-07-15', 12, 2520),
((SELECT id FROM artists WHERE name='Billie Eilish'), 'Soft Panic',    '2024-05-10', 10, 2100),

-- Dua Lipa
((SELECT id FROM artists WHERE name='Dua Lipa'), 'City Lights',    '2018-06-08', 11, 2310),
((SELECT id FROM artists WHERE name='Dua Lipa'), 'Galactic Pop',   '2021-03-19', 10, 2100),
((SELECT id FROM artists WHERE name='Dua Lipa'), 'Runaway Disco',  '2024-03-22', 12, 2520),

-- Adele
((SELECT id FROM artists WHERE name='Adele'), 'Northern Wind',  '2015-11-20', 11, 2310),
((SELECT id FROM artists WHERE name='Adele'), 'Letter to June', '2021-11-19', 12, 2520),
((SELECT id FROM artists WHERE name='Adele'), 'Home Again',     '2018-10-05', 10, 2100),

-- Beyoncé
((SELECT id FROM artists WHERE name='Beyoncé'), 'Golden Hourglass', '2016-04-23', 12, 2520),
((SELECT id FROM artists WHERE name='Beyoncé'), 'Black Honey',      '2019-08-02', 13, 2730),
((SELECT id FROM artists WHERE name='Beyoncé'), 'Royal Motion',     '2023-07-28', 14, 2940),

-- Rihanna
((SELECT id FROM artists WHERE name='Rihanna'), 'Ocean Flame',        '2016-01-29', 12, 2520),
((SELECT id FROM artists WHERE name='Rihanna'), 'Electric Caribbean', '2019-11-08', 11, 2310),
((SELECT id FROM artists WHERE name='Rihanna'), 'After Midnight',     '2022-12-02', 13, 2730),

-- Bruno Mars
((SELECT id FROM artists WHERE name='Bruno Mars'), 'Silk Avenue', '2017-11-17', 10, 2100),
((SELECT id FROM artists WHERE name='Bruno Mars'), 'Mirror Funk', '2020-10-30', 11, 2310),
((SELECT id FROM artists WHERE name='Bruno Mars'), 'Star Motel',  '2023-11-17', 12, 2520),

-- Post Malone
((SELECT id FROM artists WHERE name='Post Malone'), 'Beerbongs & Side Roads', '2018-04-27', 18, 3780),
((SELECT id FROM artists WHERE name='Post Malone'), 'Hollywood Sleepless',     '2020-09-04', 14, 2940),
((SELECT id FROM artists WHERE name='Post Malone'), 'Rust & Roses',            '2023-07-21', 13, 2730),

-- Shakira
((SELECT id FROM artists WHERE name='Shakira'), 'Lobo de Noche',   '2017-05-26', 12, 2520),
((SELECT id FROM artists WHERE name='Shakira'), 'Colores del Mar', '2020-06-12', 11, 2310),
((SELECT id FROM artists WHERE name='Shakira'), 'Volcán',          '2023-09-15', 13, 2730),

-- Karol G
((SELECT id FROM artists WHERE name='Karol G'), 'Bichota Nights', '2020-10-23', 13, 2730),
((SELECT id FROM artists WHERE name='Karol G'), 'Verde Neon',     '2022-08-12', 12, 2520),
((SELECT id FROM artists WHERE name='Karol G'), 'Mariposa',       '2024-02-23', 11, 2310),

-- ROSALÍA
((SELECT id FROM artists WHERE name='ROSALÍA'), 'Cielo Rojo', '2018-11-02', 11, 2310),
((SELECT id FROM artists WHERE name='ROSALÍA'), 'Tránsito',   '2022-03-18', 12, 2520),
((SELECT id FROM artists WHERE name='ROSALÍA'), 'Frontera',   '2024-09-13', 10, 2100),

-- C. Tangana
((SELECT id FROM artists WHERE name='C. Tangana'), 'Madrid DF',       '2017-09-29', 12, 2520),
((SELECT id FROM artists WHERE name='C. Tangana'), 'El Último Bar',   '2021-02-26', 14, 2940),
((SELECT id FROM artists WHERE name='C. Tangana'), 'Cartas y Peines', '2023-05-12', 11, 2310),

-- Quevedo
((SELECT id FROM artists WHERE name='Quevedo'), 'Playa Hermosa', '2022-07-08', 12, 2520),
((SELECT id FROM artists WHERE name='Quevedo'), 'QVD Tapes',     '2023-06-02', 11, 2310),
((SELECT id FROM artists WHERE name='Quevedo'), 'La Rotonda',    '2024-08-30', 13, 2730),

-- Aitana
((SELECT id FROM artists WHERE name='Aitana'), 'Luna de Agosto', '2019-06-14', 11, 2310),
((SELECT id FROM artists WHERE name='Aitana'), 'Berlín',         '2021-10-01', 12, 2520),
((SELECT id FROM artists WHERE name='Aitana'), 'Alpha Lines',    '2023-09-22', 13, 2730);