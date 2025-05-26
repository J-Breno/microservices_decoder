package com.github.jbreno.ead.course.services.impl;

import com.github.jbreno.ead.course.models.CourseModel;
import com.github.jbreno.ead.course.models.LessonModel;
import com.github.jbreno.ead.course.models.ModuleModel;
import com.github.jbreno.ead.course.repositories.CourseRepository;
import com.github.jbreno.ead.course.repositories.LessonRepository;
import com.github.jbreno.ead.course.repositories.ModuleRepository;
import com.github.jbreno.ead.course.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Transactional
    @Override
    public void delete(CourseModel courseModel) {
        List<ModuleModel> moduleModelList = moduleRepository.findAllModulesIntoCourse(courseModel.getId());
        if(!moduleModelList.isEmpty()) {
            for (ModuleModel module : moduleModelList) {
                List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(module.getModuleId());
                if(!lessonModelList.isEmpty()) {
                    lessonRepository.deleteAll(lessonModelList);
                }
            }
            moduleRepository.deleteAll(moduleModelList);
        }
        courseRepository.delete(courseModel);
    }
}
