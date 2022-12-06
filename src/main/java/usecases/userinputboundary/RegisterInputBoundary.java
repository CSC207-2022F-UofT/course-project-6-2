package usecases.userinputboundary;

public class RegisterInputBoundary {
    private int age = -2;
    public int getAge(String ageText) {
        try {
            Double.parseDouble(ageText);
            this.age = Integer.parseInt(ageText);
        } catch(Exception ignored){}
        return age;
    }
}
