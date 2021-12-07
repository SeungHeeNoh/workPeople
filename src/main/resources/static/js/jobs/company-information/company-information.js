(function() {
	let token = document.querySelector("meta[name='_csrf']").getAttribute("content"),
		tokenHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

	let body = document.body,
		dimmed = body.querySelector(".dimmed"),
		modal = dimmed.querySelector("#modal"),
		content = body.querySelector(".content"),
		infoHeader = content.querySelector(".info_header"),
		interestedCompanyCount = infoHeader.querySelector(".like_button .count"),
		floatingNaviWrapper = content.querySelector(".floating-navi"),
		floatingNavi = floatingNaviWrapper.querySelector(".floating-navi-inner"),
		naviTabs = floatingNavi.querySelectorAll("li"),
		information = content.querySelector(".information"),
		jobVacancyTable = information.querySelectorAll(".job_vacancy_table");

	let windowPageYOffset = window.pageYOffset,
		position = {
			floatingNaviWrapper : windowPageYOffset + floatingNaviWrapper.getBoundingClientRect().top,
			info : {}
		},
		positionNameArray = "",
		info = new Array(),
		jobVacancyTables = {},
		weekArray = new Array('일', '월', '화', '수', '목', '금', '토');

	jobVacancyTable.forEach(function(struct) {
		let name = struct.classList[1];

		if(!struct.querySelector("table").classList.contains("empty_result")){
			jobVacancyTables[name] = {
				tbody : struct.querySelector("table").querySelector("tbody"),
				companyInformationNo : struct.querySelector(".company_information_no").value,
				page : struct.querySelector(".page"),
				paging : {
					maxPrev : struct.querySelector(".paging .max_prev button"),
					prev : struct.querySelector(".paging .prev button"),
					pageNumber : struct.querySelector(".paging .page_number > ul"),
					next : struct.querySelector(".paging .next button"),
					maxNext : struct.querySelector(".paging .max_next button"),
					nowStart : struct.querySelector(".paging .page_number li:first-of-type button").getAttribute("data-page"),
					nowEnd : struct.querySelector(".paging .page_number li:last-of-type button").getAttribute("data-page"),
					maxPage : struct.querySelector(".paging .max_next button").getAttribute("data-page")
				}
			}
		}
	});

	function debounce(func) {
		let timer;

		return function(e) {
			if(timer) clearTimeout(timer);
			timer = setTimeout(func, 100, e);
		}
	}

	function init() {
		floatingNaviInit();
		window.addEventListener("scroll", scrollEventHandler);
		window.addEventListener("resize", debounce(resizeEventHandler));
		infoHeader.addEventListener("click", infoHeaderClickEventHandler);
		floatingNavi.addEventListener("click", naviClickEventHanlder);
		information.addEventListener("click", informationClickEventHandler);
		modal.addEventListener("click", modalClickEventHandler);
	}

	function floatingNaviInit() {
		positionNameArray = getPositionNameArray();

		positionNameArray.forEach(function(positionName) {
			info.push(information.querySelector("." + positionName));
		});

		setTimeout(function() {
			setInfoPosition();
			scrollEventHandler();
		}, 100);
	}

	function getPositionNameArray() {
		let nameArray = new Array();

		naviTabs.forEach(function(naviTab) {
			nameArray.push(naviTab.getAttribute("data-target"));
		});

		return nameArray;
	}

	function setInfoPosition() {
		info.forEach(function(info) {
			position.info[info.classList[1]] = windowPageYOffset + info.getBoundingClientRect().top;
		});
	}

	function scrollEventHandler() {
		let scrollTop = document.documentElement.scrollTop;

		if(position.floatingNaviWrapper < scrollTop) {
			floatingNavi.classList.add("fixed");

			floatingNaviClear();
			let flag = true;

			for(let i=1; i<naviTabs.length; i++) {
				if(scrollTop < position.info[positionNameArray[i]]-100) {
					naviTabs[i-1].classList.add("active");
					flag = false;
					break;
				}
			}

			if(flag) {
				naviTabs[naviTabs.length-1].classList.add("active");
			}
		} else {
			floatingNavi.classList.remove("fixed");
		}
	}

	function floatingNaviClear() {
		naviTabs.forEach(function(naviTab) {
			naviTab.classList.remove("active");
		});
	}

	function resizeEventHandler() {
		windowPageYOffset = window.pageYOffset;
		position.floatingNaviWrapper = windowPageYOffset + floatingNaviWrapper.getBoundingClientRect().top;
		setInfoPosition();
	}

	function infoHeaderClickEventHandler(e) {
		if(e.target.tagName == "BUTTON") {
			let button = e.target;

			if(button.classList.contains("login_button")) {
				openModal();
			} else {
				if(button.classList.contains("like_button")) {
					companyLikeButtonToggleEventHandler(button);
				}
			} 
		}
	}

	function companyLikeButtonToggleEventHandler(button) {
		button.setAttribute("disabled", true);
		let xhr = new XMLHttpRequest();

		if(button.classList.contains("active")) {
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) {
					if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
						deactiveLikeButton(button);
						if(xhr.response.interestedCompanyCount != null) {
							interestedCompanyCount.innerHTML = xhr.response.interestedCompanyCount;
						}
					} else {
						console.log("ajax 통신 실패");
					}
				}
			}

			xhr.open("DELETE", "/personal/mypage/interestedCompany/company/" + button.getAttribute("data-company-no"));
			xhr.setRequestHeader(tokenHeader, token);
			xhr.responseType = "json";
			xhr.send();
		} else {
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4) {
					if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
						activeLikeButton(button);
						if(xhr.response.interestedCompanyCount != null) {
							interestedCompanyCount.innerHTML = xhr.response.interestedCompanyCount;
						}
					} else {
						console.log("ajax 통신 실패");
					}
				}
			}

			xhr.open("POST", "/personal/mypage/interestedCompany/company/" + button.getAttribute("data-company-no"));
			xhr.setRequestHeader(tokenHeader, token);
			xhr.responseType = "json";
			xhr.send();
		}
		button.removeAttribute("disabled");
	}

	function activeLikeButton(button) {
		button.classList.add("active");
		button.querySelector("span").innerHTML = "해제";
	}

	function deactiveLikeButton(button) {
		button.classList.remove("active");
		button.querySelector("span").innerHTML = "설정";
	}

	function naviClickEventHanlder(e) {
		if(e.target.tagName == "LI") {
			window.scrollTo({top : position.info[e.target.getAttribute("data-target")] - floatingNavi.clientHeight, behavior:'smooth'});
		} 
	}

	function informationClickEventHandler(e) {
		if(e.target.closest(".progressing")) {
			progressingClickEventHandler(e.target)
		} else if(e.target.closest(".expired")) {
			expiredClickEventHandler(e.target);
		}
	}

	function progressingClickEventHandler(target) {
		if(target.tagName == "BUTTON") {
			let button = target;

			if(button.classList.contains("apply_button")) {
				openModal();
			} else if(button.closest(".paging")) {
				button.setAttribute("disabled", true);

				let jobVacancyTable = jobVacancyTables.progressing,
					page =  Number(button.getAttribute("data-page"));

				if(page != jobVacancyTable.page.value) {
					let xhr = new XMLHttpRequest();
					xhr.onreadystatechange = function() {
						if(xhr.readyState == 4) {
							if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
								updateJobVacancyTable(xhr.response, "progressing");
							} else {
								console.log("ajax 통신 실패");
							}
							if(button.closest(".page_number")) {
								button.removeAttribute("disabled");
							}
						}
					}
		
					xhr.open("POST", "/jobs/company-information/progressingJobVacancyData/" + jobVacancyTable.companyInformationNo + "/" + page);
					xhr.setRequestHeader(tokenHeader, token);
					xhr.responseType = "json";
					xhr.send();
				} else {
					button.removeAttribute("disabled");
				}
			}
		}
	}

	function expiredClickEventHandler(target) {
		if(target.tagName == "BUTTON") {
			let button = target;

			if(button.closest(".paging")) {
				button.setAttribute("disabled", true);

				let jobVacancyTable = jobVacancyTables.progressing,
					page =  Number(button.getAttribute("data-page"));

					if(page != jobVacancyTable.page.value) {
					let xhr = new XMLHttpRequest();
					xhr.onreadystatechange = function() {
						if(xhr.readyState == 4) {
							if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
								updateJobVacancyTable(xhr.response, "expired");
							} else {
								console.log("ajax 통신 실패");
							}
							if(button.closest(".page_number")) {
								button.removeAttribute("disabled");
							}
						}
					}
		
					xhr.open("POST", "/jobs/company-information/expireJobVacancydData/" + jobVacancyTable.companyInformationNo + "/" + page);
					xhr.setRequestHeader(tokenHeader, token);
					xhr.responseType = "json";
					xhr.send();
				} else {
					button.removeAttribute("disabled");
				}
			}
		}
	}

	function updateJobVacancyTable(data, type) {
		let jobVacancyTable = jobVacancyTables[type],
			paging = jobVacancyTable.paging
			page = data.pageInfo.page
			tbody = jobVacancyTable.tbody;

		if(page > paging.nowEnd || page < paging.nowStart) {
			paging.nowStart = data.pageInfo.startPage;
			paging.nowEnd = data.pageInfo.endPage;

			paging.pageNumber.innerHTML = "";
			for(let i=paging.nowStart; i<=paging.nowEnd; i++) {
				let html = "<li><button data-page='"+ i +"'>" + i + "</button></li>"

				paging.pageNumber.insertAdjacentHTML("beforeend", html);
			}

		} else {
			paging.pageNumber.querySelectorAll("button").forEach(function(pageButton) {
				pageButton.classList.remove("current_page");
			});
		}

		jobVacancyTable.page.value = page;
		paging.pageNumber.querySelector("button[data-page='" + page + "']").classList.add("current_page");

		paging.prev.setAttribute("data-page", (page-1 < 1 ? 1 : page-1));
		paging.next.setAttribute("data-page", (page+1 > paging.maxPage ? paging.maxPage : page+1));

		if(page == 1) {
			paging.maxPrev.setAttribute("disabled", true);
			paging.prev.setAttribute("disabled", true);
		} else {
			paging.maxPrev.removeAttribute("disabled");
			paging.prev.removeAttribute("disabled");
		}

		if(page == paging.maxPage) {
			paging.maxNext.setAttribute("disabled", true);
			paging.next.setAttribute("disabled", true);
		} else {
			paging.maxNext.removeAttribute("disabled");
			paging.next.removeAttribute("disabled");
		}

		tbody.innerHTML = "";
		for(let i=0; i<data.jobVacancyList.length; i++) {
			let jobVacancy = data.jobVacancyList[i],
				date = new Date(jobVacancy.periodEnd),
				experienceLevel = "";
			
			for(let j=0; j<jobVacancy.experienceLevelList.length; j++) {
				if(j != 0) experienceLevel += ", "
				experienceLevel += jobVacancy.experienceLevelList[j].name;
			}
			
			let html = "<tr>"
				html += "	<td><a href='/jobs/vacancy-detail/detail-view?no=" + jobVacancy.no + "'>" + jobVacancy.title + "</a></td>"
				html += "	<td>" + experienceLevel + " | " + jobVacancy.educationLevel.name + " </td>"
				html += "	<td>~" + (date.getMonth()+1) + "/" + date.getDate() + " (" + weekArray[date.getDay()] + ")</td>"
				if(type == "expired") {
					html += "	<td><button type='button' class='closed'>마감</button></td>"
				} else {
					html += "	<td><button type='button' class='green apply_button'>입사지원</button></td>"
				}

			tbody.insertAdjacentHTML("beforeend", html);
		}
	}

	function modalClickEventHandler(e) {
		if(e.target.tagName == "BUTTON") {
			let button = e.target;

			if(button.classList.contains("close_button")) {
				closeModal();
			} else if(button.classList.contains("open_resume")) {
				let resumeNo = button.getAttribute("data-resume-no"),
				option = 'top=50, left=150, width=920, height=600, status=no, menubar=no, toolbar=no, resizable=no';

					window.open("/jobs/vacancy-detail/resume-view?rNo=" + resumeNo, "이력서 보기", option);
			}
		}
	}

	function openModal() {
		body.classList.add("modal_open");
		dimmed.classList.add("show");
	}

	function closeModal() {
		body.classList.remove("modal_open");
		dimmed.classList.remove("show");
	}

	window.addEventListener("DOMContentLoaded", init);
})();
