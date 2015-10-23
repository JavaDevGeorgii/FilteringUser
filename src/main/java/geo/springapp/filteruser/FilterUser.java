package geo.springapp.filteruser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


//        if( ((req.getRequestURI()).contains("login"))){
//            //chain.doFilter(request,response);
//            res.sendRedirect("/login");
//        }
//        HttpSession session = ((HttpServletRequest) request).getSession();

//        String userSession = ((User) req.getSession().getAttribute("user")).getName();

        try {

            if (req.getSession().getAttribute("user") == null || ((req.getRequestURI()).contains("login")) ) {

                //req.getRequestDispatcher("login").forward(request,response);
                res.sendRedirect("login");
            }
        } catch (Exception e) {
            System.err.print(e);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
