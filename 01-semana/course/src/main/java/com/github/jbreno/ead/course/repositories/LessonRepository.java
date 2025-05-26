package com.github.jbreno.ead.course.repositories;

import com.github.jbreno.ead.course.models.LessonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<LessonModel, UUID> {

    @Query(nativeQuery = true,
            value = "select * from tb_lessons where module_module_id = :moduleId")
    List<LessonModel> findAllLessonsIntoModule(@Param("moduleId") UUID moduleId);

    @Query(nativeQuery = true,
            value = "select * from tb_lessons where module_module_id = :moduleId and lesson_id = :lessonId")
    Optional<LessonModel> findLessonIntoModule(@Param("moduleId") UUID moduleId, @Param("lessonId") UUID lessonId);
}
