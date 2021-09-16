package com.bitcamp.cob.cafe.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.cob.cafe.dao.CafeDao;
import com.bitcamp.cob.cafe.domain.Cafe;
import com.bitcamp.cob.cafe.domain.CafeImgInfo;

@Service
public class CafeInfoService {

	@Autowired
	private SqlSessionTemplate template;
	
	final String UPLOAD_URI = "/uploadfile/cafe/";
	
	// 카페 정보 출력
	public Cafe getCafeInfo(int idx) {
		return template.getMapper(CafeDao.class).getCafeInfo(idx);		
	}
	
	// 카페 정보 등록
	public int regCafe(Cafe cafe) {
		return template.getMapper(CafeDao.class).regCafe(cafe);
	}
	
	// 카페 썸네일 등록
	public int regCafeThumbnail(Cafe cafe, HttpServletRequest request) {
		
		int result = 0;
		File newDir = null;
		File newFile = null;
		String cafeThumbnail = null;
		
		CafeImgInfo cafeIdxName = template.getMapper(CafeDao.class).getCafeIdxName(cafe.getMemIdx());
		
		cafe.setCafeIdx(cafeIdxName.getCafeIdx());
		cafe.setCafeName(cafeIdxName.getCafeName());
		
		try {
			if (cafe.getCafeThumbnailFile() != null && !cafe.getCafeThumbnailFile().isEmpty()) {
	
				// 경로
				newDir = mkDir(cafe, request);

				// 파일 저장시에 파일 이름이 같으면 덮어쓴다 -> 회원별 고유한 파일 이름을 만들자!!, 새로운 파일이름에 확장자 추가
				// 파일이 하나만 등록되므로 같은 이름으로 만든다면 다른 수정 필요가 없음
				// thumbnail.확장자
				cafeThumbnail = "thumbnail." + chkFileType(cafe.getCafeThumbnailFile());
				cafe.setCafeThumbnail(cafeThumbnail);
				System.out.println("카페 인포서비스 regCafeThumbnail 메소드 - 카페 썸네일 이름 출력 : "+cafe.getCafeThumbnail());
				// 새로운 File 객체
				newFile = new File(newDir, cafeThumbnail);
				cafe.getCafeThumbnailFile().transferTo(newFile);

				// 변경된 파일 이름 DB 저장
				result = template.getMapper(CafeDao.class).regCafeThumbnail(cafeThumbnail, cafe.getCafeIdx());
			}
		} catch (IllegalStateException | IOException e) {
		e.printStackTrace();
		} catch (SQLException e) {
			// DB 예외 발생 시 -> 저장된 파일을 삭제
			//if (newFile != null && newFile.exists()) {
			//	newFile.delete();
			//}
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	// 카페 이미지 등록
	public int regCafeImg(Cafe cafe, HttpServletRequest request) {
		
		int result = 0;
		File newDir = null;
		File newFile = null;
		String cafeImgs = null;

		CafeImgInfo cafeIdxName = template.getMapper(CafeDao.class).getCafeIdxName(cafe.getMemIdx());
		
		cafe.setCafeIdx(cafeIdxName.getCafeIdx());
		cafe.setCafeName(cafeIdxName.getCafeName());
		
		System.out.println("regCafeImg 메소드 후: "+ cafe);
		try {
			if (cafe.getCafeImgFile() != null && cafe.getCafeImgFile().size() > 0) {
	
				// 경로
				newDir = mkDir(cafe, request);
				List<String> imgFiles = new ArrayList<String>();
				
				for(int i=0; i<cafe.getCafeImgFile().size(); i++) {

					// thumbnail.확장자
					cafeImgs = cafe.getCafeName()+System.currentTimeMillis()+"."+chkFileType(cafe.getCafeImgFile().get(i));
					imgFiles.add(cafeImgs);
					
					// 새로운 File 객체
					newFile = new File(newDir, cafeImgs);
					cafe.getCafeImgFile().get(i).transferTo(newFile);
	
					// 변경된 파일 이름 DB 저장
					if(template.getMapper(CafeDao.class).regCafeImg(cafeImgs, cafe.getCafeIdx(), cafe.getMemIdx()) == 1) {
						result++;
					}
				}
				cafe.setCafeImg(imgFiles);
				System.out.println("카페 인포서비스 regCafeImg 메소드 - 카페 이미지 이름 출력 : "+cafe.getCafeImg());
				
			}
		} catch (IllegalStateException | IOException e) {
		e.printStackTrace();
		} catch (SQLException e) {
			// DB 예외 발생 시 -> 저장된 파일을 삭제
			//if (newFile != null && newFile.exists()) {
			//	newFile.delete();
			//}
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	

//	public int regCafe(Cafe cafe, CafeImg cafeImg, HttpServletRequest request) {
//
//		int resultCnt = 0;
//		File newFile = null;
//		String fileList[] = new String[10];
//
//		try {
//			// dao 저장
//			// 결과값과 idx값 저장
//			resultCnt = template.getMapper(CafeDao.class).regCafe(cafe);
//			System.out.println("새롭게 등록된 idx => " + cafe.getCafeIdx());
//			
//			// 파일 저장
//			if (cafeImg.getCafeThumbnail() != null && !cafeImg.getCafeThumbnail().isEmpty()) {
//
//				File newDir = mkDir(cafe, request);
//
//				// 파일 저장시에 파일 이름이 같으면 덮어쓴다 -> 회원별 고유한 파일 이름을 만들자!!, 새로운 파일이름에 확장자 추가
//				// 카페이름.thumbnail.확장자
//				String cafeThumbnail = "thumbnail." + chkFileType(cafeImg.getCafeThumbnail());
//				
//				// 새로운 File 객체
//				newFile = new File(newDir, cafeThumbnail);
//				cafeImg.getCafeThumbnail().transferTo(newFile);
//				System.out.println("썸네일 : "+cafeThumbnail);
//				// 데이터베이스에 저장할 파일의 이름 설정
//				int resultThumbnail = template.getMapper(CafeDao.class).regCafeThumbnail(cafeThumbnail, cafe.getCafeIdx());
//			} 
//			
//			if (cafeImg.getCafeImg() != null && cafeImg.getCafeImg().length != 0) {
//
//				File newDir = mkDir(cafe, request);	
//				
//				for(int i=0; i<cafeImg.getCafeImg().length; i++) {
//					// 파일 저장시에 파일 이름이 같으면 덮어쓴다 -> 회원별 고유한 파일 이름을 만들자!!, 새로운 파일이름에 확장자 추가
//					// 카페이름.thumbnail.확장자
//					String cafeImgs = "img_"+i+"."+chkFileType(cafeImg.getCafeImg()[i]);
//					// 새로운 File 객체
//					newFile = new File(newDir, cafeImgs);
//					cafeImg.getCafeImg()[i].transferTo(newFile);
//					System.out.println("이미지 : " + cafeImgs);
//					// 데이터베이스에 저장할 파일의 이름 설정
//					int resultImg = template.getMapper(CafeDao.class).regCafeImg(cafeImgs, cafe.getCafeIdx());
//				}
//			}	
//
//		} catch (IllegalStateException | IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// DB 예외 발생 시 -> 저장된 파일을 삭제
//			if (newFile != null && newFile.exists()) {
//				newFile.delete();
//			}
//			e.printStackTrace();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		return resultCnt;
//	}

	// 파일의 ContentType 과 파일 확장자를 체크
	private String chkFileType(MultipartFile file) throws Exception {
		String extension = "";

		// 업로드 파일의 contentType
		String contentType = file.getContentType();
		if (!(contentType.equals("image/jpeg") ||contentType.equals("image/jpg") || contentType.equals("image/png") || contentType.equals("image/gif"))) {
			throw new Exception("허용하지 않는 파일 타입 : " + contentType);
		}

		// 파일 확장자 구하기
		String fileName = file.getOriginalFilename();

		// String[] java.lang.String.split(String regex)
		// : 정규식의 패턴 문자열을 전달해야하기 때문에 \\. 으로 처리
		String[] nameTokens = fileName.split("\\."); /// tet.mini2.jpg PNG png

		// 토큰의 마지막 index의 문자열을 가져옴 : 배열의 개수-1
		extension = nameTokens[nameTokens.length - 1].toLowerCase();

		// 이미지 파일 이외의 파일 업로드 금지
		// 파일 확장자 체크
		if (!(extension.equals("jpeg") || extension.equals("jpg") || extension.equals("png") || extension.equals("gif"))) {
			throw new Exception("허용하지 않는 파일 확장자 타입 : " + contentType);
		}

		return extension;
	}
	
	// 파일 업로드시 카페idx와 카페명으로 폴더 생성
	private File mkDir(Cafe cafe, HttpServletRequest request) {
		
		// 새로운 저장 폴더 : File
		File newDir = new File(request.getSession().getServletContext().getRealPath(UPLOAD_URI+"/"+cafe.getCafeIdx()+"."+cafe.getCafeName()));

		// 폴더에 이미지가 있다면 전체 삭제
		// 정보 수정시 일괄등록이 아닌 선택 삭제 후 등록이 가능하면 전체 삭제하지 않아도 됨
		//if(newDir.exists()) {
		//	deleteDir(newDir);
		//}
		
		// 카페별 폴더 생성
		if (!newDir.exists()) {
			newDir.mkdir();
			System.out.println("카페 폴더를 생성했습니다.");
		}
		return newDir;
	}
	
	// 예외 발생시 폴더내 파일 삭제
	private void deleteDir(File newDir) {

		while(newDir.exists()) {
			File[] folder_list = newDir.listFiles() ; //파일리스트 얻어오기
			//System.out.println("folder_list : "+folder_list.toString());
			for(File f : folder_list) {
				if(f.isFile() && f.getName().toLowerCase().startsWith("img")) {
					f.delete(); //파일 삭제 
					System.out.println(f.getName()+" 파일이 삭제되었습니다.");	
				}
			}
	    }	
	}

	// 카페 정보 수정
	public int updateCafeInfo(Cafe cafe) {
		return template.getMapper(CafeDao.class).updateCafeInfo(cafe);
	}

}