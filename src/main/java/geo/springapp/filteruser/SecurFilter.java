package geo.springapp.filteruser;

/**
 * Created by GEO on 22.10.15.
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by GEO on 20.10.15.
 */

//@WebFilter(urlPatterns = {"/aa"})
public class SecurFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = ((HttpServletRequest) request).getSession();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("mvc-dispatcher-servlet.xml");


        String user = (String) request.getAttribute("user");

        if (session == null || session.getAttribute("user") == null) {
            request.setAttribute("user", "URAH");
            //((HttpServletResponse) response).sendRedirect("/hello");
            //chain.doFilter(request,response);
            //((HttpServletResponse) response).sendRedirect("/user");
            res.sendRedirect("/users");

        } else {
            request.setAttribute("user", "URAH");
            chain.doFilter(request, response);
        }

        //String user1= (String) request.getAttribute("user");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
