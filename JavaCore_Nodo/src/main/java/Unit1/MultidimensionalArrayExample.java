package Unit1;

public class MultidimensionalArrayExample {
    public static void main(String[] args) {
        String[][] values ={
                {"Doan","Van","A"},
                {"Tran","Thi","B"}
        };

        for (int i = 0;i<values.length;i++) {
            System.out.println("|");
            for (int j = 0; j < values[i].length; j++) {
                System.out.println(i+","+j+"|");
                System.out.println(values[i][j]+"|");
            }
            System.out.println();
        }
    }
}
