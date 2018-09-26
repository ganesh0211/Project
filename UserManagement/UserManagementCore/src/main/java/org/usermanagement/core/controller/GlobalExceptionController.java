package org.usermanagement.core.controller;

import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 3:25 PM
 * To change this template use File | Settings | File Templates.
 */
@ControllerAdvice
public class GlobalExceptionController {
    public GlobalExceptionController() {}

    @ExceptionHandler({Exception.class})
    public String defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        request.setAttribute("exception", exception);
        return "redirect:/error/errorPage";
    }

    @RequestMapping({"/error/errorPage"})
    public String handleError(HttpServletRequest request, ModelMap modelMap) {
        System.out.println("\nEXCEPTION HANDLER CALLED ***********************\n\n");
        modelMap.put("url", request.getRequestURL());
        try {
            modelMap.put("exception", request.getAttribute("exception"));
            request.removeAttribute("exception");
        }
        catch (Exception e) {}
        return "/error/errorPage";
    }
}
