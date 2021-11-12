(function() {
	let login = document.querySelector(".login_area"),
		typeChangeTab = login.querySelector(".type_change_tab"),
		loginForm = login.querySelector("form"),
		memberTypeInput = loginForm.querySelector("input[name='member_type']");

	function init() {
		typeChangeTab.addEventListener("click", typeChangeTabClickEventHandler);
	}

	function typeChangeTabClickEventHandler(e) {
		typeChangeTab.querySelectorAll("li").forEach(function(item, index) {
			item.classList.remove("active");
		});

		e.target.classList.add("active");
		memberTypeInput.value = e.target.getAttribute("data-member-type");
	}

	window.addEventListener("DOMContentLoaded", init);
})();
