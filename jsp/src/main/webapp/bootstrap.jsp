<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<!-- Content here -->
		<div class="row">
			<div class="col-2 border">
				<a class="btn btn-primary" href="#" role="button">Link</a>
				<button class="btn btn-outline-primary" type="submit">Button</button>
				<script>
					$(function(){
						$("#btnRegister").click(function() {
							$(".modal").modal("show");
						});
					})
				</script>
				<span id="btnRegister" class="btn btn-success">회원가입</span> <input
					class="btn btn-primary" type="submit" value="Submit"> <input
					class="btn btn-primary" type="reset" value="Reset">
			</div>

			<script>
				$(function() {
					$("#liveToastBtn").click(function() {
						$(".toast").toast("show");
					});
				})
			</script>
			<div class="col-8 border">
				<button type="button" class="btn btn-danger" id="liveToastBtn">Show
					live toast</button>
				<div class="position-fixed bottom-0 right-0 p-3"
					style="z-index: 5; right: 500; bottom: 500;">
					<!-- toast 위치 조절 -->
					<div id="liveToast" class="toast hide" role="alert"
						aria-live="assertive" aria-atomic="true" data-delay="5000">
						<!-- 5초 -->
						<div class="toast-header">
							<img src="..." class="rounded mr-2" alt="..."> <strong
								class="mr-auto">Bootstrap</strong> <small>11 mins ago</small>
							<button type="button" class="ml-2 mb-1 close"
								data-dismiss="toast" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="toast-body">Hello, world! This is a toast
							message.</div>
					</div>
				</div>

				<script>
					$(function() {
						$(".btn").tooltip();
					})
				</script>
				<button type="button" class="btn btn-secondary"
					data-toggle="tooltip" data-placement="left" title="툴팁 내용 적는 곳">
					Tooltip on top</button>


			</div>
			<div class="col-2 border">third</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-12 border">
				<!-- col-md-12 화면 작아질때 크기 조절 -->
				<table class="table table-bordered">
					<thead class="table-dark">
						<tr>
							<td>번호</td>
							<td>이름</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>a</td>
						</tr>
						<tr>
							<td>2</td>
							<td>b</td>
						</tr>
						<tr>
							<td>3</td>
							<td>c</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-lg-6 col-md-12 border">
				<form>
					<div class="form-group row">
						<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
						<div class="col-sm-10">
							<input type="text" readonly class="form-control-plaintext"
								id="staticEmail" value="email@example.com">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="inputPassword">
						</div>
					</div>
					<div class="form-check">
						취미&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="form-check-input" type="checkbox" value=""
							id="defaultCheck1"> <label class="form-check-label"
							for="defaultCheck1"> Default checkbox </label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							class="form-check-input" type="checkbox" value=""
							id="defaultCheck2" disabled> <label
							class="form-check-label" for="defaultCheck2"> Disabled
							checkbox </label>
					</div>
					<div class="form-group row justify-content-center"
						style="text-align: center;">
						<button class="btn btn-info">등록</button>
						<button class="btn btn-dark">취소</button>
					</div>
				</form>
			</div>
		</div>
		<div class="alert alert-primary" role="alert">
			A simple primary <a href="#" class="alert-link">an example link</a>
			alert—check it out!
		</div>
		<div class="alert alert-success" role="alert">
			<h4 class="alert-heading">Well done!</h4>
			<p>Aww yeah, you successfully read this important alert message.
				This example text is going to run a bit longer so that you can see
				how spacing within an alert works with this kind of content.</p>

			<hr>

			<p class="mb-0">Whenever you need to, be sure to use margin
				utilities to keep things nice and tidy.</p>
			<button type="button" class="btn btn-primary">
				Notifications <span class="badge badge-light">4</span>
			</button>
		</div>
		<div class="row">
			<div class="card" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			<div class="card mr-5" style="width: 18rem;"> <!-- m = margin / r = right / -5 = 띄울거리-->
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			<div class="card pt-5" style="width: 18rem;"> <!-- p = padding / t = top / -5 = 띄울거리-->
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="card" style="width: 18rem; background-color: gold;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
		</div>
		<!-- end of row -->
	</div>
	<!-- end of content -->

	<script>
		$(function() {
			$(".modal").modal();
		})
	</script>
	<div class="modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<form>
						<div class="form-group row">
							<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
							<div class="col-sm-10">
								<input type="text" readonly class="form-control-plaintext"
									id="staticEmail" value="email@example.com">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword">
							</div>
						</div>
						<div class="form-check">
							취미&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="form-check-input" type="checkbox" value=""
								id="defaultCheck1"> <label class="form-check-label"
								for="defaultCheck1"> Default checkbox </label>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
								class="form-check-input" type="checkbox" value=""
								id="defaultCheck2" disabled> <label
								class="form-check-label" for="defaultCheck2"> Disabled
								checkbox </label>
						</div>
						<div class="form-group row justify-content-center"
							style="text-align: center;">
							<button class="btn btn-info">등록</button>
							<button class="btn btn-dark">취소</button>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>