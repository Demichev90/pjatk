package pl.pjatk.hibernate_mds.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "ETL_D_ENVIROMENT", schema = "ORACLE")
public class EtlEnvironmentModel {
    private String name;
    private String type;
    private String host;
    private String userName;
    private String userPass;
    private String oraStageSchema;
    private String description;
    private Long createdBy;
    private Long modifiedBy;
    private Timestamp createTs;
    private Timestamp updateTs;
    private Set<EtlProcessModel> etlProcessModels;

    @Id
    @Column(name = "NAME", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<EtlProcessModel> getEtlProcessModels() {
        return etlProcessModels;
    }

    public void setEtlProcessModels(Set<EtlProcessModel> etlProcessModels) {
        this.etlProcessModels = etlProcessModels;
    }

    @Basic
    @Column(name = "TYPE", nullable = true, length = 3)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "HOST", nullable = true, length = 30)
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_PASS", nullable = true, length = 500)
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Basic
    @Column(name = "ORA_STAGE_SCHEMA", nullable = true, length = 30)
    public String getOraStageSchema() {
        return oraStageSchema;
    }

    public void setOraStageSchema(String oraStageSchema) {
        this.oraStageSchema = oraStageSchema;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtlEnvironmentModel that = (EtlEnvironmentModel) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPass != null ? !userPass.equals(that.userPass) : that.userPass != null) return false;
        if (oraStageSchema != null ? !oraStageSchema.equals(that.oraStageSchema) : that.oraStageSchema != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (createTs != null ? !createTs.equals(that.createTs) : that.createTs != null) return false;
        if (updateTs != null ? !updateTs.equals(that.updateTs) : that.updateTs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
        result = 31 * result + (oraStageSchema != null ? oraStageSchema.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (createTs != null ? createTs.hashCode() : 0);
        result = 31 * result + (updateTs != null ? updateTs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EtlEnvironmentModel{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", oraStageSchema='" + oraStageSchema + '\'' +
                ", description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", modifiedBy=" + modifiedBy +
                ", createTs=" + createTs +
                ", updateTs=" + updateTs +
                '}';
    }
}
