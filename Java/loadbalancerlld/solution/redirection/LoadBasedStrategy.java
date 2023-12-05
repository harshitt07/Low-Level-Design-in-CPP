package loadbalancerlld.solution.redirection;

import loadbalancerlld.solution.managers.ServerManager;
import loadbalancerlld.solution.filters.Filter;
import loadbalancerlld.solution.server.Server;

import java.util.List;

public class LoadBasedStrategy implements RedirectionStrategy {

    private final Filter filter;
    private final ServerManager serverManager;

    public LoadBasedStrategy(Filter filter, ServerManager serverManager) {
        this.filter = filter;
        this.serverManager = serverManager;
    }

    @Override
    public void redirect(String requestUrl) {
        List<Server> servers = this.serverManager.getFilteredServer(this.filter);
        System.out.println(servers.get(0).getId());
        servers.get(0).incrementRequestCount();
    }
}
