package com.knewton;

import java.net.InetSocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        
        final String host = args[0];
        final Integer port = Integer.parseInt(args[1]);
        
        Runnable print_dns = new Runnable() {
            @Override
            public void run() {
                InetSocketAddress newAddr = new InetSocketAddress(host, port);
                System.out.println(newAddr);
                System.out.println(newAddr.isUnresolved());
                
            }
        };

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(print_dns, 0, 5, TimeUnit.SECONDS);
    }
    
}

