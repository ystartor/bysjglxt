var num_student_taskbook = 0;
//TODO 将这边的数据进行初始化
function addLunWen() {
	if (num_student_taskbook >= 1) {
		toastr.error("已存在修改论文，请先点击删除再上传");
		return;
	}
	// 总父容器
	var div_lunwen_recordprogress_box = document.getElementById("div_lunwen_recordprogress_box");

	// 创建input
	var input_lunwen_recordprogress = document.createElement("input");
	input_lunwen_recordprogress.type = "file";
	input_lunwen_recordprogress.id = "input_lunwen_recordprogress";
	input_lunwen_recordprogress.className = "";
	div_lunwen_recordprogress_box.appendChild(input_lunwen_recordprogress);
	input_lunwen_recordprogress.style.display = "none";
	input_lunwen_recordprogress.onchange = lunwenFileChange;
	input_lunwen_recordprogress.click();
}

function lunwenFileChange(qianRecordProgress) {
	num_student_taskbook++;
	var div_lunwen_recordprogress_box = document.getElementById("div_lunwen_recordprogress_box");
	var div_lunwen_recordprogress_father = document.createElement("div");
	var div_lunwen_recordprogress_img = document.createElement("img");
	var div_lunwen_recordprogress_name = document.createElement("a");
	var div_lunwen_recordprogress_del = document.createElement("div");

	div_lunwen_recordprogress_box.appendChild(div_lunwen_recordprogress_father);
	div_lunwen_recordprogress_father.appendChild(div_lunwen_recordprogress_img);
	div_lunwen_recordprogress_father.appendChild(div_lunwen_recordprogress_name);
	div_lunwen_recordprogress_father.appendChild(div_lunwen_recordprogress_del);
	
	div_lunwen_recordprogress_father.style.float = "left";
	div_lunwen_recordprogress_father.style.width = "100%";
	div_lunwen_recordprogress_father.style.margin = "0 0 20px 0";
	div_lunwen_recordprogress_father.id = "div_lunwen_recordprogress_father";
	
	
	
	div_lunwen_recordprogress_name.href = '/bysjglxt/graduationProject/GraduationProjectManagement_downloadTeacherLunWen?DissertationUserID='
		+ currentProcessDto.processInstance.process_instance_man;
	var xiazaiWanOk = document.getElementById("student_id_lunwen_record_progress_is_xiazai");
	if("1" == xiazaiWanOk.value){
		div_lunwen_recordprogress_name.style.color="green";
	}
	// 求出后缀
	if (qianRecordProgress == "[object Event]") {
		var input_annex_type = qianRecordProgress.target.files[0].name
				.substring(qianRecordProgress.target.files[0].name.lastIndexOf(".") + 1);
	} else {
		var input_annex_type = qianRecordProgress.substring(qianRecordProgress
				.lastIndexOf(".") + 1);
	}

	switch (input_annex_type) {
	case "doc":
	case "DOC":
	case "docx":
	case "DOCX": {
		div_lunwen_recordprogress_img.src = "../img/word.png";
		break;
	}
	default: {
		div_lunwen_recordprogress_img.src = "../img/unknown.png";
		break;
	}
	}

	div_lunwen_recordprogress_img.style.float = "left";
	div_lunwen_recordprogress_img.style.margin = "10px 10px 0 10px";

	if (qianRecordProgress == "[object Event]") {
		div_lunwen_recordprogress_name.innerHTML = qianRecordProgress.target.files[0].name;
	} else {
		div_lunwen_recordprogress_name.innerHTML = qianRecordProgress;
	}
	div_lunwen_recordprogress_name.style.width = "auto";
	div_lunwen_recordprogress_name.style.float = "left";
	div_lunwen_recordprogress_name.style.lineHeight = "32px";
	div_lunwen_recordprogress_name.style.margin = "10px 0 0 0";
	if (qianRecordProgress == "[object Event]") {
	} else {
		div_lunwen_recordprogress_name.className = "div_old_lunwen_recordprogress";
	}
	div_lunwen_recordprogress_del.id = "div_lunwen_recordprogress_del";
	div_lunwen_recordprogress_del.innerHTML = "X";
	div_lunwen_recordprogress_del.style.width = "auto";
	div_lunwen_recordprogress_del.style.float = "left";
	div_lunwen_recordprogress_del.style.backgroundColor = "#d9534f";
	div_lunwen_recordprogress_del.style.color = "white";
	div_lunwen_recordprogress_del.style.margin = "10px 0 0 10px";
	div_lunwen_recordprogress_del.style.padding = "5px 10px";
	div_lunwen_recordprogress_del.style.borderRadius = "50%";
	div_lunwen_recordprogress_del.style.cursor = "pointer";
	div_lunwen_recordprogress_del.onclick = delLunWen;
}
function delLunWen() {
	num_student_taskbook--;
	var div_lunwen_recordprogress_box = document.getElementById("div_lunwen_recordprogress_box");
	var div_lunwen_recordprogress_father = document
			.getElementById("div_lunwen_recordprogress_father");
	var input_lunwen_recordprogress = document.getElementById("input_lunwen_recordprogress");

	div_lunwen_recordprogress_box.removeChild(div_lunwen_recordprogress_father);
	if (input_lunwen_recordprogress != null) {
		div_lunwen_recordprogress_box.removeChild(input_lunwen_recordprogress);
	}
}