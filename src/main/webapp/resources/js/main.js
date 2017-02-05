$(document).ready(function(){
	
	$("#newsticker").jCarouselLite({
		vertical:true,
		hoverPause:true,
		btnPrev:"#news-img-down",
		btnNext:"#news-img-up",
		visible:3,
		auto:3000,
		speed:500
	});

	$("#block-track-bar").trackbar({
		onMove:function(){
			document.getElementById("start-price").value=this.leftValue;
			document.getElementById("end-price").value=this.rightValue;
		},
		width:160,
		leftLimit:0,
		leftValue:0,
		rightLimit:150000,
		rightValue:150000,
		roundUp:1000
	});

	$("#style-grid").click(function(){
		$("#block-tovar-list").hide();
		$("#block-tovar-grid").show();
		$("#style-grid").attr("src","/resources/images/sort-grid-active.png");
		$("#style-list").attr("src","/resources/images/sort-list.png");
	});

	$("#style-list").click(function(){
		$("#block-tovar-grid").hide();
		$("#block-tovar-list").show();
		$("#style-list").attr("src","/resources/images/sort-list-active.png");
		$("#style-grid").attr("src","/resources/images/sort-grid.png");
	});

	$("#select-sort").click(function(){
		$("#sorting-list").slideToggle(200);
	});

	$("#block-category > ul > li > a").click(function(){
		if($(this).attr('class')!='active'){
			$("#block-category > ul > li > ul").slideUp(400);
			$(this).next().slideToggle(400);
			$("#block-category > ul > li > a").removeClass('active');
			$(this).addClass('active');
		}else{
			$("#block-category > ul > li > a").removeClass('active');
			$("#block-category > ul > li > ul").slideUp(400);
		}
	});

});