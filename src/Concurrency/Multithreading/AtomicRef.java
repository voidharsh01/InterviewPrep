package Concurrency.Multithreading;

import java.util.concurrent.atomic.AtomicReference;

class Config {
    private String environment;

    public Config(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }
}

public class AtomicRef {
    private static AtomicReference<Config> atm;
    public static void main(String[] args) throws InterruptedException {
        Config config=new Config("prod");
         atm=new AtomicReference<>(config);

        Thread t2=new Thread(()->{
            atm.set(new Config("low"));
        });


        Config oldConfig=atm.get();
        t2.start();
        Thread.sleep(2000);

        atm.compareAndSet(oldConfig,new Config("dev"));

        System.out.println(atm.get().getEnvironment());
    }
}
