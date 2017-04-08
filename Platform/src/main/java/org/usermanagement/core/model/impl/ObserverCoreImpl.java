package org.usermanagement.core.model.impl;

import org.usermanagement.core.model.Core;
import org.usermanagement.core.model.Observer;
import org.usermanagement.core.util.DateUtil;
import org.usermanagement.core.util.impl.DateUtilImpl;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 8/4/17
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class ObserverCoreImpl implements Core, Observer {
    /**
     * Date Util for data management
     */
    private static DateUtil dateUtil = new DateUtilImpl();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private Date creationDate;
    private Date modifiedDate;
    private boolean enabled;
    private long version;

    public long getId() {
        return id;
    }

    public long setId(long id) {
        this.id = id;
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description) {
        this.description = description;
        return this.description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this.creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public Date setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this.modifiedDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this.enabled;
    }

    public long getVersion() {
        return version;
    }

    public long setVersion(long version) {
        this.version = version;
        return this.version;
    }

    @Override
    public void updateVersion() {
        if (this.creationDate == null) {
            this.creationDate = dateUtil.getCurrentUTCDate();
        }
        this.modifiedDate = dateUtil.getCurrentUTCDate();
        this.version++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObserverCoreImpl)) return false;

        ObserverCoreImpl that = (ObserverCoreImpl) o;

        if (enabled != that.enabled) return false;
        if (id != that.id) return false;
        if (version != that.version) return false;
        if (creationDate != null && !creationDate.equals(that.creationDate)) return false;
        if (description != null && !description.equals(that.description)) return false;
        if (modifiedDate != null && !modifiedDate.equals(that.modifiedDate)) return false;
        if (name != null && !name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = (name != null) ? 31 * result + name.hashCode() : result;
        result = (description != null) ? 31 * result + description.hashCode() : result;
        result = (creationDate != null) ? 31 * result + creationDate.hashCode() : result;
        result = (modifiedDate != null) ? 31 * result + modifiedDate.hashCode() : result;
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (int) (version ^ (version >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ObserverCoreImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", modifiedDate=" + modifiedDate +
                ", enabled=" + enabled +
                ", version=" + version +
                "} " + super.toString();
    }


}
