package com.bitcamp.cob.cafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.cob.cafe.domain.CafeImgInfo;
import com.bitcamp.cob.cafe.service.FileDeleteService;

@Controller
public class FileDeleteController {

	@Autowired
	private FileDeleteService fdService;
	
	
	@RequestMapping(value="/cafe/fileDel", method= RequestMethod.GET)
	public String viewPage(CafeImgInfo cafeImgInfo) {
		return "cafe/fileDel";
	}
	
	@RequestMapping(value="/cafe/fileDel", method= RequestMethod.POST)
	@ResponseBody
	public List<CafeImgInfo> viewFile(CafeImgInfo cafeImgInfo) {
		List<CafeImgInfo> cafeImg = null;
		//System.out.println("fileDelete get 메소드 전달값 : "+cafeImgInfo);
		cafeImg = fdService.getImgList(cafeImgInfo);
		//System.out.println("fileDelete get 반환값 : "+cafeImg);
		return cafeImg;
	}
	
	@RequestMapping(value="/cafe/fileDel1", method= RequestMethod.POST)
	@ResponseBody
	public int deleteFile(CafeImgInfo cafeImgInfo, HttpServletRequest request) {
		System.out.println("deleteFile 메소드 전달값 : " + cafeImgInfo);
		//System.out.println("deleteFile 메소드 전달값 : " + path);
		
		int result = 0;
		result = fdService.delImg(cafeImgInfo, request);
		return result;
	}
}
