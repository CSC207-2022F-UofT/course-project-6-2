package usecases.userinputboundary;

public class RegisterInputBoundary {
    public int age = 0;
    public RegisterInputBoundary(String ageText) {
        try {
            Double.parseDouble(ageText);
            this.age = Integer.parseInt(ageText);
        } catch(Exception ignored){}
    }
}
