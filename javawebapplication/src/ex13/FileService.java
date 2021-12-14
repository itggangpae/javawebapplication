package ex13;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface FileService {
	public Map<String, Object> fileUpload(HttpServletRequest request);
	public void uploadFile(HttpServletRequest request);
	public List<Pds> getList(HttpServletRequest request);
	public void download(HttpServletRequest request, HttpServletResponse response);
}

