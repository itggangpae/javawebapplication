package ex13;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface PartService {
	public Map<String, Object> fileUpload(HttpServletRequest request);
}
