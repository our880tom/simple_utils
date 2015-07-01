package com.zhaoliang.utils;

import static com.google.common.base.Preconditions.checkArgument;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;

import com.google.common.base.Strings;
import com.google.common.io.Files;

public class ImageUtils {
	public static void reduceSize(String sourcePath, String destPath, int size) {
		checkArgument(!Strings.isNullOrEmpty(sourcePath), "sourcePath is empty");
		checkArgument(!Strings.isNullOrEmpty(destPath), "destPath is empty");
		
		try {
			File srcFile = new File(sourcePath);
			Image srcImg = ImageIO.read(srcFile);	
			long width = srcImg.getWidth(null);
			long height = srcImg.getHeight(null);
			String suffix = FilenameUtils.getExtension(srcFile.getName());
			
			BufferedImage tag = new BufferedImage((int) width,(int) height, BufferedImage.TYPE_INT_RGB);
			File tmp = srcFile;
			for(;tmp.length()>size;){
				tag.getGraphics().drawImage(srcImg.getScaledInstance((int)width, (int)height, Image.SCALE_SMOOTH), 0, 0, null);
				tmp = new File(generateDestPath(suffix));
				ImageIO.write(tag, suffix, tmp);   	
			}
			
			Files.createParentDirs(new File(destPath));
			Files.copy(tmp, new File(destPath));
		} catch (IOException e) {
			//throw new KuchuanRuntimeException("source path " + sourcePath + " destpath is " + destPath + " size is " + size, e);
		}
	}
	
	protected static String generateDestPath(String suffix) throws IOException {
		StringBuilder sb = new StringBuilder();
		//sb.append(PathUtils.getTempFolder()).append(File.separator);
		sb.append(Thread.currentThread().getName()).append(File.separator);
		sb.append(UUID.randomUUID()).append(".");
		sb.append(suffix);
		
		String filePath = sb.toString();
		Files.createParentDirs(new File(filePath));
		return filePath;
	}
}
