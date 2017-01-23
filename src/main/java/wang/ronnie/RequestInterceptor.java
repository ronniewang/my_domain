package wang.ronnie;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 为请求前后做统一处理
 * 现包含一下内容
 * 1. request唯一id
 * 2. request处理时间
 *
 * @author ronnie wang
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    public static int requestCount = 0;

    private static final String RONNIE_WANG_REQUEST_ID = "ronnie.wang.request.id";

    private static final String RONNIE_WANG_REQUEST_START_TIME = "ronnie.wang.request.startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long currentTimeMillis = System.currentTimeMillis();
        request.setAttribute(RONNIE_WANG_REQUEST_ID, currentTimeMillis + "-" + (++requestCount % 10));
        request.setAttribute(RONNIE_WANG_REQUEST_START_TIME, currentTimeMillis);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println(String.format("post handle request | request_id:{%s}, request_mills:{%s}",
                request.getAttribute(RONNIE_WANG_REQUEST_ID), System.currentTimeMillis() - (long) request.getAttribute(RONNIE_WANG_REQUEST_START_TIME)));
    }
}
