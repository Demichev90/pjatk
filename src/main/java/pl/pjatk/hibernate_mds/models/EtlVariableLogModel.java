package pl.pjatk.hibernate_mds.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "ETL_D_VARIABLE_LOG", schema = "ORACLE")
public class EtlVariableLogModel implements Serializable {
    private Long id;
    private Long logId;
    private String varName;
    private Long processId;
    private Long itemId;
    private String enviromentName;
    private String varSql;
    private String description;
    private Long createdBy;
    private Long modifiedBy;
    private Timestamp createTs;
    private Timestamp updateTs;
    private String active;
    private String variableValue;
    private EtlProcessLogModel etl_process;
    private EtlProcessItemsLogModel etl_process_item;

    public EtlVariableLogModel() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ID_VAR")
    @SequenceGenerator(name="GEN_ID_VAR", sequenceName="SEQ_ETL_VAR_LOG",allocationSize=1)
    @Column(name = "ID", nullable = true, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

    }

    @Basic
    @Column(name = "LOG_ID", nullable = true, precision = 0)
    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;

    }

    @Basic
    @Column(name = "VAR_NAME", nullable = true, length = 30)
    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;

    }

    @Basic
    @Column(name = "PROCESS_ID", nullable = true, precision = 0)
    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;

    }

    @Basic
    @Column(name = "ITEM_ID", nullable = true, precision = 0)
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;

    }

    @Basic
    @Column(name = "ENVIROMENT_NAME", nullable = true, length = 30)
    public String getEnviromentName() {
        return enviromentName;
    }

    public void setEnviromentName(String enviromentName) {
        this.enviromentName = enviromentName;

    }

    @Lob
    @Column(name = "VAR_SQL", nullable = true)
    public String getVarSql() {
        return varSql;
    }

    public void setVarSql(String varSql) {
            this.varSql = varSql;
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

    @Basic
    @Column(name = "VARIABLE_VALUE", nullable = true, length = 300)
    public String getVariableValue() {
        return variableValue;
    }

    public void setVariableValue(String variableValue) {
        if(variableValue != null && variableValue.length() > 3000) {
            this.variableValue = variableValue.substring(0, 2999);
        } else {
            this.variableValue = variableValue;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlVariableLogModel that = (EtlVariableLogModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;
        if (varName != null ? !varName.equals(that.varName) : that.varName != null) return false;
        if (processId != null ? !processId.equals(that.processId) : that.processId != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (enviromentName != null ? !enviromentName.equals(that.enviromentName) : that.enviromentName != null)
            return false;
        if (varSql != null ? !varSql.equals(that.varSql) : that.varSql != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createTs != null ? !createTs.equals(that.createTs) : that.createTs != null) return false;
        if (updateTs != null ? !updateTs.equals(that.updateTs) : that.updateTs != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (variableValue != null ? !variableValue.equals(that.variableValue) : that.variableValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (logId != null ? logId.hashCode() : 0);
        result = 31 * result + (varName != null ? varName.hashCode() : 0);
        result = 31 * result + (processId != null ? processId.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (enviromentName != null ? enviromentName.hashCode() : 0);
        result = 31 * result + (varSql != null ? varSql.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createTs != null ? createTs.hashCode() : 0);
        result = 31 * result + (updateTs != null ? updateTs.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (variableValue != null ? variableValue.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "LOG_ID", referencedColumnName = "LOG_ID", insertable = false, updatable = false),
            @JoinColumn(name = "PROCESS_ID", referencedColumnName = "PROCESS_ID", insertable = false, updatable = false)})
    public EtlProcessLogModel getEtl_process() {
        return etl_process;
    }

    public void setEtl_process(EtlProcessLogModel etl_process) {
        this.etl_process = etl_process;

    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "LOG_ID", referencedColumnName = "LOG_ID", insertable = false, updatable = false),
            @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID", insertable = false, updatable = false)})
    public EtlProcessItemsLogModel getEtl_process_item() {
        return etl_process_item;
    }

    public void setEtl_process_item(EtlProcessItemsLogModel etl_process_item) {
        this.etl_process_item = etl_process_item;

    }

}
