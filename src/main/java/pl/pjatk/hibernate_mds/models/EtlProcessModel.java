package pl.pjatk.hibernate_mds.models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "ETL_PROCESS_LIST", schema = "ORACLE")
public class EtlProcessModel {
    private Long processId;
    private String calendar;
    private String runType;
    private String triggerExpression;
    private Long triggerWaitFor;
    private Long triggerCheckPeriod;
    private Long triggerCheckCounts;
    private String description;
    private Long createdBy;
    private Long modifiedBy;
    private Timestamp createTs;
    private Timestamp updateTs;
    private String active;
    private Set<EtlEnvironmentModel> enviromentModelSet;
    private List<EtlProcItemModel> etl_items;
    private Set<EtlVariableModel> etlDVariable;



    @Id
    @Column(name = "PROCESS_ID", nullable = true, precision = 0)
    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    @Basic
    @Column(name = "CALENDAR", nullable = true, length = 4000)
    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }


    @Basic
    @Column(name = "RUN_TYPE", nullable = true, length = 7)
    public String getRunType() {
        return runType;
    }

    public void setRunType(String runType) {
        this.runType = runType;
    }

    @Basic
    @Column(name = "TRIGGER_EXPRESSION", nullable = true)
    public String getTriggerExpression() {
        return triggerExpression;
    }

    public void setTriggerExpression(String triggerExpression) {
        this.triggerExpression = triggerExpression;
    }

    @Basic
    @Column(name = "TRIGGER_WAIT_FOR", nullable = true, precision = 0)
    public Long getTriggerWaitFor() {
        return triggerWaitFor;
    }

    public void setTriggerWaitFor(Long triggerWaitFor) {
        this.triggerWaitFor = triggerWaitFor;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ETL_PROCESS_ENV", schema = "ORACLE", joinColumns = {
            @JoinColumn(name = "PROCESS_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "NAME") })
    public Set<EtlEnvironmentModel> getEnviromentModelSet() {
        return enviromentModelSet;
    }

    public void setEnviromentModelSet(Set<EtlEnvironmentModel> enviromentModelSet) {
        this.enviromentModelSet = enviromentModelSet;
    }


    @Basic
    @Column(name = "TRIGGER_CHECK_PERIOD", nullable = true, precision = 0)
    public Long getTriggerCheckPeriod() {
        return triggerCheckPeriod;
    }

    public void setTriggerCheckPeriod(Long triggerCheckPeriod) {
        this.triggerCheckPeriod = triggerCheckPeriod;
    }

    @Basic
    @Column(name = "TRIGGER_CHECK_COUNTS", nullable = true, precision = 0)
    public Long getTriggerCheckCounts() {
        return triggerCheckCounts;
    }

    public void setTriggerCheckCounts(Long triggerCheckCounts) {
        this.triggerCheckCounts = triggerCheckCounts;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "CREATED_BY", nullable = true, precision = 0)
    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "MODIFIED_BY", nullable = true, precision = 0)
    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "CREATE_TS", nullable = true)
    public Timestamp getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Timestamp createTs) {
        this.createTs = createTs;
    }

    @Basic
    @Column(name = "UPDATE_TS", nullable = true)
    public Timestamp getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Timestamp updateTs) {
        this.updateTs = updateTs;
    }

    @Basic
    @Column(name = "ACTIVE", nullable = true, length = 1)
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlProcessModel that = (EtlProcessModel) o;

        if (processId != null ? !processId.equals(that.processId) : that.processId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = processId != null ? processId.hashCode() : 0;
        result = 31 * result + (calendar != null ? calendar.hashCode() : 0);
        result = 31 * result + (runType != null ? runType.hashCode() : 0);
        result = 31 * result + (triggerExpression != null ? triggerExpression.hashCode() : 0);
        result = 31 * result + (triggerWaitFor != null ? triggerWaitFor.hashCode() : 0);
        result = 31 * result + (triggerCheckPeriod != null ? triggerCheckPeriod.hashCode() : 0);
        result = 31 * result + (triggerCheckCounts != null ? triggerCheckCounts.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createTs != null ? createTs.hashCode() : 0);
        result = 31 * result + (updateTs != null ? updateTs.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "etl_process", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @OrderBy("item_order")
    @NotFound(action = NotFoundAction.IGNORE)
    public List<EtlProcItemModel> getEtl_items() {
        return etl_items;
    }

    public void setEtl_items(List<EtlProcItemModel> etl_items) {
        this.etl_items = etl_items;
    }

    @OneToMany(mappedBy = "etl_precess",  fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    public Set<EtlVariableModel> getEtlDVariables() {
        return etlDVariable;
    }

    public void setEtlDVariables( Set<EtlVariableModel> etlDVariable) {
        this.etlDVariable = etlDVariable;
    }

    @Transient
    public EtlEnvironmentModel getTDEnvironment(){
        EtlEnvironmentModel etlEnvironmentModelesult = null;
        for(EtlEnvironmentModel etlEnvironmentModel : getEnviromentModelSet()){
            if(etlEnvironmentModel.getType().trim().equalsIgnoreCase("TD")){
                etlEnvironmentModelesult = etlEnvironmentModel;
            }
        }
        return etlEnvironmentModelesult;
    }

    @Transient
    public EtlEnvironmentModel getOraEnvironment(){
        EtlEnvironmentModel etlEnvironmentModelesult = null;
        for(EtlEnvironmentModel etlEnvironmentModel : getEnviromentModelSet()){
            if(etlEnvironmentModel.getType().trim().equalsIgnoreCase("ORA")){
                etlEnvironmentModelesult = etlEnvironmentModel;
            }
        }
        return etlEnvironmentModelesult;
    }


}
