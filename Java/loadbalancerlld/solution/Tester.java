package loadbalancerlld.solution;

import loadbalancerlld.solution.filters.LessLoadFilter;
import loadbalancerlld.solution.managers.RedirectionManager;
import loadbalancerlld.solution.managers.ServerManager;
import loadbalancerlld.solution.redirection.LoadBasedStrategy;
import loadbalancerlld.solution.server.Server;

public class Tester {

    public static void main(String[] args) {

        ServerManager serverManager = new ServerManager();
        serverManager.addServer(new Server(1, true, 1000));
        serverManager.addServer(new Server(2, true, 500));
        serverManager.addServer(new Server(3, false, 100));
        serverManager.addServer(new Server(4, true, 1500));

        RedirectionManager redirectionManager = new RedirectionManager(new LoadBasedStrategy(new LessLoadFilter(), serverManager));

        redirectionManager.redirectUrl("abc");
        redirectionManager.redirectUrl("cde");
        redirectionManager.redirectUrl("xyz");


    }

}


/*
*
* Question: Design(LLD) a Load Balancer!
* Requirements:
* - should decide which server the request should be forwarded.
* - Different ways of LB Strategy(Round Robin, Load Balancer, Custom, Random).
* - Strategy Pattern can be used.
* - Every class should be dependent on Interfaces otherwise DIP will be violated.
* - OR Based Filters
*
* */