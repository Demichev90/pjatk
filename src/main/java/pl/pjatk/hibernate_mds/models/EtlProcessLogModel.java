package pl.pjatk.hibernate_mds.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ETL_PROCESSES_LOG", schema = "ORACLE")
public class EtlProcessLogModel implements Serializable {
    private Long logId;
    private Long processId;
    private String calendar;
    private String runType;
    private String envNameF;
    private String envNameS;
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
    private Timestamp startTm;
    private Timestamp endTm;
    private String status;
    private String statusDesc;
    private List<EtlVariableLogModel> etl_var_log;
    private List<EtlProcessItemsLogModel> etl_items;


    public EtlProcessLogModel() {
    }


    public void updateLogModel(EtlProcessModel etlProcessModel){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GEN_ID_PROC")
    @SequenceGenerator(name="GEN_ID_PROC", sequenceName="SEQ_ETL_PROC_LOG",allocationSize=1)
    @Column(name = "LOG_ID", nullable = true, precision = 0)
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;

    }

    @Basic
    @Column(name = "ENV_NAME_F", nullable = true, length = 30)
    public String getEnvNameF() {
        return envNameF;
    }

    public void setEnvNameF(String envNameF) {
        this.envNameF = envNameF;

    }

    @Basic
    @Column(name = "ENV_NAME_S", nullable = true, length = 30)
    public String getEnvNameS() {
        return envNameS;
    }

    public void setEnvNameS(String envNameS) {
        this.envNameS = envNameS;
    }


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
        if(triggerExpression != null && triggerExpression.length() > 3000)
            this.triggerExpression = triggerExpression.substring(0, 2999);
        else
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
    @Column(name = "DESCRIPTION", nullable = true, length = 1000)
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

    @Basic
    @Column(name = "START_TM", nullable = true)
    public Timestamp getStartTm() {
        return startTm;
    }

    public void setStartTm(Timestamp startTm) {
        this.startTm = startTm;

    }

    @Basic
    @Column(name = "END_TM", nullable = true)
    public Timestamp getEndTm() {
        return endTm;
    }

    public void setEndTm(Timestamp endTm) {
        this.endTm = endTm;

    }

    @Basic
    @Column(name = "STATUS", nullable = true, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

    @Basic
    @Column(name = "STATUS_DESC", nullable = true, length = 1000)
    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlProcessLogModel that = (EtlProcessLogModel) o;

        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;
        if (processId != null ? !processId.equals(that.processId) : that.processId != null) return false;
        if (calendar != null ? !calendar.equals(that.calendar) : that.calendar != null) return false;
        if (runType != null ? !runType.equals(that.runType) : that.runType != null) return false;
        if (envNameF != null ? !envNameF.equals(that.envNameF) : that.envNameF != null) return false;
        if (envNameS != null ? !envNameS.equals(that.envNameS) : that.envNameS != null) return false;
        if (triggerExpression != null ? !triggerExpression.equals(that.triggerExpression) : that.triggerExpression != null)
            return false;
        if (triggerWaitFor != null ? !triggerWaitFor.equals(that.triggerWaitFor) : that.triggerWaitFor != null)
            return false;
        if (triggerCheckPeriod != null ? !triggerCheckPeriod.equals(that.triggerCheckPeriod) : that.triggerCheckPeriod != null)
            return false;
        if (triggerCheckCounts != null ? !triggerCheckCounts.equals(that.triggerCheckCounts) : that.triggerCheckCounts != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createTs != null ? !createTs.equals(that.createTs) : that.createTs != null) return false;
        if (updateTs != null ? !updateTs.equals(that.updateTs) : that.updateTs != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (startTm != null ? !startTm.equals(that.startTm) : that.startTm != null) return false;
        if (endTm != null ? !endTm.equals(that.endTm) : that.endTm != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (statusDesc != null ? !statusDesc.equals(that.statusDesc) : that.statusDesc != null) return false;
        if (etl_var_log != null ? !etl_var_log.equals(that.etl_var_log) : that.etl_var_log != null) return false;
        return etl_items != null ? etl_items.equals(that.etl_items) : that.etl_items == null;
    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + (processId != null ? processId.hashCode() : 0);
        result = 31 * result + (calendar != null ? calendar.hashCode() : 0);
        result = 31 * result + (runType != null ? runType.hashCode() : 0);
        result = 31 * result + (envNameF != null ? envNameF.hashCode() : 0);
        result = 31 * result + (envNameS != null ? envNameS.hashCode() : 0);
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
        result = 31 * result + (startTm != null ? startTm.hashCode() : 0);
        result = 31 * result + (endTm != null ? endTm.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (statusDesc != null ? statusDesc.hashCode() : 0);
        result = 31 * result + (etl_var_log != null ? etl_var_log.hashCode() : 0);
        result = 31 * result + (etl_items != null ? etl_items.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "etl_process", cascade=CascadeType.ALL)
    public List<EtlVariableLogModel> getEtl_var_log() {
        return etl_var_log;
    }

    public void setEtl_var_log(List<EtlVariableLogModel> etl_var_log) {
        this.etl_var_log = etl_var_log;

    }

    @OneToMany(mappedBy = "processLogModel", cascade=CascadeType.ALL)
    public List<EtlProcessItemsLogModel> getEtl_items() {
        return etl_items;
    }

    public void setEtl_items(List<EtlProcessItemsLogModel> etl_items) {
        this.etl_items = etl_items;

    }
}
