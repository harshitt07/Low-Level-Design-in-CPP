package loadbalancerlld.solution.filters;

import loadbalancerlld.solution.server.Server;

import java.util.ArrayList;
import java.util.List;

public class ActiveFilter implements Filter {
    @Override
    public List<Server> filter(List<Server> servers) {
        List<Server> list = new ArrayList<>();
        for(Server server : servers) {
            if(server.isHealthy()) {
                list.add(server);
            }
        }
        return list;
    }
}
