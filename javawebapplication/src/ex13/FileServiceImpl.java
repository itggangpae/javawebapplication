package ex13;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileServiceImpl implements FileService {

	private static FileServiceImpl fileService;

	private PdsDao pdsDao;

	private FileServiceImpl() {
		pdsDao = PdsDao.sharedInstance();
	}


	public static FileService sharedInstance() {
		if (fileService == null)
			fileService = new FileServiceImpl();
		return fileService;
	}
	@Override
	public Map<String, Object> fileUpload(HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/upload");
		System.out.println(uploadPath);
		int size = 10 * 1024 * 1024;
		String name = "";
		String subject = "";
		String filename = "";
		String originfilename = "";
		Map<String, Object> map = null;
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8",new DefaultFileRenamePolicy());
			name = multi.getParameter("name");
			subject = multi.getParameter("subject");
			@SuppressWarnings("unchecked")
			Enumeration<String> files = multi.getFileNames();
			String file = files.nextElement();
			filename = multi.getFilesystemName(file);
			originfilename = multi.getOriginalFileName(file);
			map = new HashMap<String, Object>();
			map.put("name", name);
			map.put("subject", subject);
			map.put("filename", filename);
			map.put("originfilename", originfilename);
		} catch (Exception e) {
			System.out.println("파일 업로드 처리 실패:" + e.getMessage());
		}
		return map;
	}

	@Override
	public void uploadFile(HttpServletRequest request) {
		String uploadPath = request.getServletContext().getRealPath("/pdsupload");
		int size = 10 * 1024 * 1024;
		String filename = "";
		String description = "";

		try {
			MultipartRequest multi = new MultipartRequest(
					request, uploadPath, size, "utf-8",
					new DefaultFileRenamePolicy());

			Enumeration<String> files = multi.getFileNames();
			String file = files.nextElement();
			filename = multi.getFilesystemName(file);
			description = multi.getParameter("description");
			int id = pdsDao.maxId();

			Pds pds = new Pds();
			pds.setId(id+1);
			pds.setDescription(description);
			pds.setFileName(filename);
			File upladFile = new File(uploadPath + "/" + filename);
			pds.setFileSize(upladFile.length());
			pdsDao.insertItem(pds);
		}

		catch (Exception e) {
			System.out.println("파일 업로드 실패:" + e.getMessage());
		}
	}

	@Override
	public List<Pds> getList(HttpServletRequest request) {
		return pdsDao.getItem();
	}

	@Override
	public void download(HttpServletRequest request, HttpServletResponse response) {
		FileInputStream in = null;
		ServletOutputStream out = null;
		System.out.println("dddd");
		try {
			String fileName = request.getParameter("filename");
			String sDownloadPath = request.getServletContext().getRealPath("/pdsupload");
			//windows에서는 /를 \\로 변경
			String sFilePath = sDownloadPath + "/" + fileName;
			byte b[] = new byte[4096];
			in = new FileInputStream(sFilePath);
			String sMimeType = request.getServletContext().getMimeType(sFilePath);
			// octet-stream 은 8비트로 된 일련의 데이타를 뜻합니다. 지정되지 않은 파일 형식을 의미합니다.
			if (sMimeType == null)
				sMimeType = "application/octet-stream";
			response.setContentType(sMimeType);
			String sEncoding = URLEncoder.encode(fileName, "UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
			out = response.getOutputStream();
			int numRead;

			while ((numRead = in.read(b, 0, b.length)) != -1) {
				out.write(b, 0, numRead);
			}
			out.flush();
		} catch (Exception e) {
			System.out.println("다운로드 실패:" + e.getMessage());
		}
		finally {
			try {
				out.close();
				in.close();
			} catch (Exception e) {
			}
		}

	}
}