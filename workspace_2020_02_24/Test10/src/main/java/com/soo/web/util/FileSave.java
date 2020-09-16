package com.soo.web.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSave {
	public String save(String realPath, MultipartFile files) throws IOException {
		
		File file = new File(realPath);
		
		// 경로가 있는지 확인하기 = 없으면 생성하기
		if(!file.exists()) {
			file.mkdirs(); //상위 부모 폴더까지 생성 할 수있음 / mkdir 자기폴더만 생성
			
		}
		
		//유니크한 이름 만들기
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + files.getOriginalFilename();
		//이름이 ****-****-****-****_a.png 의 형태로 저장됨
		System.out.println("저장할 파일이름: " + fileName);
		System.out.println("실제 파일이름: " + files.getOriginalFilename());
		
		
		file = new File(file, fileName);
		FileCopyUtils.copy(files.getBytes(), file);
		
		
		return fileName;
	}
}
