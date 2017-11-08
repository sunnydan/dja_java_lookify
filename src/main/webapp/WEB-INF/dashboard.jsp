<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav>
	<a href="/songs/new">Add New</a> <a href="/topsongs">Top Songs</a>
	<form action="/search" method="POST">
		<input type="search" name="artist"> <input type="submit"
			value="Search Artists">
	</form>
</nav>
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