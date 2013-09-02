$("document").ready(function() {
	
	var allMemberId = new Array();
	$
	.post('../memberAjax/loadMemberList.action', // 服务器要接受的url
			null, // 传递的参数
			// var params = {
			// loginName:$("#loginName").val(),
			// password:$("#password").val(),
			// }
			function callback(data) { // 显示列表
				var dataObj = eval("(" + data + ")");// 转换为json对象
				var listContent = "";
				$.each(dataObj,function(idx, item) {
					allMemberId.push(item.memberId);
									listContent += '<tr class="ifOpened" id="';
									listContent += item.memberId;
									listContent += '_r"><td class="vt" nowrap="nowrap" style="padding: 2px 2px 0 2px"><span class="SPRITE_star_off goog-inline-block vt" style="width: 15px; height: 15px;"></span></td><td class="vt id col_0"><a href="#">';
									listContent +=item.memberId; 
									listContent +='</a></td><td class="vt col_1" width="100%"><a onclick="cancelBubble=false" href="#">';
									listContent += item.memberName;
									listContent +='</a></td><td class="vt col_2"><a onclick="cancelBubble=false" href="#"style="white-space: nowrap">';
									listContent +=	item.memberProject;
									listContent +='</a></td><td class="vt col_3"><a class="SPRITE_paperclip goog-inline-block vt operator resetPassword" value="';
									listContent +=item.memberId;
									listContent += '"style="width: 16px; height: 16px;" title="重置密码"></a>';	
									listContent += '<a class="SPRITE_close_icon goog-inline-block vt operator deleteMember" value="';
									listContent +=item.memberId;
									listContent += '"style="width: 16px; height: 16px;" title="删除"></a></td></tr>';
								});
				$("#memberTable").html(listContent);
				$(".deleteMember").click(function(){
				//	var rowId =$(this).attr('value');
					var params = {delMemberId: $(this).attr('value')};
					$
					.post('../memberAjax/deleteMember.action',params,function callback(data) {
						window.location.href=window.location.href;
						});
					//alert(rowId);
					//$("tr[name^=rowId]").hide("slow");
					
				});
				$(".resetPassword").click(function(){
					//	var rowId =$(this).attr('value');
						var params = {resMemberId: $(this).attr('value')};
						$
						.post('../memberAjax/resMemberPsw.action',params,function callback(data) {
							alert(data);
							});
						//alert(rowId);
						//$("tr[name^=rowId]").hide("slow");
						
					});
			}, 'json');
	
	
	$("#add_member").click(function() {
		$(".add_member_wrap").dialog("open");
	});

	$(".add_member_wrap").dialog( {
		resizable : false,
		modal : true,
		autoOpen : false,
		height : 300,
		width : 360,
		title : "添加成员"
	});

	$(".form_member_input1").blur(function() {
		if (this.value == '') {
			this.value = this.title
		}
	});
	$(".form_member_input1").focus(function() {
		if (this.value == this.title) {
			this.value = ''
		}
	});

	var form = $("#add_member_form");
	form.submit(function() {
		if (validateId() & validateMember())
			return true
		else
			return false;
	});

	var addMemberAlert = $("#add_member_alert");
	var memberId = $("#memberId");
	
	function validateMember(){
		for(x in allMemberId){
			if(allMemberId[x] == memberId.val()){
				addMemberAlert.text("已有此成员");
				return false;
			}
		}
		return true;
	}
	
	function validateId() {
		var reg = /^[0-9]+$/;
		if (reg.exec(memberId.val()) == null) {
			addMemberAlert.text("请输入数字ID");
			return false;
		}
		else {
			addMemberAlert.text("");
			return true;
		}
	}
	
	
});