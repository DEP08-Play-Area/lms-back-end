package lk.ijse.dep8.lmsbackend.api;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="CorsFilter", urlPatterns = "/*")
public class CorsFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String origin = req.getHeader("Origin");
        if(origin != null && origin.contains("localhost:1234")){
            res.setHeader("Access-Control-Allow-Origin",origin);
            if(req.getMethod().equals("OPTIONS")){
                res.setHeader("Access-Control-Allow-Methods",);
            }
        }
        chain.doFilter(req,res);
    }
}
