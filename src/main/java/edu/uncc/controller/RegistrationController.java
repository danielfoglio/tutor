package edu.uncc.controller;

import edu.uncc.domain.CurrentUser;
import edu.uncc.domain.Student;
import edu.uncc.domain.Tutor;
import edu.uncc.service.register.RegistrationService;
import edu.uncc.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author daniel_foglio@premierinc.com
 */
@Controller
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired UserService userService;
    @Autowired RegistrationService registrationService;

    @RequestMapping("/registrations")
    public ModelAndView register(@ModelAttribute("currentUser") CurrentUser currentUser) {
        return new ModelAndView("student_registrations", "registrations", registrationService.getRepo().findAllBySid(currentUser.getUser().getLogin()));
    }

    @RequestMapping("/register")
    public String doRegister(@ModelAttribute("currentUser") CurrentUser currentUser,
                                     @RequestParam("tid") String tid) {
        LOGGER.debug("Registering student with "+ tid);
        Student student = userService.getStudentByLogin(currentUser.getUser().getLogin());
        Tutor tutor = userService.getTutorByLogin(tid);
        registrationService.registerStudentWithTutor(student, tutor, "pending");

        return "redirect:/registrations";
    }
}
