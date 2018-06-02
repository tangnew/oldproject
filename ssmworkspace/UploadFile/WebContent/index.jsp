<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>发布说说</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="./css/bootstrap.css" rel="stylesheet">
<link href="./css/bootstrap-theme.css" rel="stylesheet">
<style>
body {
	margin: auto auto;
	padding: auto auto;
}

.own-container {
	width: 300px;
	height: 400px;
	border: 1px solid gray;
	margin: auto auto;
	margin-top: 30px;
}

.own-container .top {
	width: 260px;
	border: 1px solid gray;
	margin-top: 10px;
}

.middle .content {
	width: 260px;
	border: 1px solid green;
	margin-top: 10px;
	height: 100px;
}

.middle .uppic {
	margin-top: 10px;
	width: 280px;
	height: 55px;
	border: 0px solid gold;
	overflow: hidden;
}

.middle .pic {
	margin-top: -30px;
	width: 260px;
	height: 120px;
	border: 0px solid gold;
}

.middle img {
	margin-top: 5px;
	width: 200px;
	height: 110px;
	border: 1px solid gold;
}
</style>
</head>
<body>
	<div class="own-container">
		<div class="container">
			<header class="top">
				<h5>
					<strong>发表说说</strong>
				</h5>
			</header>
			<section class="middle">
				<section class="content">内容</section>
				<section style="margin-top: -10px">
					<iframe src="up.jsp" class="uppic"></iframe>
					<div class="pic">
						图片 <img id="myImg" />
					</div>
				</section>
			</section>
		</div>
	</div>
</body>
<script type="text/javascript" src="./js/jquery-2.1.4.js"></script>
</html>
