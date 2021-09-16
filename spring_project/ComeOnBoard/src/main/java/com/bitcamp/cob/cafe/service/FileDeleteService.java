package com.bitcamp.cob.cafe.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cob.cafe.dao.CafeDao;
import com.bitcamp.cob.cafe.domain.CafeImgInfo;

@Service
public class FileDeleteService {

	@Autowired
	private SqlSessionTemplate template;
	
	final String UPLOAD_URI = "/uploadfile/cafe/";
	
	public List<CafeImgInfo> getImgList(CafeImgInfo cafeImgInfo) {
		return template.getMapper(CafeDao.class).getImgList(cafeImgInfo);
	}

	public int delImg(CafeImgInfo cafeImgInfo, HttpServletRequest request) {
		
		String path = cafeImgInfo.getCafeIdx()+"."+cafeImgInfo.getCafeName()+"/"+cafeImgInfo.getCafeImg();
		
		File file = new File(request.getSession().getServletContext().getRealPath(UPLOAD_URI+path));
		System.out.println("delImg file 경로 : "+file);
		if(file.isFile()) {
			file.delete();
			System.out.println(file.getName()+" 파일이 삭제되었습니다");
		}
		return template.getMapper(CafeDao.class).delImg(cafeImgInfo.getCafeImgIdx());
	}

}
