package loadbalancerlld.solution.filters;

import loadbalancerlld.solution.server.Server;

import java.util.ArrayList;
import java.util.List;

public class LastUsedFilter implements Filter {
    @Override
    public List<Server> filter(List<Server> servers) {
        List<Server> list = new ArrayList<>();
        int minRequestCountTimer = Integer.MAX_VALUE;
        for(int i = 0; i < servers.size(); i++) {
            Server server = servers.get(i);
            if(server.getTimestamp() < minRequestCountTimer) {
                list.add(server);
                break;
            }
        }
        return list;
    }
}
