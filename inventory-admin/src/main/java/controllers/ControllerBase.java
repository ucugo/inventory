package controllers;

import domain.InventoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;
import repositories.UserRepository;
import util.UrlUtils;

/**
 * Created by Ugo on 01/05/2015.
 */
public class ControllerBase {

    @Autowired protected  UserRepository userRepository;


    @ModelAttribute("c")
    public ControllerBase exposeController() {
        return this;
    }

    protected Object redirect(String url, String query) {
        String fUrl = "/" + url;
        if (query != null)
            fUrl += "?" + query;
        fUrl = UrlUtils.appendQueryParam(fUrl, "rand", String.valueOf(Math.random()));
        return new RedirectView(fUrl, true, true, false);
    }

    protected Object redirect(String url) {
        return redirect(url, null);
    }

    protected InventoryUser getMeridianUser(WebRequest request){
        InventoryUser inventoryUser = (InventoryUser)request.getAttribute(InventoryUser.RequestScopeAttributeName, RequestAttributes.SCOPE_REQUEST);

        return inventoryUser;
    }
}
