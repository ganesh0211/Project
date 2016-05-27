package org.usermanagement.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.usermanagement.core.component.UserManager;
import org.usermanagement.model.User;

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
    public String getRootUserDetails(){
        return "Welcome Admin !!!!";
    }

    @RequestMapping("/saveDummyRootUser")
    @ResponseBody
    public String saveDummyRootUser(){
        User user = new User();
        user.setUsername("ROOT");
        user.setPassword("ROOT");
        user.setContactEmail("Root@usermanagement.org");
        user.setContactNumber("9876543211");
        user = userManager.saveUserManager(user);
        return "Saved : "+user.toString();
    }

    @RequestMapping(value = {"/getUserDetails"},method = RequestMethod.GET)
    public String getUserDetails(@RequestParam("id") long id,ModelMap modelMap){
        User user = userManager.getUserById(id);
        modelMap.addAttribute("userName",user.getUsername());
        modelMap.addAttribute("email",user.getContactEmail());
        modelMap.addAttribute("contactNumber",user.getContactNumber());
        return "welcomeUser";

    }
}
