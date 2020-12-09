package ex12;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class ItemServiceImpl implements ItemService {
	private ItemDao itemDao;
	private static ItemService itemService;

	private ItemServiceImpl() {
		itemDao = ItemDao.getInstance();
	}

	public static ItemService getInstance() {
		if (itemService == null)
			itemService = new ItemServiceImpl();
		return itemService;
	}

	@Override
	public boolean connect() {
		boolean r = itemDao.connect();
		itemDao.close();
		return r;
	}

	@Override
	public List<Item> itemList() {
		return itemDao.itemList();
	}

	@Override
	public Item itemDetail(HttpServletRequest request) {
		//String code = request.getParameter("code");
		String [] ar = request.getRequestURI().split("/");
		String code = ar[ar.length-1];
		return itemDao.itemDetail(Integer.parseInt(code));
	}


	@Override
	public int itemInsert(HttpServletRequest request) {
		// 파라미터 인코딩 설정
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 파라미터 읽기
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("description");

		// 가장 큰 code를 가져오기
		int code = itemDao.maxCode();
		// 데이터 삽입을 위한 인스턴스 만들기
		Item item = new Item();
		// code는 가장 큰 코드 번호 +1
		item.setCode(code + 1);
		item.setTitle(title);
		item.setCategory(category);
		item.setDescription(description);

		// 데이터 삽입
		return itemDao.itemInsert(item);
	}

	@Override
	public int itemUpdate(HttpServletRequest request) {
		// 파라미터 인코딩 설정
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// 파라미터 읽기
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("description");

		// 데이터 수정을 위한 인스턴스 만들기
		Item item = new Item();
		item.setCode(Integer.parseInt(code));
		item.setTitle(title);
		item.setCategory(category);
		item.setDescription(description);

		// 데이터 수정
		return itemDao.itemUpdate(item);
	}

	@Override
	public int itemDelete(HttpServletRequest request) {
		// String code = request.getParameter("code");

		String[] ar = request.getRequestURI().split("/");
		String code = ar[ar.length - 1];

		// 데이터 수정
		return itemDao.itemDelete(Integer.parseInt(code));
	}

	/*
	@Override
	public void itemList(HttpServletRequest request) {
		String no = request.getParameter("pageno");
		String cnt = request.getParameter("perpagecnt");
		System.out.println(no);
		int pageno = 1;
		if(no != null) {
			pageno = Integer.parseInt(no);
		}
		int perpagecnt = 5;
		if(cnt != null) {
			perpagecnt = Integer.parseInt(cnt);
		}
		//1-10까지는 1
		//11-20까지는 11
		int totalcnt = itemDao.getCount();
		//시작 페이지 번호와 종료 페이지 번호 만들기
		int endpage = (int) (Math.ceil(pageno/10.0) * 10.0);
		int startpage = endpage - 9;
		int tempendpage = (int)(Math.ceil(totalcnt/(double)perpagecnt));
		if (endpage > tempendpage) {
			endpage = tempendpage;
		}

		//이전과 다음 여부 만들기
		boolean prev = startpage == 1 ? false : true;
		boolean next = endpage * perpagecnt >= totalcnt ? false : true;

		//데이터 저장
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("pageno", pageno);

		request.setAttribute("result", itemDao.itemList(pageno, perpagecnt));
	}
	 */

	/*
	@Override
	public void itemList(HttpServletRequest request) {
		String no = request.getParameter("pageno");
		String cnt = request.getParameter("perpagecnt");
		System.out.println(no);
		int pageno = 1;
		if(no != null) {
			pageno = Integer.parseInt(no);
		}
		int perpagecnt = 5;
		if(cnt != null) {
			perpagecnt = Integer.parseInt(cnt);
		}

		int totalcnt = itemDao.getCount();
		//종료 페이지 번호 만들기
		int endPage = (int)(Math.ceil(pageno/10.0)*10.0);
		//전체 페이지 개수 구하기
		int tempEndPage = 
				(int)(Math.ceil(totalcnt/(double)perpagecnt));

		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		List<Item> list = itemDao.itemList(pageno, perpagecnt);

		JSONArray ar = new JSONArray();
		for(Item item : list) {
			JSONObject obj = new JSONObject();
			obj.put("code", item.getCode());
			obj.put("category", item.getCategory());
			obj.put("title", item.getTitle());
			ar.put(obj);
		}
		JSONObject result = new JSONObject();
		result.put("endpage", endPage);
		result.put("pageno", pageno);
		result.put("ar", ar);
		request.setAttribute("result", result);
	}*/
	
	@Override
	public void itemList(HttpServletRequest request) {
		String no = request.getParameter("pageno");
		String cnt = request.getParameter("perpagecnt");
		String keyword = request.getParameter("keyword");
		String search = request.getParameter("search");
		
		int pageno = 1;
		if(no != null) {
			pageno = Integer.parseInt(no);
		}
		int perpagecnt = 5;
		if(cnt != null) {
			perpagecnt = Integer.parseInt(cnt);
		}
		//1-10까지는 1
				//11-20까지는 11
				Map<String, Object> map = new HashMap<>();
				map.put("keyword", keyword);
				if(search != null) {
					map.put("search", search.toUpperCase());
				}
				map.put("pageno", pageno);
				map.put("perpagecnt", perpagecnt);
				
				int totalcnt = itemDao.getCount(map);
				//시작 페이지 번호와 종료 페이지 번호 만들기
				int endpage = (int) (Math.ceil(pageno/10.0) * 10.0);
				int tempendpage = (int)(Math.ceil(totalcnt/(double)perpagecnt));

				if (endpage > tempendpage) {
					endpage = tempendpage;
				}
				//데이터 저장
				request.setAttribute("endpage", endpage);
				request.setAttribute("pageno", pageno);
				
				List<Item> list = itemDao.itemList(map);
				
				JSONArray ar = new JSONArray();
				for(Item item : list) {
					JSONObject obj = new JSONObject();
					obj.put("code", item.getCode());
					obj.put("category", item.getCategory());
					obj.put("title", item.getTitle());
					ar.put(obj);
				}
				JSONObject result = new JSONObject();
				result.put("endpage", endpage);
				result.put("pageno", pageno);
				result.put("ar", ar);
				result.put("keyword", keyword);
				result.put("search", search);
				request.setAttribute("result", result);
			}


}