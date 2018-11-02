package com.courterco.photoblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courterco.photoblog.domain.Photo;
import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo,Long>{
    List<Photo> findByAlbumId(Long albumId);
}
