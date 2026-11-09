package CoreJava.Enums;

public class enumPrac {

    public static void main(String[] args) {
        OrderStatus os=OrderStatus.PLACED;
        os.print();

        String desc=switch (os){
            case OrderStatus.PLACED -> OrderStatus.PLACED.description;
            default -> "No desc";
        };
        System.out.println(desc);
    }
}
