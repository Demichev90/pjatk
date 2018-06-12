package pl.pjatk.enumerators;

/**
 * Created by 169785 on 2017-08-16.
 */
public enum EtlProcessState {
    STARTED("STARTED"),
    INITIALIZED("INITIALIZED"),
    ABORTED("ABORTED"),
    ON_TRIGGER ("ON_TRIGGER"),
    COMPLETED ("COMPLETED"),
    COMPLETED_WITH_ERRORS("COMPLETED_WITH_ERRORS"),
    CREATED ("CREATED"),
    RUNNING ("RUNNING"),
    SUSPENDED ("SUSPENDED"),
    TERMINATED ("TERMINATED");

    private String title;

    EtlProcessState(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
