<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="/dashboard">Dashboard</a>
<br>
<table>
	<tr>
		<td>Title:</td>
		<td><a href="/songs/${song.id}"><c:out value="${song.title}" /></a></td>
	</tr>
	<tr>
		<td>Artist:</td>
		<td><c:out value="${song.artist}" /></td>
	</tr>
	<tr>
		<td>Rating:</td>
		<td><c:out value="${song.rating}" /></td>
	</tr>
	<tr>
		<td><a href="/songs/delete/${song.id}">Delete</a></td>
	</tr>
</table>