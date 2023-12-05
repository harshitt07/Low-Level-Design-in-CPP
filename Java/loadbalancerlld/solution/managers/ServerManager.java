package loadbalancerlld.solution.managers;

import loadbalancerlld.solution.filters.Filter;
import loadbalancerlld.solution.server.Server;

import java.util.ArrayList;
import java.util.List;

public class ServerManager {

    List<Server> servers = new ArrayList<>();

    public List<Server> getFilteredServer(Filter filter) {
        return filter.filter(this.servers);
    }

    public void addServer(Server server) {
        this.servers.add(server);
    }

}
