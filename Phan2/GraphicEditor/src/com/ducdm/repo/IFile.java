package com.ducdm.repo;

public interface IFile {
	void openFile(String fileName);
    void parseFile();
    void saveFile();
    String getFileOpenned();
}
