<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/r/bs-3.3.5/jqc-1.11.3,dt-1.10.8/datatables.min.js"></script>
   <link rel="stylesheet" href="Dashboard.css">
</head>
<body>
<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#example').DataTable();
			} );
		</script>
<jsp:include page="header.jsp" />    
<div class="container">
	<div class="dashBoardCont">
			<div class="row">
				<div class="col-sm-12 lblTeam">
					<div class="col-sm-1 sltTeam">
						<label>Select Team :</label>
					</div>
					<div class="col-sm-2 dropdown">
						<select  class="btn btn-default dropdown-toggle" name="team">
							<option value="Team">All</option>
							<option value="Team">Amit's Team</option>
							<option value="Team">Preeti's Team</option>
						</select><br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 pad">
					<div class="panel panel-primary">
					    <div class="panel-heading">
					        <h3 class="panel-title">MOM</h3>
					    </div>
					    <div class="panel-body">
					    	<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
						        <thead>
						            <tr>
						                <th>Sno.</th>
						                <th>MOM Description</th>
						                <th>Project</th>
						                <th>Date</th>
						                <th>Status</th>
						                <th>Download</th>
						                <th>Email</th>
						            </tr>
						        </thead>
						        <tbody>
						            <tr><td>1</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download-alt"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>2</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download-alt"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>3</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download-alt"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>4</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>5</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>6</td><td>MOM</td><td>Frys</td><td>01/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>7</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>8</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>9</td><td>MOM</td><td>Frys</td><td>20/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>10</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>11</td><td>MOM</td><td>Frys</td><td>19/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            
						            <tr><td>12</td><td>MOM</td><td>Frys</td><td>20/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>13</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>14</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>15</td><td>MOM</td><td>Frys</td><td>09/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>16</td><td>MOM</td><td>Frys</td><td>09/10/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>17</td><td>Ankita</td><td>Frys</td><td>09/09/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>18</td><td>MOM</td><td>Frys</td><td>09/08/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            <tr><td>19</td><td>MOM</td><td>Frys</td><td>10/07/2016</td><td>Email Not sent</td>
						                <td><a><span class="glyphicon glyphicon-download"></span></a></td><td><span class="glyphicon glyphicon-envelope"></span></td>
						            </tr>
						            
						        </tbody>
					    </table>
					    </div>
					</div>
			</div>
		</div>
	</div><!-- dashBoardCont Ends. -->
</div><!-- Container Ends. -->

</body>
</html>

