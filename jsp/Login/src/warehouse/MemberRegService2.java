package warehouse;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.MemberDao;
import domain.Member;
import util.ConnectionProvider;

public class MemberRegService2 {
	
	private MemberRegService2() {}
	private static MemberRegService2 service = new MemberRegService2();
	public static MemberRegService2 getInstance() {
		return service;
	}

	public void regMember(HttpServletRequest request) throws FileUploadException {

		Member member = new Member();

		Connection conn = null;
		MemberDao dao = null;

		File newFile = null;

		int resultCnt = 0;

		try {
			// 1. multipart/form-data
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				// 2. 파일을 저장할 factory 생성
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 3. form input들 분리
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 4. 사용자 요청 파싱 : 분리 후 저장
				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = itr.next();

					if (item.isFormField()) {
						// formfield일 경우
						String paramName = item.getFieldName();

						if (paramName.equals("memberid")) {
							member.setMemberid(item.getString("utf-8"));
						} else if (paramName.equals("password")) {
							member.setPassword(item.getString("utf-8"));
						} else if (paramName.equals("membername")) {
							member.setMembername(item.getString("utf-8"));
						}
					} else {
						// file일 경우
						String uploadUri = "/upload";
						String dir = request.getSession().getServletContext().getRealPath(uploadUri);

						File saveDir = new File(dir);

						// 디렉토리가 없다면 생성
						if (!saveDir.exists()) {
							saveDir.mkdir();
						}

						String paramName = item.getFieldName();
						if (paramName.equals("photo")) {

							// 파일 유효성
							if (item.getName() != null && item.getSize() > 0) {
								newFile = new File(saveDir, item.getName());

								item.write(newFile);
								member.setMemberphoto(item.getName());
								System.out.println("파일을 저장했습니다.");
							}
						}
					}
				}
			} else {
				throw new Exception("multipart타입이 아닙니다.");
			}

			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();

			resultCnt = dao.insertMember(conn, member);
		} catch (SQLException e) {
			e.printStackTrace();
			// 예외 발생시 파일 삭제
			if (newFile != null && newFile.exists()) {
				newFile.delete();
				System.out.println("파일을 삭제했습니다.");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("result", resultCnt);
	}
}
