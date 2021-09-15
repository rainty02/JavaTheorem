package com.bitcamp.cob.cafe.controller;

import java.util.List;

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
	public String fileDelete(CafeImgInfo cafeImgInfo) {
		return "cafe/fileDel";
	}
	
	@RequestMapping(value="/cafe/fileDel", method= RequestMethod.POST)
	@ResponseBody
	public List<CafeImgInfo> fileDelete1(CafeImgInfo cafeImgInfo) {
		List<CafeImgInfo> cafeImg = null;
		
		cafeImg = fdService.getImgList(cafeImgInfo);
		System.out.println("fileDelete get 메소드"+cafeImg);
		return cafeImg;
	}
}
