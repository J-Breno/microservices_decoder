package com.github.jbreno.ead.course.repositories;

import com.github.jbreno.ead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {

    @Query(nativeQuery = true,
    value = "select * from tb_modules where course_course_id = :courseId")
    List<ModuleModel> findAllModulesIntoCourse(@Param("courseId") UUID courseId);

    @Query(nativeQuery = true,
    value = "select * from tb_modules where course_course_id = :courseId and module_id = :moduleId")
    Optional<ModuleModel> findModuleIntoCourse(@Param("courseId") UUID courseId,@Param("moduleId") UUID moduleId);
}
