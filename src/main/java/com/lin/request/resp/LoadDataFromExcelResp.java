package com.lin.request.resp;

import java.util.List;

import com.lin.request.CommonResp;
import com.lin.service.impl.DataServiceImpl.LoadData;

public class LoadDataFromExcelResp extends CommonResp {
	LoadData problemData;
	Long sequenceId;

	int addDataCount;
	int modifyDataCount;
	int deleteDataCount;

	List<String> newColumns;

	public List<String> getNewColumns() {
		return newColumns;
	}

	public void setNewColumns(List<String> newColumns) {
		this.newColumns = newColumns;
	}

	public int getAddDataCount() {
		return addDataCount;
	}

	public void setAddDataCount(int addDataCount) {
		this.addDataCount = addDataCount;
	}

	public int getModifyDataCount() {
		return modifyDataCount;
	}

	public void setModifyDataCount(int modifyDataCount) {
		this.modifyDataCount = modifyDataCount;
	}

	public int getDeleteDataCount() {
		return deleteDataCount;
	}

	public void setDeleteDataCount(int deleteDataCount) {
		this.deleteDataCount = deleteDataCount;
	}

	public Long getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(Long sequenceId) {
		this.sequenceId = sequenceId;
	}

	public LoadData getProblemData() {
		return problemData;
	}

	public void setProblemData(LoadData problemData) {
		this.problemData = problemData;
	}

}
