package org.usermanagement.core.controller;

import org.model.usermanagement.Role;
import org.model.usermanagement.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.usermanagement.core.SimpleJobCheck;
import org.usermanagement.core.component.RoleManager;
import org.usermanagement.core.component.UserManager;
import org.usermanagement.core.exception.ApplicationException;
import org.usermanagement.core.exception.BusinessException;
import org.usermanagement.core.scheduler.SchedulerManager;
import org.usermanagement.core.ui.ObjectConstructor;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@SessionAttributes({"roles"})
public class AuthenticationController {
    @Autowired
    private UserManager userManager;
    @Autowired
    private RoleManager roleManager;
    @Autowired
    private SchedulerManager schedulerManager;
    @Autowired
    private PersistentTokenBasedRememberMeServices tokenRepositoryService;
    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;
    @Autowired
    private ObjectConstructor objectConstructor;
    private Gson gson = new Gson();

    public AuthenticationController() {}

    @RequestMapping({"/"})
    public String getDefaultUrl()
    {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        }
        return "redirect:/home";
    }

    @RequestMapping({"/saveDummyRootUser"})
    @ResponseBody
    public String saveDummyRootUser()
    {
        try
        {
            this.schedulerManager.createJob("TEST", "GROUP", true, "0/10 * * * * ?", 0, new HashMap(), SimpleJobCheck.class);
            Thread.sleep(20000L);
            System.out.print("PAUSE CALL");
            this.schedulerManager.pauseJob("TEST", "GROUP");
            Thread.sleep(20000L);
            System.out.print("RESUME CALL");
            this.schedulerManager.resumeJob("TEST", "GROUP");
            Thread.sleep(20000L);
            System.out.print("DELETE CALL");
            this.schedulerManager.deleteJob("TEST", "GROUP");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        User user = new User();
        Role role = new Role();
        role.setDescription("Admin");
        role.setName("Admin");
        try
        {
            role = this.roleManager.saveRole(role);
        }
        catch (ApplicationException applicationException)
        {
            return applicationException.getExceptions().toString();
        }
        user.setRole(role);
        user.setUsername("ROOT");
        user.setPassword("ROOT");
        user.setContactEmail("Root@usermanagement.org");
        user.setContactNumber("9876543211");
        try
        {
            user = this.userManager.saveUserManager(user);
        }
        catch (ApplicationException applicationException)
        {
            return applicationException.getExceptions().toString();
        }
        return "Saved : " + user.toString();
    }

    @ModelAttribute("roles")
    public List<Role> initRoles()
    {
        System.out.print("\n\n\n INIT ROLE ");
        List<Role> roles = new ArrayList();
        try
        {
            roles = this.roleManager.getAllRoles();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return roles;
    }

    @RequestMapping({"/login"})
    public String loginPage()
    {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        }
        return "redirect:/home";
    }

    @RequestMapping({"/logout"})
    public String logoutPage(HttpServletRequest request, HttpServletResponse response)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
        {
            this.tokenRepositoryService.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping({"/Access_Denied"})
    public String accessDeniedPage(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        model.addAttribute("loggedUser", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping({"/home"})
    public String homePage(ModelMap model)
    {
        System.out.print("ACCESSING HOME PAGE");
        String username = getPrincipal();
        addUserDetails(username, model, null);
        model.addAttribute("greeting", "Hi " + getPrincipal() + ", Welcome to mysite");
        return "home";
    }

    @RequestMapping({"/oauth2/authorize"})
    public String authorize(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        System.out.print("ACCESSING authorize PAGE");
        String username = getPrincipal();
        addUserDetails(username, model, request);
        model.addAttribute("greeting", "Hi " + getPrincipal() + ", Welcome to mysite");
        return "/oauth2/getAuthorization";
    }

    @RequestMapping({"/oauth2/accessToken"})
    public String accessToken(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        System.out.print("ACCESSING authorize PAGE");
        String username = getPrincipal();
        addUserDetails(username, model, request);
        model.addAttribute("greeting", "Hi " + getPrincipal() + ", Welcome to mysite");
        return "/oauth2/accessToken";
    }

    @RequestMapping({"/userInfo/manage"})
    public String allUserData(ModelMap model)
    {
        String username = getPrincipal();
        addUserDetails(username, model, null);
        return "/userInfo/allUserData";
    }

    @RequestMapping({"/userInfo/getAllUsers"})
    @ResponseBody
    public String viewUserDetails()
    {
        try
        {
            List<User> users = this.userManager.getAllUsers();
            System.out.print("{data: [" + this.gson.toJson(users) + "]}");
            return this.gson.toJson(users);
        }
        catch (BusinessException b)
        {
            b.printStackTrace();
        }
        catch (ApplicationException a)
        {
            a.printStackTrace();
        }
        return "[]";
    }

    @RequestMapping({"/ajax/viewUserDetails/{userId}"})
    public String viewUserDetails(@PathVariable long userId, ModelMap model)
    {
        try
        {
            User user = this.userManager.getUserById(userId);
            this.objectConstructor.populateFormDetails(user, model);
            System.out.print(model);
        }
        catch (BusinessException b)
        {
            b.printStackTrace();
        }
        catch (ApplicationException a)
        {
            a.printStackTrace();
        }
        return "/ajax/userDetails";
    }

    @RequestMapping({"/ajax/updateUserDetails"})
    public String saveUserDetails(HttpServletRequest request, ModelMap model)
    {
        System.out.print("Save User Details");
        User user = (User)this.objectConstructor.constructObject(request, User.class);
        try
        {
            user = this.userManager.saveUserManager(user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "redirect:/userInfo/manage";
    }

    private String getPrincipal()
    {
        String userName = null;
        try
        {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if ((principal instanceof UserDetails)) {
                userName = ((UserDetails)principal).getUsername();
            } else {
                userName = principal.toString();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return userName;
    }

    private boolean isCurrentAuthenticationAnonymous()
    {
        System.out.print("Check is Current auth.****************************************\n");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.print("After Check is Current auth.****************************************\n"+authentication.isAuthenticated()+" "+authentication.getDetails()+" "+authenticationTrustResolver.isAnonymous(authentication)) ;
        return this.authenticationTrustResolver.isAnonymous(authentication);
    }

    private User addUserDetails(String username, ModelMap modelMap,HttpServletRequest request)
    {
        modelMap.put("loggedUser", username);
        User user = null;
        try
        {
            user = userManager.getUserByUserName(username);
            modelMap.put("loggedUserEmail", user.getContactEmail());
            modelMap.put("loggedUserFullName", (user.getFirstName() != null ? user.getFirstName() + " " : "") + (user.getMiddleName() != null ? user.getMiddleName() + " " : "") + (user.getLastName() != null ? user.getLastName() : ""));

            modelMap.put("loggedUserAuthority", user.getRole() != null ? user.getRole().getName() : "");
            modelMap.put("loggedUserId", Long.valueOf(user.getId()));
            modelMap.put("loggedPassword", user.getPassword());
            if(request != null && request.getParameter("client_id") != null) {
                modelMap.put("client_id",request.getParameter("client_id"));
            }
            if(request != null && request.getParameter("client_secret") != null) {
                modelMap.put("client_secret",request.getParameter("client_secret"));
            }
            if(request != null && request.getParameter("code") != null) {
                modelMap.put("code",request.getParameter("code"));
            }


        }
        catch (BusinessException b) {b.printStackTrace();}catch (ApplicationException a) {a.printStackTrace();} catch (Exception e) {e.printStackTrace();}
        return user;
    }
}
