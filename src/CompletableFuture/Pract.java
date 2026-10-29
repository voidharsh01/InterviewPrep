package CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class Pract {




    public static CompletableFuture<String> getName(){


        try{

            Thread.sleep(100);
        }
        catch (Exception e){

        }
        return CompletableFuture.completedFuture("Harsh");
    }
    public static CompletableFuture<Integer> getFollower(){


        try{

            Thread.sleep(200);
        }
        catch (Exception e){

        }
        return CompletableFuture.completedFuture(100);
    }

    public static void main(String[] args) {


      CompletableFuture<String> name=getName();
      CompletableFuture<Integer> follower=getFollower();

      CompletableFuture<Void> cmp=CompletableFuture.allOf(name,follower);




    }
}
