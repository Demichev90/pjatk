package pl.pjatk.hibernate_mds.models;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ETL_D_VARIABLE", schema = "ORACLE")
public class EtlVariableModel {
    private Long v_id;
    private String varName;
    private String enviromentName;
    private String varSql;
    private String description;
    private Long createdBy;
    private Long modifiedBy;
    private Timestamp createTs;
    private Timestamp updateTs;
    private String active;
    private EtlProcessModel etl_precess;
    private EtlProcItemModel etl_item;
    @Id
    @Column(name = "V_ID", nullable = false, length = 30)
    public Long getV_id() {
        return v_id;
    }

    public void setV_id(Long v_id) {
        this.v_id = v_id;
    }


    @Column(name = "VAR_NAME", nullable = false, length = 30)
    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }


    @Basic
    @Column(name = "ENVIROMENT_NAME", nullable = true, length = 30)
    public String getEnviromentName() {
        return enviromentName;
    }

    public void setEnviromentName(String enviromentName) {
        this.enviromentName = enviromentName;

    }

    @Basic
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlVariableModel that = (EtlVariableModel) o;

        if (varName != null ? !varName.equals(that.varName) : that.varName != null) return false;
        if (enviromentName != null ? !enviromentName.equals(that.enviromentName) : that.enviromentName != null)
            return false;
        if (varSql != null ? !varSql.equals(that.varSql) : that.varSql != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createTs != null ? !createTs.equals(that.createTs) : that.createTs != null) return false;
        if (updateTs != null ? !updateTs.equals(that.updateTs) : that.updateTs != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (etl_precess != null ? !etl_precess.equals(that.etl_precess) : that.etl_precess != null) return false;
        return etl_item != null ? etl_item.equals(that.etl_item) : that.etl_item == null;
    }

    @Override
    public int hashCode() {
        int result = varName != null ? varName.hashCode() : 0;
        result = 31 * result + (enviromentName != null ? enviromentName.hashCode() : 0);
        result = 31 * result + (varSql != null ? varSql.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createTs != null ? createTs.hashCode() : 0);
        result = 31 * result + (updateTs != null ? updateTs.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (etl_precess != null ? etl_precess.hashCode() : 0);
        result = 31 * result + (etl_item != null ? etl_item.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "PROCESS_ID", referencedColumnName = "PROCESS_ID")
    public EtlProcessModel getEtl_precess() {
        return etl_precess;
    }

    public void setEtl_precess(EtlProcessModel etl_precess) {
        this.etl_precess = etl_precess;

    }

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
    public EtlProcItemModel getEtl_item() {
        return etl_item;
    }

    public void setEtl_item(EtlProcItemModel etl_item) {
        this.etl_item = etl_item;

    }
}
