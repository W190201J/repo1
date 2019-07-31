$(function(){
		  $.ajax({
				method : 'get',
				url : '/chk',
				headers : createAuthorizationTokenHeader(),
				success : function(data) {
					
					if (data == 'fail') {
						location.href='login.html';
					} 
					if (checkPhone(data)) {					                
						 $(".phone").html(data+"<em></em>"); 
					}
				},
				dataType : 'text'
			});
	  });
	  
	  
	function checkPhone(code){ 
	    var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
	    if(!(myreg.test(code))){ 
	        return false; 
	    } 
	    return true;
	}

	 function logout() {
		 var dat= $('#usename').text();
		 
		 dat = dat.split(',')[0];
	    layer.confirm("真的要退出吗?", function(index) {    	
	    	$.ajax({
				method:'post',
				url:'../out',
				data:{phone:dat},
				success:function(data){
					if(data=="退出成功"){
						removeJwtToken();	
						layer.msg(data,{icon: 6,time: 2000,
							end:function(){
								location.href = "index.html";		
							}
						});
						
					}else{
						layer.msg('退出失败，请重试');
					}
					
					
				},
				dataType:'text'

			});
	      //window.location.href = "index.html"
	    })
	  }