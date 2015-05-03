package web;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * Created by Ugo on 26/04/2015.
 */
@Component
public class CurrentRequestInterceptor implements WebRequestInterceptor {

    private static final ThreadLocal<WebRequest> current = new ThreadLocal<WebRequest>();

    public static WebRequest getCurrent() {
        WebRequest request = current.get();
        if (request == null) {
            return null;
        }
        return request;
    }

    @Override
    public void preHandle(WebRequest request) throws Exception {
        current.set(request);
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex)
            throws Exception {
        current.set(null);
    }
}
