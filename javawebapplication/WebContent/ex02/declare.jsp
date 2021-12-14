<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
    public void quickSort(int left, int right, int[] data) {
		for(int i:data){
			System.out.print(i + "\t");
		}
		System.out.println();
		//가장 왼쪽의 데이터를 pivot으로 설정
		int pivot = left;
		
		//피봇의 위치를 j에 대입 - 피봇 데이터가 이동할 위치를 저장할 변수
		int j = pivot;
		
		// 피봇과 비교할 데이터들의 위치를 저장할 변수
		int i = left + 1;

		//마지막 위치가 시작 위치보다 클 때만 수행 - 데이터가 1개이면 중지 
		if (left < right) {
			//비교할 데이터를 마지막 위치까지 옮기면서 수행
			for (; i <= right; i=i+1) {
				//피봇 위치의 데이터가 비교할 데이터보다 크다면
				if (data[i] < data[pivot]) {
					//j의 값을 1증가시켜서 피봇 데이터가 마지막에 배치될 위치를 수정
					j = j + 1;
					//i번째 데이터와 j번째 위치의 데이터를 교환 - 피봇 데이터보다 큰 데이터를 다음 칸으로 옮김
					int temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}

			//피봇 데이터를 자신의 위치로 이동
			int temp = data[left];
			data[left] = data[j];
			data[j] = temp;

			//피봇을 수정
			pivot = j;

			//피봇의 왼쪽 부분과 오른쪽 부분을 다시 수행
			quickSort(left, pivot - 1, data);
			quickSort(pivot + 1, right, data);
		}

	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메소드 선언</title>
<style>
	span{
		border:1px solid black;
	}
</style>
</head>
<body>
	<%
		int[] list = { 69, 10, 30, 2, 14, 8, 31, 22, 16 };
	%>
	<h1>정렬하기 전 데이터</h1>
	<%for(int temp : list){ %>
		<span><%=temp %></span>
	<% } %>

	<%
		quickSort(0, list.length-1, list);
	%>
	
	<h1>정렬 후의  데이터</h1>
	<%for(int temp : list){ %>
		<span><%=temp %></span>
	<% } %>
</body>
</html>