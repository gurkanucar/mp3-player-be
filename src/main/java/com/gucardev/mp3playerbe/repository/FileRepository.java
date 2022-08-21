package com.gucardev.mp3playerbe.repository;

import com.gucardev.mp3playerbe.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileModel, Long> {


    List<FileModel> findAllByNameContainingIgnoreCase(String name);
}
