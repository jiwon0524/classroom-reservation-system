package kr.ac.classroom.reservation.server.config;

public record ServerConfig(int port, int workerThreads, String dataDirectory) {
    public static ServerConfig fromArgs(String[] args) {
        int port = 8080;
        String dataDirectory = "data";
        for (String arg : args) {
            if (arg.startsWith("--port=")) {
                port = Integer.parseInt(arg.substring("--port=".length()));
            }
            if (arg.startsWith("--data=")) {
                dataDirectory = arg.substring("--data=".length());
            }
        }
        return new ServerConfig(port, 8, dataDirectory);
    }
}
