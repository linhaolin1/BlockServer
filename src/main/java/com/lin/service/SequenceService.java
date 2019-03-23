package com.lin.service;

public interface SequenceService {
	public Long genpProcessSequence(final int processId);

	public void save(String string, Long sequenceId, Long time, int processId, int blockId, Integer executeId,
			String remark);
}
