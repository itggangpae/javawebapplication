package ex12;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface ItemService {
	public boolean connect();
	public List<Item> itemList();
	public void itemList(HttpServletRequest request);

	public Item itemDetail(HttpServletRequest request);
	//데이터 삽입을 위한 메서드
	public int itemInsert(HttpServletRequest request);
	//데이터 수정을 위한 메서드
	public int itemUpdate(HttpServletRequest request);
	//데이터 삭제를 위한 메서드
	public int itemDelete(HttpServletRequest request);

}

