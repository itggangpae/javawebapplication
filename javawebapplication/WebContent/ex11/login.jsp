<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <title>로그인 화면</title>
    </head>
    <body>
        로그인을 하십시오.<br /><br />
        <form action="login" method=post>
        <table border=1>
        <tr><td align="right">아이디</td>
        <td align=left style="padding-left:20px;"> <input type=text name=id size=15></td></tr>
            <tr><td align="right">패스워드</td> 
            <td align=left style="padding-left:20px;"><input type=text name=password size=15> </td></tr>
            <tr><td colspan=2 align=center>
            <input type=submit value='로그인' style="width:100px;">&nbsp;
            <input type=reset value='취소' style="width:100px;">
        </table>
        </form>
    </body>
</html>