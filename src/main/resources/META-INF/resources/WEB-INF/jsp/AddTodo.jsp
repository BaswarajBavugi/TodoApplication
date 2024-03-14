	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	
	  	<div class="container">
				<h2>Enter todo details</h2>
				<form:form method="post" modelAttribute="todo">
					<fieldset>
						<form:label path="description">Description:</form:label>
						<form:input type="text" id="description" path="description"/>
						<form:errors path="description" cssClass="text-warning"/>
					</fieldset>
					<fieldset>
						<form:label path="targetDate">Target Date:</form:label>
						<form:input type="text" id="targetDate" path="targetDate"/>
						<form:errors path="targetDate" cssClass="text-warning"/>
					</fieldset>
						<form:input type="hidden"  path="id"/>
						<form:input type="hidden"  path="done"/>
					 
					
					<div>
						 <button type="submit" class="btn btn-success">Submit</button>
					</div>
				</form:form>
			 
		</div>
		
		<%@ include file="common/footer.jspf" %>
		<script type="text/javascript">
			$('#targetDate').datepicker({
			    format: 'yyyy-mm-dd'
			});
		</script>
  