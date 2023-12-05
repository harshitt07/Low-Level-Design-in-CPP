package loadbalancerlld.solution.filters;

import loadbalancerlld.solution.server.Server;

import java.util.ArrayList;
import java.util.List;

public class LessLoadFilter implements Filter {
    @Override
    public List<Server> filter(List<Server> servers) {
        List<Server> list = new ArrayList<>();
        int minRequestCount = Integer.MAX_VALUE;
        for(Server server : servers) {
            // Whose Request Count is low means it is
            // having the less load
            if(server.getRequestCount() < minRequestCount) {
                minRequestCount = server.getRequestCount();
                list = new ArrayList<>();
                list.add(server);
            } else if(server.getRequestCount() == minRequestCount) {
                list.add(server);
            }
        }
        return list;
    }
}
