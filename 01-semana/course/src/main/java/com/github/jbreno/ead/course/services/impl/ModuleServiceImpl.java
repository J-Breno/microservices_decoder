package com.github.jbreno.ead.course.services.impl;

import com.github.jbreno.ead.course.models.LessonModel;
import com.github.jbreno.ead.course.models.ModuleModel;
import com.github.jbreno.ead.course.repositories.LessonRepository;
import com.github.jbreno.ead.course.repositories.ModuleRepository;
import com.github.jbreno.ead.course.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Transactional
    @Override
    public void delete(ModuleModel moduleModel) {
        List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(moduleModel.getModuleId());
        if(!lessonModelList.isEmpty()) {
            lessonRepository.deleteAll(lessonModelList);
        }
        moduleRepository.delete(moduleModel);
    }
}
