package org.usermanagement.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 20/5/16
 * Time: 5:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {

    @RequestMapping("/getRootUser")
    @ResponseBody
    public String getRootUserDetails(){
        return "Welcome Admin !!!!";
    }
}
