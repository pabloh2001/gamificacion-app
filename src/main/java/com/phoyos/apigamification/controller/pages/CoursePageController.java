package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.Course;
import com.phoyos.apigamification.domain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoursePageController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/admin/courses")
    public String contextCourse(Model model){
        model.addAttribute("courses", courseService.getAll());
        return "courses";
    }

    @GetMapping("/admin/courses/create")
    public String createCourse(Model model){
        model.addAttribute("course", new Course());
        return "save-course";
    }

    @GetMapping("/admin/courses/edit/{id}")
    public String editCourse(@PathVariable("id") String id, Model model){
        model.addAttribute("course", courseService.getById(id));
        return "save-course";
    }

    @PostMapping("/admin/courses/save")
    public String saveCourse(@Validated @ModelAttribute Course course, Model model){
        courseService.save(course);
        return "redirect:/admin/courses";
    }

    @GetMapping("/admin/courses/delete/{id}")
    public String deleteCourse(@PathVariable("id") String id){
        courseService.deleteById(id);
        return "redirect:/admin/courses";
    }
}
