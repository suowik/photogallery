package pl.edu.pk.ztbd.photogallery.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Suowik
 * Date: 05.01.13
 * Time: 19:55
 */
public class UTFFilter implements Filter {

        public void init(FilterConfig config) throws ServletException {
            //No-op
        }

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        }

        public void destroy() {
            //No-op
        }
}
