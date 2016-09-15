$( document ).ready(function() {
	$(".deleteUser").click(function () {
		var r = confirm("Are you sure you want to delete?");
	    if (r == false) {
	        event.preventDefault();
	    }
	});
});