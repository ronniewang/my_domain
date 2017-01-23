package wang.ronnie;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ronnie wang on 17/1/23.
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final String RONNIE_WANG_REQUEST_START_TIME = "ronnie.wang.request.startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute(RONNIE_WANG_REQUEST_START_TIME, System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println(System.currentTimeMillis() - (long) request.getAttribute(RONNIE_WANG_REQUEST_START_TIME));
    }
}
