package edu.uncc.controller;

import edu.uncc.domain.*;
import edu.uncc.domain.validator.UserCreateFormValidator;
import edu.uncc.repository.CourseRepository;
import edu.uncc.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;
    private final CourseRepository courseRepository;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator, CourseRepository courseRepository) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
        this.courseRepository = courseRepository;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        User u = userService.getUserById(id).orElseThrow(() -> new UsernameNotFoundException(String.format("User with id=%s was not found", id)));
        if (u.getRole() == Role.TUTOR)
            return new ModelAndView("tutor_update", "formU", userService.getTutorByLogin(u.getLogin()).toTutorForm().setId(id));
        else {
            List<Courses> courses = courseRepository.findAll();
            ModelMap mm = new ModelMap();
            mm.addAttribute("formU", userService.getStudentByLogin(u.getLogin()).toStudentForm().setId(id));
            mm.addAttribute("courses", courses);
            return new ModelAndView("students_update", mm );
        }
    }

    //@PreAuthorize("hasAuthority('TUTOR')")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String getUserCreatePage() {
        LOGGER.debug("Getting user create form");
        return "user_create";
    }

    @RequestMapping(value = "/user/create/tutor", method = RequestMethod.GET)
    public ModelAndView getTutorCreatePage() {
        LOGGER.debug("Getting Tutor create form");
        return new ModelAndView("tutor_create", "form", new TutorForm());
    }

    @RequestMapping(value = "/user/create/tutor", method = RequestMethod.POST)
    public ModelAndView handleUserCreateTutor(@Valid @ModelAttribute("form") TutorForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing Tutor create form={}, bindingResult={}", form, bindingResult);
        Tutor user;
        if (bindingResult.hasErrors()) {
            // failed validation
            return new ModelAndView("tutor_create", "form", form);
        }
        try {
            user = userService.createTutor(form);
        } catch (DataIntegrityViolationException e) {
            // probably login already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the Tutor, assuming duplicate login", e);
            bindingResult.reject("login.exists", "Tutor already exists");
            return new ModelAndView("tutor_create", "form", form);
        }
        // ok, redirect
        return new ModelAndView("home", "tutor", user);
    }

    @RequestMapping(value = "/user/update/tutor", method = RequestMethod.POST)
    public ModelAndView handleUserUpdateTutor(@Valid @ModelAttribute("formU") TutorForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing Tutor create form={}, bindingResult={}", form, bindingResult);
        Tutor user;
        if (bindingResult.hasErrors()) {
            // failed validation
            return new ModelAndView("tutor_update", "formU", form);
        }
        try {
            user = userService.updateTutor(form);
        } catch (DataIntegrityViolationException e) {
            // probably login already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the Tutor, assuming duplicate login", e);
            bindingResult.reject("login.exists", "Tutor already exists");
            return new ModelAndView("tutor_update", "formU", form);
        }
        // ok, redirect
        return new ModelAndView("home", "tutor", user);
    }

    @RequestMapping(value = "/user/create/student", method = RequestMethod.GET)
    public ModelAndView getStudentCreatePage() {
        LOGGER.debug("Getting Student create form");
        List<Courses> courses = courseRepository.findAll();
        ModelMap mm = new ModelMap();
        mm.addAttribute("form", new StudentForm());
        mm.addAttribute("courses", courses);
        return new ModelAndView("student_create", mm);
    }

    @RequestMapping(value = "/user/create/student", method = RequestMethod.POST)
    public ModelAndView handleUserCreateStudent(@Valid @ModelAttribute("form") StudentForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing Student create form={}, bindingResult={}", form, bindingResult);
        Student user;
        if (bindingResult.hasErrors()) {
            // failed validation
            return new ModelAndView("student_create", "form", form);
        }
        try {
           user =  userService.createStudent(form);
        } catch (DataIntegrityViolationException e) {
            // probably login already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the Student, assuming duplicate login", e);
            bindingResult.reject("login.exists", "Student already exists");
            return new ModelAndView("student_create", "form", form);
        }
        // ok, redirect
        return new ModelAndView("home", "student",user);
    }

    @RequestMapping(value = "/user/update/student", method = RequestMethod.POST)
    public ModelAndView handleUserUpdateStudent(@Valid @ModelAttribute("formU") StudentForm form, BindingResult bindingResult) {
        LOGGER.debug("Processing Tutor create form={}, bindingResult={}", form, bindingResult);
        Student user;
        if (bindingResult.hasErrors()) {
            // failed validation
            return new ModelAndView("students_update", "formU", form);
        }
        try {
            user = userService.updateStudent(form);
        } catch (DataIntegrityViolationException e) {
            // probably login already exists - very rare case when multiple admins are adding same user
            // at the same time and form validation has passed for more than one of them.
            LOGGER.warn("Exception occurred when trying to save the Tutor, assuming duplicate login", e);
            bindingResult.reject("login.exists", "Tutor already exists");
            return new ModelAndView("students_update", "formU", form);
        }
        // ok, redirect
        return new ModelAndView("home", "student", user);
    }


}
