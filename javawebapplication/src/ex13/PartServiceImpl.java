package ex13;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class PartServiceImpl implements PartService {
	private static PartService partService;

	private PartServiceImpl() {
	}

	public static PartService sharedInstance() {
		if (partService == null)
			partService = new PartServiceImpl();
		return partService;
	}

	@Override
	public Map<String, Object> fileUpload(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			request.setCharacterEncoding("UTF-8");
			String writer = request.getParameter("writer");
			Part part = request.getPart("partfile");
			String contentDisposition = part.getHeader("content-disposition");
			System.out.println(contentDisposition);
			String[] contentSplitStr = contentDisposition.split(";");
			int firstQutosIndex = contentSplitStr[2].indexOf("\"");
			int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
			String uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
			String [] imsi = uploadFileName.split("\\.");
			String ext = imsi[imsi.length-1];
			String saveFileName = "";
			while(true) {
				saveFileName = UUID.randomUUID().toString() + "." + ext;
				File f = new File("d:\\download\\" + saveFileName);
				if(!f.exists()) {
					part.write(saveFileName);
					break;
				}
			}
			map.put("writer", writer);
			map.put("filename", saveFileName);
		} catch (Exception e) {
			System.out.println("파일 업로드 실패:" + e.getMessage());
		}
		return map;
	}
}

