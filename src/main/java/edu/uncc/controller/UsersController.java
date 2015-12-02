package edu.uncc.controller;

import edu.uncc.domain.CurrentUser;
import edu.uncc.domain.Registration;
import edu.uncc.domain.Role;
import edu.uncc.domain.Student;
import edu.uncc.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public ModelAndView getUsersPage(@ModelAttribute("currentUser") CurrentUser currentUser) {
        LOGGER.debug("Getting users page");
        Collection<Registration> students = userService.getTutorByLogin(currentUser.getUser().getLogin()).getRegistrations();
        return new ModelAndView("users_tutor", "registrations", userService.getTutorByLogin(currentUser.getUser().getLogin()).getRegistrations());
    }

    @RequestMapping("/users/{role}")
    public ModelAndView getUsersByRole( @PathVariable Role role) {
        LOGGER.debug("Getting users "+ role);
        return new ModelAndView("users", "tutors", userService.getAllTutors());
    }

}
