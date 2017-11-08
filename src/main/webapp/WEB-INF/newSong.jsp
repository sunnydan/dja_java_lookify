<a href="/dashboard">Dashboard</a>
<br>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="POST" action="/songs/new" modelAttribute="song">
    <form:label path="title">Title
    <form:errors path="title"/>
    <form:input path="title"/></form:label>
    
    <form:label path="artist">Artist
    <form:errors path="artist"/>
    <form:input path="artist"/></form:label>
    
    <form:label path="rating">Rating
    <form:errors path="rating"/>     
    <form:input type="number" path="rating"/></form:label>
    
    <input type="submit" value="Add Song"/>
</form:form>