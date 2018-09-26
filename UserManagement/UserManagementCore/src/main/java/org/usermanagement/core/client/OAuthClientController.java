package org.usermanagement.core.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 12:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class OAuthClientController {

    @RequestMapping({"/oauth/getAccessToken"})
    public void getAccessToken(HttpServletRequest request, HttpServletResponse response) {}

    private void printHeaderDetails(HttpServletRequest request, HttpServletResponse response){
        String headerName = null;
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println("REQUEST " + (headerName = (String)headerNames.nextElement()) + " --> " + request.getHeader(headerName));
        }
        for (String header : response.getHeaderNames()) {
            System.out.println("RESPONSE " + header + " --> " + response.getHeader(header));
        }
    }
}
