public class toNumber {
    public static void main(String[] args) {
        int number = toNumber("34");
        System.out.println("Number = " + number);

        number = toNumber("as");
        System.out.println("Number = " + number);
    }

    static int toNumber(String value) {
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static class SaiSoException extends Exception {
        private String so;

        public SaiSoException(String values) {
            this.so = values;
        }

        public String getMessage() {
            return "Gia tri \'" + so + "\'khong phai lo so!";
        }
    }
}

