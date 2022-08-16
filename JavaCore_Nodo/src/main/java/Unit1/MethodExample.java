package Unit1;

public class MethodExample {
    public static int add(int num1,int num2){
        return num1+num2;
    }
    private static int add (int ...values){
        int total = 0;
        for (int v:values){
            total+=v;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("4 + 7= "+add(4,7));

        int v1 = Integer.parseInt(args[0]);
        int v2 = Integer.parseInt(args[1]);

        System.out.println(v1+" + "+v2+" = "+add(v1,v2));

        System.out.println(add(4,7,5,12,6,9));
    }
}
