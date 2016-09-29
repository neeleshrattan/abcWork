<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.trantor.Service.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Minutes of Meeting</title>

<style type="text/css">

	table.fstdataTable {
	    counter-reset: rowNumber;
	}
	
	table.fstdataTable tr {
	    counter-increment: rowNumber;
	}
	
	table.fstdataTable tr td:first-child::before {
	    content: counter(rowNumber);
	    min-width: 1em;
	    margin-right: 0.5em;
	}

</style>
</head>
<body>
	<!--CONTAINER DIV  -->
<%

		LoginBean currentUser = ((LoginBean) (session.getAttribute("user")));
	%>
	<div class="container">
	<!--TOP DIV  -->
		<div class="row">
			<div id="top" style="float: top;">

				<div style="float: left; width: 20%;">
					<img alt="Trantor"
						src="http://www.maimt.com/uploads/company/12/trantor%20logo.png"
						height="130" width="180">
				</div>
			
				<div style="float: right; width: 80%;">

					<center>
						<h1 style="color: steelblue;">
							<b>Minutes of Meeting</b>
						</h1>
					</center>
				</div>
				
				<div style="clear: right"></div>
			
			</div>
		</div>
		
		<div style="clear: top"></div>
		
		<br>

		<!--END TOP -->

		<!-- MAIN DIV  -->
		<div id="main">
			<div class="row">
				<div id="mainTop" style="float: top;">
					<div id="mainTopLeft" style="float: left; width: 70%;">
						<table border="1" style="border-collapse: collapse;">
							<tr>
								<td><b>&nbsp;Doc ID: </b></td>
								<td>&nbsp;Trantor/MOM/Ver 1.1</td>
	
							</tr>
							<tr>
								<td><b>&nbsp;Participants:&nbsp;</b></td>
								<td>&nbsp;Offsite team and Onsite team</td>
							</tr>
							<tr>
								<td><b>&nbsp;Purpose:&nbsp;</b></td>
								<td>&nbsp;<%=currentUser.getTeam_name().toUpperCase()%>- To address the blockers, issues
									and release plan &nbsp;</td>
							</tr>
							<tr>
								<td><b>&nbsp;Venue:&nbsp;</b></td>
								<td>&nbsp;Teleconf</td>
							</tr>
							<tr>
								<td><b>&nbsp;Prepared By:&nbsp;</b></td>
								<td>&nbsp;<%=currentUser.getName().toUpperCase()%></td>
							</tr>
							<tr>
								<td><b>&nbsp;To :</b></td>
								<td>&nbsp;<%=currentUser.getClient_name().toUpperCase()%></td>
							</tr>
							<tr>
								<td><b>&nbsp;Attendance:&nbsp;</b></td>
								<td>&nbsp;WebTeam1 and WebTeam2</td>
							</tr>
							<tr>
								<td><b>&nbsp;Absence:&nbsp;</b></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><b>&nbsp;Date Released :&nbsp;</b></td>
								<td>&nbsp; <% out.println(new Date().toLocaleString());%>&nbsp;
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div><!-- row end -->
			<div style="float: bottom">
			<!--mainLeftBottom  -->
						<div id="demo" style="float: left;">
							<h3>
								<b>S.No.</b>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp; <b>Points Discussed</b>
							</h3>
						</div>
						<div style="clear: demo"></div>
						<div id="mainLeftBottom" style="float: left; width: 70%;">
							<form action="formServlet">
								<div id="point_discussed_div">
									<table border="1" style="border-collapse: collapse;" class="table table-bordered table-hover fstdataTable">
										<input type="hidden" id="discussion_rows_count" value="1"/>
										<tr class="tr_clone hide">
											<td><b></b></td>
											<td>
													<textarea size="65" class='form-control input-md'  name="desc" rows="3" cols="105" style="height: 80px"></textarea>
											</td>
											<td>
												<%=currentUser.getTeam_name().toUpperCase()%>
											</td>
										</tr>
										<tr>
											<td><b></b></td>
											<td>
												<textarea size="65" class='form-control input-md'  name="desc" rows="3" cols="105" style="height: 80px"></textarea>
											</td>
											<td>
												<%=currentUser.getTeam_name().toUpperCase()%>
											</td>
										</tr>
									</table>
									<a class="btn btn-primary add_row">Add Row</a>
									<a class="btn btn-danger delete_row" style="float: right;">Remove</a>
									<br/>
								</div>
								
								<center>
									<h1>Action Items</h1>
								</center>
								
								<div id="action_items_div">
									<table class="table table-bordered seconddataTable">
									<input type="hidden" id="action_rows_count" value="1"/>
										<thead>
											<tr>
												<th><h3>S.No.</h3></th>
												<th><center><h3>Item</h3></center></th>
												<th><h3>By Whom : Responsibility</h3></th>
												<th><h3>By When - DD/MM/YYYY</h3></th>
											</tr>
										</thead>
										<tbody>
											<tr class="tr_clone1 hide">
												<td><b></b></td>
												<td><textarea name="item"  rows="3" cols="25"></textarea></td>
												<td><textarea  name="bywhom" rows="3" cols="25"></textarea></td>
												<td><input type="date" name="date" /></td>
											</tr>
											
											<tr>
												<td><b>1</b></td>
												<td><textarea name="item" rows="3" cols="25"></textarea></td>
												<td><textarea name="bywhom" rows="3" cols="25"></textarea></td>
												<td><input type="date" name="date"/></td>
											</tr>
										</tbody>
									</table>
									<a class="btn btn-primary add_row1">Add Row</a>
									<a class="btn btn-danger delete_row1" style="float: right;">Remove</a>
									<br/>
								</div>
								<br><br><br>
								&emsp; <input type="submit" value="Submit" class="btn btn-primary center-block">		</form>
							<!--end mainLeft BOTTOM -->
						</div>
						<div style="clear: mainLefttBottom"></div>
						<div style="width: 5%"></div>

					<div id="mainRightBottom" style="float: right; width: 25%">
						<h4><b>MOM RECORDS</b></h4>
						<br> 
						<a href="#" style="color: blue; font-size: 14px;"><b>MOM: 24-07-2016</b></a> 
						<br> <br> 
						<a href="#" style="color: blue; font-size: 14px;"><b>MOM: 01-08-2016</b></a>
						<br> <br> 
						<a href="#" style="color: blue; font-size: 14px;"><b>MOM: 04-08-2016</b></a>
					</div>
					<div style="clear: mainRightBottom"></div>
				</div>
			<!--end mainRight  -->
			</div>
		</div>
	<!--end main  -->
	</div>
	<!--end container  -->
</div>
<script>	
	$(document).ready(function() {
		var i = 1;
		var j=1;
		$('#point_discussed_div').on('click', '.add_row', function(){
			var parent_div  = $(this).closest('#point_discussed_div');
	    	var $tr  = parent_div.find('.tr_clone');
	    	var $clone = $tr.clone();
	    	$clone.removeClass("tr_clone hide");
	    	$clone.find('textarea').val('');
	    	$clone.find('select').removeAttr("selected");
	    	$tr.parents("table").append($clone);
	    	
	    	//update total row count
	    	var discussion_rows_count = $("#discussion_rows_count").val();
	    	discussion_rows_count++;
	    	$("#discussion_rows_count").val(discussion_rows_count);
		});
		
		$('#point_discussed_div').on('click', '.delete_row', function(){
			var $tr = $('.fstdataTable tr:not(.tr_clone):last');
	    	
	    	var discussion_rows_count = $("#discussion_rows_count").val();
	    	if(discussion_rows_count > 1){
	    		$tr.remove();
		    	i--;
		    	var discussion_rows_count = $("#discussion_rows_count").val();
		    	discussion_rows_count--;
		    	$("#discussion_rows_count").val(discussion_rows_count);
		    }
	    });
		
		$('#action_items_div').on('click', '.add_row1', function(){
			var parent_div  = $(this).closest('#action_items_div');
	    	var $tr  = parent_div.find('.tr_clone1');
	    	var $clone = $tr.clone();
	    	$clone.removeClass("tr_clone1 hide");
	    	$clone.find('textarea').val('');
	    	$clone.find('select').removeAttr("selected");
	    	j=j+1;
	    	$clone.find('td:first').html(j);
	    	$tr.parents("table").append($clone);
	    	//update total row count
	    	var action_rows_count = $("#action_rows_count").val();
	    	action_rows_count++;
	    	$("#action_rows_count").val(action_rows_count);
		});
		
		$('#action_items_div').on('click', '.delete_row1', function(){
			var $tr = $('.seconddataTable tr:not(.tr_clone1):last');
			var action_rows_count = $("#action_rows_count").val();
	    	if(action_rows_count > 1){
	    		$tr.remove();
		    	j--;
		    	var action_rows_count = $("#action_rows_count").val();
		    	action_rows_count--;
		    	$("#action_rows_count").val(action_rows_count);
		    }
	    });
		
		
	});
</script>
<jsp:include page="footer.html"></jsp:include>
</body>
</html>