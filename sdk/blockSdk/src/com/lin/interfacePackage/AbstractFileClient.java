package com.lin.interfacePackage;

public interface AbstractFileClient {
	public String uploadFile();

	byte[] downloadFile(String path);
}
