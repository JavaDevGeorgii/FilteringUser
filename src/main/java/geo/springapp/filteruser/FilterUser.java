package geo.springapp.filteruser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dg on 21.10.15.
 */
//http://www.java2s.com/Code/Java/Servlets/Servletsessionfilter.htm
//http://www.journaldev.com/1933/java-servlet-filter-example-tutorial

@WebFilter(urlPatterns = {"/*"})
public class FilterUser implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, NullPointerException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = ((HttpServletRequest) request).getSession();

        String userSession = (String) req.getSession(false).getAttribute("user");

        try {
//            RequestAttributes attr= (RequestAttributes) RequestContextHolder.getRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);
//            RequestAttributes ra=RequestContextHolder.getRequestAttributes();
            if (session.getAttribute("user") == null) {
                //RequestContextHolder.getRequestAttributes().setAttribute("user",new User("Petrov"), RequestAttributes.SCOPE_SESSION);
                //chain.doFilter(request,response);
                res.sendRedirect("login");
            } else {

                chain.doFilter(request, response);
                //request.setAttribute("user",new User("Ivanov"));
                //ra.setAttribute("user",new User("Ivanov"),SCOPE_SESSION);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        String username = (String) request.getAttribute("user");
        System.out.println(username);
        //chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
