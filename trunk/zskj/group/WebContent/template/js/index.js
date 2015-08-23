
		function getclass(obj){
			var length=document.getElementById("search").getElementsByTagName("a").length;
			for(var i=0;i<length;i++){
				document.getElementById("search").getElementsByTagName("a")[i].className="";
			}
			obj.className="hover";
		}
	
		function setTab(m,n){
		 var tli=document.getElementById("menu"+m).getElementsByTagName("li");
		 var mli=document.getElementById("main"+m).getElementsByTagName("div");
		 var pclass=""
		 for(i=0;i<tli.length;i++){
		  tli[i].className=i==n?"hover":"";
		  mli[i].style.display=i==n?"block":"none";
		 }
		}


		function yincang(){
			 var tli=document.getElementById("menu1").getElementsByTagName("li");
			 var mli=document.getElementById("main1").getElementsByTagName("div");
			 for(var i=0;i<mli.length;i++){
				if(document.getElementById("c"+i).style.display=='block'){
					document.getElementById("c"+i).style.display='none';
				}
					tli[i].className="";				
			 }
		}

		function changeColor(val){
				document.getElementById(val).className="hover";
		}
		function returnColor(val){
		document.getElementById(val).className="";
			
		}
		function view(val){
			var count = val.substring(1,val.length);
			document.getElementById(val).style.display="block";
			var tli=document.getElementById("menu1").getElementsByTagName("li");
			tli[count].className="hover";
		}
		function doview(val){
		
				var count = val.substring(1,val.length);
				document.getElementById(val).style.display="none";
			var tli=document.getElementById("menu1").getElementsByTagName("li");
			tli[count].className="";
		}

