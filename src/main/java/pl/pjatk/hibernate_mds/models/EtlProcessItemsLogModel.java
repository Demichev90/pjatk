package pl.pjatk.hibernate_mds.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "ETL_PROCESS_ITEMS_LOG", schema = "ORACLE")
public class EtlProcessItemsLogModel  implements Serializable {
    private Long id;
    private Long logId;
    private Long itemId;
    private Long processId;
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
    private Timestamp startTm;
    private Timestamp endTm;
    private String status;
    private String statusDesc;
    private String warningMsg;
    private EtlProcessLogModel processLogModel;
    private List<EtlVariableLogModel> etl_item_variables;



    public EtlProcessItemsLogModel() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ID_ITEM")
    @SequenceGenerator(name="GEN_ID_ITEM", sequenceName="SEQ_ETL_ITEM_LOG", allocationSize=1)
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
        if(tdSql != null && tdSql.length() > 3000)
            this.tdSql = tdSql.substring(0, 2999);
        else
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
        if(oraTarget != null && oraTarget.length() > 50)
            this.oraTarget = oraTarget.substring(0, 49);
        else
            this.oraTarget = oraTarget;
    }

    @Basic
    @Column(name = "ORA_DEL_RULES", nullable = true, length = 3000)
    public String getOraDelRules() {
        return oraDelRules;
    }

    public void setOraDelRules(String oraDelRules) {
        if(oraDelRules != null && oraDelRules.length() > 3000)
            this.oraDelRules = oraDelRules.substring(0, 2999);
        else
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

    @Basic
    @Column(name = "WARNING_MSG", nullable = true, length = 1000)
    public String getWarningMsg() {
        return warningMsg;
    }

    public void setWarningMsg(String warningMsg) {
        this.warningMsg = warningMsg;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlProcessItemsLogModel that = (EtlProcessItemsLogModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;
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
        if (startTm != null ? !startTm.equals(that.startTm) : that.startTm != null) return false;
        if (endTm != null ? !endTm.equals(that.endTm) : that.endTm != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (statusDesc != null ? !statusDesc.equals(that.statusDesc) : that.statusDesc != null) return false;
        if (warningMsg != null ? !warningMsg.equals(that.warningMsg) : that.warningMsg != null) return false;
        if (processLogModel != null ? !processLogModel.equals(that.processLogModel) : that.processLogModel != null)
            return false;
        return etl_item_variables != null ? etl_item_variables.equals(that.etl_item_variables) : that.etl_item_variables == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (logId != null ? logId.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
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
        result = 31 * result + (startTm != null ? startTm.hashCode() : 0);
        result = 31 * result + (endTm != null ? endTm.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (statusDesc != null ? statusDesc.hashCode() : 0);
        result = 31 * result + (warningMsg != null ? warningMsg.hashCode() : 0);
        result = 31 * result + (processLogModel != null ? processLogModel.hashCode() : 0);
        result = 31 * result + (etl_item_variables != null ? etl_item_variables.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PROCESS_ID", referencedColumnName = "PROCESS_ID", insertable = false, updatable = false),
            @JoinColumn(name = "LOG_ID", referencedColumnName = "LOG_ID", insertable = false, updatable = false)})
    public EtlProcessLogModel getProcessLogModel() {
        return processLogModel;
    }

    public void setProcessLogModel(EtlProcessLogModel processLogModel) {
        this.processLogModel = processLogModel;

    }


    @OneToMany(mappedBy = "etl_process_item")
    public List<EtlVariableLogModel> getEtl_item_variables() {
        return etl_item_variables;
    }

    public void setEtl_item_variables(List<EtlVariableLogModel> etl_item_variables) {
        this.etl_item_variables = etl_item_variables;

    }
}
