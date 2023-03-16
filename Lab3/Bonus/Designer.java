package lab3bonus;

import java.time.LocalDate;

/**
 *
 * @author Roxana Dobrica
 */
public class Designer extends Person {

    private String usedApplication;

    public Designer(String name, LocalDate birthDate, String usedApplication) {
        super(name, birthDate);
        this.usedApplication = usedApplication;
    }

    public void setUsedApplication(String usedApplication) {
        this.usedApplication = usedApplication;
    }

    public String getUsedApplication() {
        return usedApplication;
    }

    @Override
    public String toString() {
        return "Designer :" + getName();
    }

}
