var RowSelector = (function(){

	function bindEvents() {
		$(document.body).observe('click', clickHandler);
	}
	
	function unbindEvents() {
		$(document.body).stopObserving('click', clickHandler);
	}
	
	function clickHandler(event) {
		var target = event.element();
		if (target.match('.rowSelector')) {
			toggleRow(target);
		} else if (target.match('.toggleAll')) {
			toggleAll(target);
		}
	}

	function toggleRow(checkbox) {
		var checked = checkbox.checked;
		checkbox.up('tr').select(':input:not(.rowSelector)').each(function(input){
			input.disabled = !checked;
		});
	}
	
	function toggleAll(checkbox) {
		var checked = checkbox.checked;
		checkbox.up('table').select('tbody :input').each(function(input){ 
			if (input.hasClassName('rowSelector')) {
				input.checked = checked;
			} else {
				input.disabled = !checked;
			}
		});
	}
	
	return {
		bindEvents: bindEvents,
		unbindEvents: unbindEvents
	};

})();
