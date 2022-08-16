package Unit1;

public class StringExample1 {
    public static void main(String[] args) {
        String text = "Say hello to everyone";
        System.out.println("Length of text is "+text.length());
//        StringExample1(text);
        StringExample4(text);

    }
    public static void StringExample1(String text){
        System.out.println("Vi tri cua tu hello la: "+text.indexOf("hello"));
        System.out.println("Cat tu ="+text.substring(4,8));
    }
    public static void StringExample4(String text){
        int i=0;
        while (i<text.length()){
            char c =text.charAt(i);
            if (c==' '){
                i++;
                continue;
            }
            System.out.println("Character at "+i+" is "+c);
            i++;
        }
    }
}
