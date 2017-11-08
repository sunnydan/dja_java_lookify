<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
	<a href="/dashboard">Dashboard</a>
</nav>
<h3>Top Ten Songs:</h3>
<table>
	<tr>
		<th>Title</th>
		<th>Artist</th>
		<th>Rating</th>
	</tr>
	<c:forEach items="${songs}" var="song" varStatus="loop">
		<tr>
			<td><a href="/songs/${song.id}"><c:out value="${song.title}" /></a></td>
			<td><c:out value="${song.artist}" /></td>
			<td><c:out value="${song.rating}" /></td>
			<td><a href="/songs/delete/${song.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>