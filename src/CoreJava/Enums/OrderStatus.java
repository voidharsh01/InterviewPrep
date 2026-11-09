package CoreJava.Enums;

public enum  OrderStatus implements randomI {

    PLACED("Placed"){

        @Override
        public void print(){
            System.out.println("I am placed");
        }
    },READY("Ready"){

        @Override
        public void print(){
            System.out.println("I am ready");
        }
    },OUT_FOR_DELIVERY("Out for delivery")
            {
                @Override
                public void print(){
                    System.out.println("I am out for del");
                }
            }
    ;
    public String description;
    OrderStatus(String desc){
        this.description=desc;
    }
}
