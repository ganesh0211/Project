package org.usermanagement.core.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 8/4/17
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Core {
    /**
     * get Id
     *
     * @return Id
     */
    public long getId();

    /**
     * set ID
     *
     * @param id
     * @return id
     */
    public long setId(long id);

    /**
     * get Name
     *
     * @return name
     */
    public String getName();

    /**
     * Set Name
     *
     * @param name
     * @return name
     */
    public String setName(String name);

    /**
     * get Description
     *
     * @return description
     */
    public String getDescription();

    /**
     * Set description
     *
     * @param description
     * @return description
     */
    public String setDescription(String description);

    /**
     * get CreationDate
     *
     * @return creationDate
     */
    public Date getCreationDate();

    /**
     * set Creation Date
     *
     * @param creationDate
     * @return creation date
     */
    public Date setCreationDate(Date creationDate);

    /**
     * get Modified Date
     *
     * @return modified date
     */
    public Date getModifiedDate();

    /**
     * set modified date
     *
     * @param modifiedDate
     * @return modified date
     */
    public Date setModifiedDate(Date modifiedDate);

    /**
     * is enabled
     *
     * @return enabled
     */
    public boolean isEnabled();

    /**
     * set enabled
     *
     * @param enabled
     * @return enabled
     */
    public boolean setEnabled(boolean enabled);

    /**
     * get version
     *
     * @return version number
     */
    public long getVersion();

    /**
     * set version
     *
     * @param version
     * @return version
     */
    public long setVersion(long version);

    /**
     * notify and update the domain object
     */
    public void updateVersion();
}
