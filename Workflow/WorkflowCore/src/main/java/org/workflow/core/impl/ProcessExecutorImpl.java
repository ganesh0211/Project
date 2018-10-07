package org.workflow.core.impl;

import org.workflow.core.ProcessExecutor;

public class ProcessExecutorImpl implements ProcessExecutor {

	private Process process;
	
	public void execute() {
		// TODO Auto-generated method stub

	}
	
	public Process setProcess(Process process) {
		this.process = process;
		return this.process;
	}
	
	public Process getProcess(){
		return this.process;
	}
	
}
