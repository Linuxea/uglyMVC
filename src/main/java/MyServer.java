import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * create by linuxea on 17-11-23
 **/
public class MyServer {

    private volatile Server server;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyServer myServer = new MyServer();
        executorService.execute(() -> {
            try {
                myServer.start();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        });
        try {
            TimeUnit.DAYS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myServer.destroy();
    }

    /**
     * start server
     *
     * @throws Exception
     */
    public void start() throws Exception {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(DispatcherServlet.class, "/*");
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{context, new DefaultHandler()});
        server.setHandler(handlers);
        server.start();
        System.out.println("server start");
        server.join();
    }


    /**
     * close server
     */
    public void destroy() {
        if (null != server) {
            try {
                server.stop();
                System.out.println("server close.");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

}
