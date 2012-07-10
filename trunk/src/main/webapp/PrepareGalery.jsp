<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

	<!--
		Supersized - Fullscreen Slideshow jQuery Plugin
		Version 3.1.3
		www.buildinternet.com/project/supersized
		
		By Sam Dunn / One Mighty Roar (www.onemightyroar.com)
		Released under MIT License / GPL License
	-->

	<head>

		<title>Supersized - Full Screen Background/Slideshow jQuery Plugin</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=8" />
		
		<link rel="stylesheet" href="css/supersized.css" type="text/css" media="screen" />
		
		<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" src="js/supersized.3.1.3.min.js"></script>
		
		<script type="text/javascript">  
			
			jQuery(function($){
				$.supersized({
				
					//Functionality
					slideshow               :   1,		//Slideshow on/off
					autoplay				:	1,		//Slideshow starts playing automatically
					start_slide             :   1,		//Start slide (0 is random)
					random					: 	0,		//Randomize slide order (Ignores start slide)
					slide_interval          :   3000,	//Length between transitions
					transition              :   3, 		//0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
					transition_speed		:	700,	//Speed of transition
					new_window				:	1,		//Image links open in new window/tab
					pause_hover             :   0,		//Pause slideshow on hover
					keyboard_nav            :   1,		//Keyboard navigation on/off
					performance				:	1,		//0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)
					image_protect			:	1,		//Disables image dragging and right click with Javascript
					image_path				:	'img/', //Default image path

					//Size & Position
					min_width		        :   0,		//Min width allowed (in pixels)
					min_height		        :   0,		//Min height allowed (in pixels)
					vertical_center         :   1,		//Vertically center background
					horizontal_center       :   1,		//Horizontally center background
					fit_portrait         	:   1,		//Portrait images will not exceed browser height
					fit_landscape			:   0,		//Landscape images will not exceed browser width
					
					//Components
					navigation              :   1,		//Slideshow controls on/off
					thumbnail_navigation    :   1,		//Thumbnail navigation
					slide_counter           :   1,		//Display slide numbers
					slide_captions          :   1,		//Slide caption (Pull from "title" in slides array)
					slides 					:  	[		//Slideshow Images
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-34-383.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-42-991.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-43-738.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-44-673.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-45-355.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-46-834.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-47-488.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-48-230.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-48-867.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-49-542.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-50-178.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-50-912.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-51-566.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-52-329.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-52-979.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-53-921.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-54-659.png'},
													{image : 'screenshots/testSomethingSimple/10.07.2012 23-42-34/10.07.2012 23-42-55-411.png'},
 
												]
												
				}); 
		    });
		    
		</script>
		
		<style type="text/css">
		
			/*Demo Styles*/
			p{ padding:0 30px 30px 30px; color:#fff; font:11pt "Helvetica Neue", "Helvetica", Arial, sans-serif; text-shadow: #000 0px 1px 0px; line-height:200%; }
				p a{ font-size:10pt; text-decoration:none; outline: none; color:#ddd; background:#222; border-top:1px solid #333; padding:5px 8px; -moz-border-radius:3px; -webkit-border-radius:3px; border-radius:3px; -moz-box-shadow: 0px 1px 1px #000; -webkit-box-shadow: 0px 1px 1px #000; box-shadow: 0px 1px 1px #000; }
					p a:hover{ background-color:#427cb4; border-color:#5c94cb; color:#fff; }
			h3{ padding:30px 30px 20px 30px; }
			
			/*#content{ position:absolute; top:50px; left:50px; background:#fff; background:rgba(0,0,0,0.65); width:360px; text-align:left; }*/
			.stamp{ float: right; margin: 15px 30px 0 0;}
			
		</style>
		
	</head>

<body>		


	<!--Thumbnail Navigation-->
	<div id="prevthumb"></div> <div id="nextthumb"></div>
	
	<!--Control Bar-->
	<div id="controls-wrapper">
		<div id="controls">
		
			<!--Slide counter-->
			<div id="slidecounter">
				<span class="slidenumber"></span>/<span class="totalslides"></span>
			</div>
			
			<!--Slide captions displayed here-->
			<div id="slidecaption"></div>
			
			<!--Navigation-->
			<div id="navigation">
				<img id="prevslide" src="img/back_dull.png"/><img id="pauseplay" src="img/pause_dull.png"/><img id="nextslide" src="img/forward_dull.png"/>
			</div>
			
			<!--Logo in bar-->
			<!--a href="http://www.buildinternet.com/project/supersized" class="stamp"><img src="img/supersized-logo.png"/></a-->
			
		</div>
	</div>

</body>
</html>
