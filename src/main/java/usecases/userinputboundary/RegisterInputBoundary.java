package usecases.userinputboundary;

public class RegisterInputBoundary {
    private int age = -2;
    public RegisterInputBoundary(String ageText) {
        try {
            Double.parseDouble(ageText);
            this.age = Integer.parseInt(ageText);
        } catch(Exception ignored){}
    }
    public int getAge() {
        return age;
    }
}
