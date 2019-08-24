<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>

	<div class="carousel-inner">

		<div class="carousel-item active">
			<img
				src="${pageContext.request.contextPath}/myImage/image1CarousselDisplay?id=1"
				width="1300" height="150" />

			<div class="container">
				<div class="carousel-caption text-left">
					<h3>C'est l'été sur AKC-Shop !</h3>
				</div>
			</div>
		</div>


		<div class="carousel-item">
			<img
				src="${pageContext.request.contextPath}/myImage/image2CarousselDisplay?id=1" width="1300" height="150" />
			<div class="container">
				<div class="carousel-caption text-left">
					<h3></h3>
				</div>
			</div>
		</div>

		<div class="carousel-item">
			<img
				src="${pageContext.request.contextPath}/myImage/image3CarousselDisplay?id=1" width="1300" height="150" />
			<div class="container">
				<div class="carousel-caption text-left">
					<h3></h3>
				</div>
			</div>
		</div>
	</div>

	<a class="carousel-control-prev" href="#myCarousel" role="button"
		data-slide="prev"> <span class="carousel-control-prev-icon"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#myCarousel" role="button"
		data-slide="next"> <span class="carousel-control-next-icon"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>

</div>