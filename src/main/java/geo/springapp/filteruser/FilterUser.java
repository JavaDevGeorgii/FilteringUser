package geo.springapp.filteruser;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dg on 21.10.15.
 */
//http://www.java2s.com/Code/Java/Servlets/Servletsessionfilter.htm
@WebFilter(urlPatterns = {"/*"})
public class FilterUser implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, NullPointerException {

        HttpSession session =((HttpServletRequest) request).getSession();  // RequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);

        try {
            RequestAttributes attr= (RequestAttributes) RequestContextHolder.getRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);
            RequestAttributes ra=RequestContextHolder.getRequestAttributes();
            if(attr==null){
                RequestContextHolder.getRequestAttributes().setAttribute("user",new User("Petrov"), RequestAttributes.SCOPE_SESSION);
                chain.doFilter(request,response);
            }else {
                System.out.println(attr.toString());
            }

            if (ra!=null){
                request.setAttribute("user",new User("Ivanov"));
                //ra.setAttribute("user",new User("Ivanov"),SCOPE_SESSION);
            }
        }catch (Exception e){
            System.err.print(e);
        }
        String username= (String) request.getAttribute("user");
        System.out.println(username);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
