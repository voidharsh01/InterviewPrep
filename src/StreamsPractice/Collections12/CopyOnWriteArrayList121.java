package StreamsPractice.Collections12;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayList121 {

    public static void main(String[] args) {

        List<Integer> list=List.of(1,2,3,4);

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList=new CopyOnWriteArrayList<>(list);

        Iterator it=copyOnWriteArrayList.iterator();
        copyOnWriteArrayList.add(10);

        while(it.hasNext()){
            System.out.println(it.next());
        }
        it=copyOnWriteArrayList.iterator();

        System.out.println("-------------------------");
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
