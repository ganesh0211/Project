package org.usermanagement.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.usermanagement.core.component.UserManager;
import org.usermanagement.core.exception.ApplicationException;
import org.usermanagement.core.exception.BusinessException;
import org.model.usermanagement.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 20/5/16
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    @Autowired
    UserManager userManager;

    @RequestMapping("/getRootUser")
    @ResponseBody
    public String getRootUserDetails() {
        return "Welcome Admin !!!!";
    }

    @RequestMapping("/saveDummyRootUser")
    @ResponseBody
    public String saveDummyRootUser() {
        User user = new User();
        user.setUsername("ROOT");
        user.setPassword("ROOT");
        user.setContactEmail("Root@usermanagement.org");
        user.setContactNumber("9876543211");
        try {
            user = userManager.saveUserManager(user);
        } catch (ApplicationException applicationException) {
            return applicationException.getExceptions().toString();
        }
        return "Saved : " + user.toString();
    }

    @RequestMapping(value = {"/getUserDetails"}, method = RequestMethod.GET)
    public String getUserDetails(@RequestParam("id") long id, ModelMap modelMap) {
        try {
            User user = userManager.getUserById(id);
            modelMap.addAttribute("userName", user.getUsername());
            modelMap.addAttribute("email", user.getContactEmail());
            modelMap.addAttribute("contactNumber", user.getContactNumber());
        } catch (ApplicationException applicationException) {
            return applicationException.getExceptions().toString();
        } catch (BusinessException businessException) {
            return businessException.getExceptions().toString();
        }
        return "welcomeUser";

    }

    @RequestMapping(value = {"/", "/home"})
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite");
        return "welcome.jsp";
    }

    @RequestMapping(value = "/admin")
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/db")
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/Access_Denied")
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "login";
    }

    private String getPrincipal() {
        String userName = null;
        try{
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            } else {
                userName = principal.toString();
            }
        }catch (Exception e) {

        }
        return userName;
    }
}
