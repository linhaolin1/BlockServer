package com.lin.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FileManager {
	private StorageClient storageClient;

	public FileManager(String conf) {
		try {
			ClientGlobal.init(conf);

			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getTrackerServer();
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

	public String[] upload_file(byte[] file_buff, String file_ext_name, NameValuePair[] meta_list)
			throws IOException, MyException {
		return storageClient.upload_file(file_buff, file_ext_name, meta_list);
	}

	public byte[] download_file(String group, String path) throws IOException, MyException {
		return storageClient.download_file(group, path);
	}
}
