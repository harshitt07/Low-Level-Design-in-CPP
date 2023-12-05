package loadbalancerlld.solution.managers;

import loadbalancerlld.solution.redirection.RedirectionStrategy;

public class RedirectionManager {

    private final RedirectionStrategy redirectionStrategy;

    public RedirectionManager(RedirectionStrategy redirectionStrategy) {
        this.redirectionStrategy = redirectionStrategy;
    }

    public void redirectUrl(String url) {
        this.redirectionStrategy.redirect(url);
    }

}
