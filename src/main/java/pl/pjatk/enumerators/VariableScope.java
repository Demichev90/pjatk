package pl.pjatk.enumerators;


public enum VariableScope {
    ITEM_VARIABLE("ITEM_VARIABLE"),
    PROCESS_VARIABLE("PROCESS_VARIABLE"),
    GLOBAL_VARIABLE("GLOBAL_VARIABLE");


    private String scope;

    VariableScope(String scope){
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }
}
