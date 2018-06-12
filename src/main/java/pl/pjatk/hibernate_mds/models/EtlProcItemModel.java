package pl.pjatk.hibernate_mds.models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "ETL_PROCESS_ITEMS", schema = "ORACLE")
public class EtlProcItemModel {
    private Long itemId;
    private String itemType;
    private String tdSql;
    private String errorHandle;
    private String continueIf0Rows;
    private String oraTarget;
    private String oraDelRules;
    private Long itemOrder;
    private String description;
    private String metaFastexport;
    private String metaSqlloader;
    private String metaStageCreateSql;
    private Long createdBy;
    private Long modifiedBy;
    private Timestamp createTs;
    private Timestamp updateTs;
    private String active;
    private EtlProcessModel etl_process;
    private Set<EtlVariableModel> etlDVariables;

    public EtlProcItemModel() {}

    @Id
    @Column(name = "ITEM_ID", nullable = true, precision = 0)
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "ITEM_TYPE", nullable = true, length = 30)
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Basic
    @Column(name = "TD_SQL", nullable = true)
    public String getTdSql() {
        return tdSql;
    }

    public void setTdSql(String tdSql) {
        this.tdSql = tdSql;
    }

    @Basic
    @Column(name = "ERROR_HANDLE", nullable = true, length = 30)
    public String getErrorHandle() {
        return errorHandle;
    }

    public void setErrorHandle(String errorHandle) {
        this.errorHandle = errorHandle;
    }

    @Basic
    @Column(name = "CONTINUE_IF_0_ROWS", nullable = true, length = 1)
    public String getContinueIf0Rows() {
        return continueIf0Rows;
    }

    public void setContinueIf0Rows(String continueIf0Rows) {
        this.continueIf0Rows = continueIf0Rows;
    }

    @Basic
    @Column(name = "ORA_TARGET", nullable = true, length = 50)
    public String getOraTarget() {
        return oraTarget;
    }

    public void setOraTarget(String oraTarget) {
        this.oraTarget = oraTarget;
    }

    @Basic
    @Column(name = "ORA_DEL_RULES", nullable = true, length = 3000)
    public String getOraDelRules() {
        return oraDelRules;
    }

    public void setOraDelRules(String oraDelRules) {
        this.oraDelRules = oraDelRules;
    }

    @Basic
    @Column(name = "ITEM_ORDER", nullable = true, precision = 0)
    public Long getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Long itemOrder) {
        this.itemOrder = itemOrder;
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
    @Column(name = "META_FASTEXPORT", nullable = true)
    public String getMetaFastexport() {
        return metaFastexport;
    }

    public void setMetaFastexport(String metaFastexport) {
        this.metaFastexport = metaFastexport;
    }

    @Basic
    @Column(name = "META_SQLLOADER", nullable = true)
    public String getMetaSqlloader() {
        return metaSqlloader;
    }

    public void setMetaSqlloader(String metaSqlloader) {
        this.metaSqlloader = metaSqlloader;
    }

    @Basic
    @Column(name = "META_STAGE_CREATE_SQL", nullable = true, length = 3000)
    public String getMetaStageCreateSql() {
        return metaStageCreateSql;
    }

    public void setMetaStageCreateSql(String metaStageCreateSql) {
        this.metaStageCreateSql = metaStageCreateSql;
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

        EtlProcItemModel that = (EtlProcItemModel) o;

        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (itemType != null ? !itemType.equals(that.itemType) : that.itemType != null) return false;
        if (tdSql != null ? !tdSql.equals(that.tdSql) : that.tdSql != null) return false;
        if (errorHandle != null ? !errorHandle.equals(that.errorHandle) : that.errorHandle != null) return false;
        if (continueIf0Rows != null ? !continueIf0Rows.equals(that.continueIf0Rows) : that.continueIf0Rows != null)
            return false;
        if (oraTarget != null ? !oraTarget.equals(that.oraTarget) : that.oraTarget != null) return false;
        if (oraDelRules != null ? !oraDelRules.equals(that.oraDelRules) : that.oraDelRules != null) return false;
        if (itemOrder != null ? !itemOrder.equals(that.itemOrder) : that.itemOrder != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (metaFastexport != null ? !metaFastexport.equals(that.metaFastexport) : that.metaFastexport != null)
            return false;
        if (metaSqlloader != null ? !metaSqlloader.equals(that.metaSqlloader) : that.metaSqlloader != null)
            return false;
        if (metaStageCreateSql != null ? !metaStageCreateSql.equals(that.metaStageCreateSql) : that.metaStageCreateSql != null)
            return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createTs != null ? !createTs.equals(that.createTs) : that.createTs != null) return false;
        if (updateTs != null ? !updateTs.equals(that.updateTs) : that.updateTs != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (etl_process != null ? !etl_process.equals(that.etl_process) : that.etl_process != null) return false;

        return (etlDVariables != null ? !etlDVariables.equals(that.etlDVariables) : that.etlDVariables != null);


    }

    @Override
    public int hashCode() {
        int result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + (itemType != null ? itemType.hashCode() : 0);
        result = 31 * result + (tdSql != null ? tdSql.hashCode() : 0);
        result = 31 * result + (errorHandle != null ? errorHandle.hashCode() : 0);
        result = 31 * result + (continueIf0Rows != null ? continueIf0Rows.hashCode() : 0);
        result = 31 * result + (oraTarget != null ? oraTarget.hashCode() : 0);
        result = 31 * result + (oraDelRules != null ? oraDelRules.hashCode() : 0);
        result = 31 * result + (itemOrder != null ? itemOrder.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (metaFastexport != null ? metaFastexport.hashCode() : 0);
        result = 31 * result + (metaSqlloader != null ? metaSqlloader.hashCode() : 0);
        result = 31 * result + (metaStageCreateSql != null ? metaStageCreateSql.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createTs != null ? createTs.hashCode() : 0);
        result = 31 * result + (updateTs != null ? updateTs.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (etl_process != null ? etl_process.hashCode() : 0);
        result = 31 * result + (etlDVariables != null ? etlDVariables.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "PROCESS_ID", referencedColumnName = "PROCESS_ID")
    public EtlProcessModel getEtl_process() {
        return etl_process;
    }

    public void setEtl_process(EtlProcessModel etl_process) {
        this.etl_process = etl_process;
    }

    @OneToMany(mappedBy = "etl_item",  fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    public Set<EtlVariableModel> getEtlDVariables() {
        return etlDVariables;
    }

    public void setEtlDVariables(Set<EtlVariableModel> etlDVariables) {
        this.etlDVariables = etlDVariables;
    }


    @Override
    public String toString() {
        return "EtlProcItemModel{" +
                "itemId=" + itemId +
                ", itemType='" + itemType + '\'' +
                ", tdSql='" + tdSql + '\'' +
                ", errorHandle='" + errorHandle + '\'' +
                ", continueIf0Rows='" + continueIf0Rows + '\'' +
                ", oraTarget='" + oraTarget + '\'' +
                ", oraDelRules='" + oraDelRules + '\'' +
                ", itemOrder=" + itemOrder +
                ", description='" + description + '\'' +
                ", metaFastexport='" + metaFastexport + '\'' +
                ", metaSqlloader='" + metaSqlloader + '\'' +
                ", metaStageCreateSql='" + metaStageCreateSql + '\'' +
                ", createdBy=" + createdBy +
                ", modifiedBy=" + modifiedBy +
                ", createTs=" + createTs +
                ", updateTs=" + updateTs +
                ", active='" + active + '\'' +
                ", etl_process=" + etl_process +
                '}';
    }

    @Transient
    public boolean isActiveTask(){
        return getActive().equalsIgnoreCase("T");
    }

    @Transient
    public boolean isTeradataTask() {
        return getItemType().startsWith("TD");
    }

    @Transient
    public boolean continueIfZeroRows() {
        return getContinueIf0Rows().equalsIgnoreCase("T");
    }

    @Transient
    public boolean isOracleDeleteRulesPresented(){
       return getOraDelRules() != null && !getOraDelRules().equalsIgnoreCase("");
    }

    @Transient
    public boolean stopProcessOnError() {
        return getErrorHandle().trim().equalsIgnoreCase("STOP FULL PROCESS");
    }
}
