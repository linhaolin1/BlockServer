package com.lin.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FileManager {
	StorageClient storageClient;

	public FileManager(String conf) {
		try {
			ClientGlobal.init(conf);

			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getConnection();
			StorageServer storageServer = null;

			storageClient = new StorageClient(trackerServer, storageServer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	public StorageClient getStorageClient() {
		return storageClient;
	}

	public void setStorageClient(StorageClient storageClient) {
		this.storageClient = storageClient;
	}

}
