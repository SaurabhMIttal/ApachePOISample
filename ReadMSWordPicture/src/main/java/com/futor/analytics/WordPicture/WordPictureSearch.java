package com.futor.analytics.WordPicture;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Picture;

public class WordPictureSearch {
public static void main(String[] args){
	try{
	InputStream in = new FileInputStream(new File("F:/Security/Document/keystone BPM/Keystone BPM Web Services API.doc"));
	HWPFDocument doc = new HWPFDocument(in);
	List<Picture> pix = doc.getPicturesTable().getAllPictures();
    //ByteArrayOutputStream osByteArray = new ByteArrayOutputStream();
	FileOutputStream osByteArray = new FileOutputStream("test.jpg");
    ByteArrayInputStream inputStream = new ByteArrayInputStream(pix.get(0).getContent());
    BufferedImage bufferedImage = ImageIO.read(inputStream); 
    ImageOutputStream outputStream = ImageIO.createImageOutputStream(osByteArray);
    ImageIO.write(bufferedImage, "jpg", outputStream);
    outputStream.flush();
    outputStream.close();
    
	
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
}
}
