import java.io.Serializable;

public class applicant implements Serializable{
    String number;
    String name;
    applicant(String number,String name){
        this.name=name;
        this.number=number;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    @Override
    public String toString() {
        return "Appliant Details:\n Name: "+name+"\nNumber: "+number;
    }
}