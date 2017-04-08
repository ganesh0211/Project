package org.usermanagement.core.util;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 8/4/17
 * Time: 11:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DateUtil {
    /**
     * get current local date
     *
     * @return Date
     */
    public Date getCurrentLocalDate();

    /**
     * get Current UTC date
     *
     * @return Date
     */
    public Date getCurrentUTCDate();

    /**
     * add days to date
     *
     * @param date
     * @param days
     * @return date
     */
    public Date addDaysToDate(Date date, long days);

    /**
     * add seconds to date
     *
     * @param date
     * @param seconds
     * @return date
     */
    public Date addSecondsToDate(Date date, long seconds);

    /**
     * add hours to date
     *
     * @param date
     * @param hours
     * @return date
     */
    public Date addHoursToDate(Date date, long hours);

    /**
     * add minutes to date
     *
     * @param date
     * @param minutes
     * @return date
     */
    public Date addMinutesToDate(Date date, long minutes);

    /**
     * add years to date
     *
     * @param date
     * @param years
     * @return date
     */
    public Date addYearsToDate(Date date, long years);

    /**
     * negate days from date
     *
     * @param date
     * @param days
     * @return date
     */
    public Date negateDaysToDate(Date date, long days);

    /**
     * negate seconds from date
     *
     * @param date
     * @param seconds
     * @return date
     */
    public Date negateSecondsToDate(Date date, long seconds);

    /**
     * negate hours from date
     *
     * @param date
     * @param hours
     * @return date
     */
    public Date negateHoursToDate(Date date, long hours);

    /**
     * negate minutes from date
     *
     * @param date
     * @param minutes
     * @return date
     */
    public Date negateMinutesToDate(Date date, long minutes);

    /**
     * negate years from date
     *
     * @param date
     * @param years
     * @return date
     */
    public Date negateYearsToDate(Date date, long years);


}
