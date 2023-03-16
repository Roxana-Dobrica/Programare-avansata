package lab3homework;

import java.time.LocalDate;

/**
 *
 * @author Roxana
 */
public class Programmer extends Person {

    private ProgrammerType programmerType;
    private String programmingLanguage;

    public Programmer(String name, LocalDate birthDate, ProgrammerType programmerType, String programmingLanguage) {
        super(name, birthDate);
        this.programmerType = programmerType;
        this.programmingLanguage = programmingLanguage;
    }

    public void setProgrammerType(ProgrammerType programmerType) {
        this.programmerType = programmerType;
    }

    public ProgrammerType getProgrammerType() {
        return programmerType;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    @Override
    public String toString() {
        return "Programmer{" + getName() + '}';
    }

}
