package org.usermanagement.core.scheduler;

import java.util.Map;
import org.usermanagement.core.exception.BusinessException;

public interface SchedulerManager {
	/**
	 * 
	 * @param name
	 * @param group
	 * @param cronJob
	 * @param cronPattern
	 * @param timeInterval
	 * @param jobDataMap
	 * @param implementation
	 * @return
	 * @throws BusinessException
	 */
	
	public void createJob(String name, String group, boolean cronJob, 
			String cronPattern, int timeInterval, Map<Object,Object> jobDataMap, Class implementation) throws BusinessException;
	/**
	 * 
	 * @param name
	 * @param group
	 * @return
	 * @throws BusinessException 
	 */
	public void deleteJob(String name, String group) throws BusinessException;
	
	/**
	 * 
	 * @param name
	 * @param group
	 * @return
	 * @throws BusinessException 
	 */
	public void pauseJob(String name, String group) throws BusinessException;
	
	/**
	 * 
	 * @param name
	 * @param group
	 * @return
	 * @throws BusinessException 
	 */
	public void resumeJob(String name, String group) throws BusinessException;
	
	/**
	 * @throws BusinessException 
	 *
	 *
	 */
	public void pauseAllJob() throws BusinessException;
	
	/**
	 * @throws BusinessException 
	 * 
	 *
	 */
	public void resumeAllJob() throws BusinessException;
	
}
