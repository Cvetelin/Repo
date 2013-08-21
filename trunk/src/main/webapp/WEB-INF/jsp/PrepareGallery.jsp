<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<!--
		Supersized - Fullscreen Slideshow jQuery Plugin
		Version : 3.2.7
		Site	: www.buildinternet.com/project/supersized
		
		Author	: Sam Dunn
		Company : One Mighty Roar (www.onemightyroar.com)
		License : MIT License / GPL License
	-->

	<head>

		<title>Supersized - Full Screen Background Slideshow jQuery Plugin</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		
		<link rel="stylesheet" href="/css/supersized.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="/theme/supersized.shutter.css" type="text/css" media="screen" />
		
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
		<script type="text/javascript" src="/js/jquery.easing.min.js"></script>
		
		<script type="text/javascript" src="/js/supersized.3.2.7.min.js"></script>
		<script type="text/javascript" src="/theme/supersized.shutter.min.js"></script>
		
		<script type="text/javascript">
			
			jQuery(function($){
				
				$.supersized({
				
					// Functionality
					slide_interval          :   3000,		// Length between transitions
					transition              :   1, 			// 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
					transition_speed		:	700,		// Speed of transition
															   
					// Components							
					slide_links				:	'blank',	// Individual links for each slide (Options: false, 'num', 'name', 'blank')
					slides 					:  	[			// Slideshow Images
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-34-383.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-42-991.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-43-738.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-44-673.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-45-355.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-46-834.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-47-488.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-48-230.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-48-867.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-49-542.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-50-178.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-50-912.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-51-566.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-52-329.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-52-979.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-53-921.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-54-659.png'},
													{image : 'http://localhost:8080/screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-55-411.png'},

												]
					
				});
		    });
		    
		</script>
		
	</head>
	
	<style type="text/css">
		ul#demo-block{ margin:0 15px 15px 15px; }
			ul#demo-block li{ margin:0 0 10px 0; padding:10px; display:inline; float:left; clear:both; color:#aaa; background:url('img/bg-black.png'); font:11px Helvetica, Arial, sans-serif; }
			ul#demo-block li a{ color:#eee; font-weight:bold; }
	</style>

<body>

	<!--Thumbnail Navigation-->
	<div id="prevthumb"></div>
	<div id="nextthumb"></div>
	
	<!--Arrow Navigation-->
	<a id="prevslide" class="load-item"></a>
	<a id="nextslide" class="load-item"></a>
	
	<div id="thumb-tray" class="load-item">
		<div id="thumb-back"></div>
		<div id="thumb-forward"></div>
	</div>
	
	<!--Time Bar-->
	<div id="progress-back" class="load-item">
		<div id="progress-bar"></div>
	</div>
	
	<!--Control Bar-->
	<div id="controls-wrapper" class="load-item">
		<div id="controls">
			
			<a id="play-button"><img id="pauseplay" src="/img/pause.png"/></a>
		
			<!--Slide counter-->
			<div id="slidecounter">
				<span class="slidenumber"></span> / <span class="totalslides"></span>
			</div>
			
			<!--Slide captions displayed here-->
			<div id="slidecaption"></div>
			
			<!--Thumb Tray button-->
			<a id="tray-button"><img id="tray-arrow" src="/img/button-tray-up.png"/></a>
			
			<!--Navigation-->
			<ul id="slide-list"></ul>
		</div>
	</div>

</body>
</html>
