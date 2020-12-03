<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록 보기</title>

</head>
<body>
	<h3 align="center">목록보기</h3>
	<table align="center" border="1" id="table">
		<tr>
			<th>코드</th>
			<th>카테고리</th>
			<th>프로그램</th>
		</tr>
	</table>
	
	<div align='center'>
		<select name="keyword" id="keyword">
			<option value="category">카테고리</option>
			<option value="title">내용</option>
			<option value="all">카테고리 또는 내용</option>
		</select>
		
		<input type="text" name="search" id="search" />
		<input type="button" value="검색" id="searchbtn" />
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<script>
	var pageno = 1
	
	function adddata(){
		var keyword = document.getElementById("keyword");
		var search = document.getElementById("search");
		
		
		$.ajax({
			url:"getlist",
			dataType:"json",
			data:{'pageno':pageno, 'keyword':keyword.value, 'search':search.value},
			success:function(data){
				//alert(data);
				$('#add').remove();
				$.each(data.ar, function(index, item){
					disp = "<tr><td align='right'>" + item.code + "&nbsp;</td>";
					disp += "<td>&nbsp;" + item.category + "</td>";
					disp += "<td>&nbsp;<a href='itemdetail/" + item.code + "'>" + item.title + "</td></tr>";
					$('table').html($('table').html() + disp);
				});
				
				if(data.pageno != data.endpage){
					disp = "<tr id='add'><td colspan='3' align='center'>" + "더보기" + "</td></tr>";
					$('table').html($('table').html() + disp);
					pageno = pageno + 1;
					document.getElementById("add").addEventListener("click", adddata);
				}
				keyword.value = data.keyword;
				search.value = data.search;
			}
		});
	};
	
	window.addEventListener("load", function(e){
		adddata();
	});
	
	document.getElementById("searchbtn").addEventListener("click", function(e){
		pageno = 1;
		$('table').html('');
		$('table').html('<tr><th>코드</th><th>카테고리</th><th>프로그램</th></tr>');
		adddata();
	});
	
</script>
</html>
