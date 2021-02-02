package com.ducdm.main;

import com.ducdm.model.Bmp;
import com.ducdm.model.Gif;
import com.ducdm.model.Jpg;
import com.ducdm.model.Png;
import com.ducdm.repo.IFile;

public class GraphicsEditor {
	private IFile bmp = new Bmp();
	private IFile gif = new Gif();
	private IFile png = new Png();
	private IFile jpg = new Jpg();

	public void getFile(String fileName) throws Exception {
		String extension = fileName.substring(fileName.length() - 3);
		switch (extension) {
		case "bmp":
			bmp.openFile(fileName);
			break;
		case "gif":
			gif.openFile(fileName);
			break;
		case "png":
			png.openFile(fileName);
			break;
		case "jpg":
			jpg.openFile(fileName);
			break;
		default:
			throw (new Exception("Unknown file type"));
		}
	}
	
	public static void main(String[] args) {
		GraphicsEditor ge = new GraphicsEditor();
		try {
			ge.getFile("jpg");
			ge.getFile("gif");
			ge.getFile("bmp");
			ge.getFile("png");
		} catch (Exception e) {
			e.toString();
		}
		
	}
}
