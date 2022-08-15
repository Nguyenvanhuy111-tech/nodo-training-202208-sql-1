public class SaiSoException extends Exception{
    private String so;
    public SaiSoException(String values){
        this.so=values;
    }
    public String getMessage(){
        return "Gia tri \'"+so+"\'khong phai lo so!";
    }

}
