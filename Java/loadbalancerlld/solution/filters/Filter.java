package loadbalancerlld.solution.filters;

import loadbalancerlld.solution.server.Server;

import java.util.List;

public interface Filter {

    public List<Server> filter(List<Server> servers);

}
