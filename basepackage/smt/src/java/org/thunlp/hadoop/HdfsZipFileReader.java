package org.thunlp.hadoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipInputStream;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;

/**
 * 用于读取HDFS上的*.zip文件，文件内容应为纯文本文件
 * 
 * @author lipeng
 *
 */
public class HdfsZipFileReader implements HdfsReader {
	private BufferedReader reader;

	public HdfsZipFileReader(Path path) throws IOException {
		this(path, FileSystem.get(new JobConf()));
	}

	public HdfsZipFileReader(Path path, FileSystem fs) throws IOException {
		ZipInputStream gis = new ZipInputStream(fs.open(path));
		InputStreamReader isr = new InputStreamReader(gis);
		reader = new BufferedReader(isr);
	}

	public String readLine() throws IOException {
		if (reader == null)
			return null;
		else
			return reader.readLine();
	}

	public void close() throws IOException {
		if (reader != null) {
			reader.close();
		}
	}
}
