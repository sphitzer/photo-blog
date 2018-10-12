package com.courterco.photoblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courterco.photoblog.domain.Album;

public interface AlbumRepository extends JpaRepository<Album,Long>{

}
