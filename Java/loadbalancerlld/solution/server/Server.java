package loadbalancerlld.solution.server;

public class Server {
    private int id;
    private boolean isHealthy;
    private static int requestTimeCounter = 0;

    private int timestamp;

    private int requestCount;
    private final int capacity;

    public Server(int id, boolean isHealthy, int capacity) {
        this.id = id;
        this.timestamp = 0;
        this.requestCount = 0;
        this.capacity = capacity;
        this.isHealthy = isHealthy;
    }

    public int getRequestCount() {
        return this.requestCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setIsHealthy(boolean health) {
        this.isHealthy = health;
    }

    public void incrementRequestCount() {
        this.requestCount++;
        requestTimeCounter++;
        this.timestamp = requestTimeCounter;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
