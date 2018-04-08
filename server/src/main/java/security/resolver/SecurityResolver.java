package security.resolver;

import com.feth.play.module.pa.Resolver;
import com.feth.play.module.pa.exceptions.AccessDeniedException;
import com.feth.play.module.pa.exceptions.AuthException;
import controllers.routes;
import play.mvc.Call;

/**
 * Created by Payam Mostafaei
 * Creation Time: 2017/Jan/08 - 08:29 PM
 */
public class SecurityResolver extends Resolver {

    @Override
    public Call login() {
        return routes.Account.doLogin();
    }

    @Override
    public Call afterAuth() {
        return routes.Application.index();
    }

    @Override
    public Call afterLogout() {
        return routes.Application.index();
    }

    @Override
    public Call auth(final String provider) {
        // You can provide your own authentication implementation,
        // however the default should be sufficient for most cases
        return com.feth.play.module.pa.controllers.routes.Authenticate
                .authenticate(provider);
    }

    @Override
    public Call askMerge() {
        return null;
    }

    @Override
    public Call askLink() {
        return null;
    }

    @Override
    public Call onException(final AuthException e) {
        if (e instanceof AccessDeniedException) {
            return routes.Account
                    .oAuthDenied(((AccessDeniedException) e)
                            .getProviderKey());
        }

        // more custom problem handling here...
        return super.onException(e);
    }
}
